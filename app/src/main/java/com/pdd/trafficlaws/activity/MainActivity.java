package com.pdd.trafficlaws.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.callcentre.activity.CallCentreActivity;
import com.pdd.trafficlaws.fine.FineActivity;
import com.pdd.trafficlaws.gasStationPrices.GasStationPricesActivity;
import com.pdd.trafficlaws.sdakr.TrafficLawsActivity;

import java.util.Locale;

import io.opencensus.resource.Resource;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView shtraf;
    private CardView trafficLaws;
    private CardView callCentre;
    private CardView gas_station_prices;
    private CardView auto_news_cr;
    private CardView car_insurance;
    private CardView addition;
    private SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupListeners();
        Toolbar toolbar = findViewById(R.id.app_bar_layout);
        setSupportActionBar(toolbar);
    }

    private void setupListeners() {
        addition.setOnClickListener(this);
        car_insurance.setOnClickListener(this);
        auto_news_cr.setOnClickListener(this);
        gas_station_prices.setOnClickListener(this);
        callCentre.setOnClickListener(this);
        trafficLaws.setOnClickListener(this);
        shtraf.setOnClickListener(this);
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.setLocale(new Locale("ky"));
                res.updateConfiguration(conf, dm);
                getSharedPreferences("settings", MODE_PRIVATE).edit().putBoolean("ky", true).apply();
                finish();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.animation, R.anim.animationtwo);
            } else {
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.setLocale(new Locale(""));
                res.updateConfiguration(conf, dm);
                getSharedPreferences("settings", MODE_PRIVATE).edit().putBoolean("ky", false).apply();
                finish();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.animation, R.anim.animationtwo);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language_menu, menu);
        return true;
    }

    private void setupViews() {
        shtraf = findViewById(R.id.fines);
        trafficLaws = findViewById(R.id.trafficLaws);
        callCentre = findViewById(R.id.callCentre);
        gas_station_prices = findViewById(R.id.gas_station_prices);
        auto_news_cr = findViewById(R.id.auto_news_cr);
        car_insurance = findViewById(R.id.car_insurance);
        addition = findViewById(R.id.addition);
        switchCompat = findViewById(R.id.switchCompat);
        switchCompat.setChecked(getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", true));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addition:
                launchActivity(AdditionActivity.class);
                break;
            case R.id.car_insurance:
                launchActivity(CarInsuranceActivity.class);
                break;
            case R.id.auto_news_cr:
                launchActivity(AutoNewsCarActivity.class);
                break;
            case R.id.gas_station_prices:
                launchActivity(GasStationPricesActivity.class);
                break;
            case R.id.callCentre:
                launchActivity(CallCentreActivity.class);
                break;
            case R.id.trafficLaws:
                launchActivity(TrafficLawsActivity.class);
                break;
            case R.id.fines:
                launchActivity(FineActivity.class);
                break;
        }
    }

    private void launchActivity(Class<?> calledActivity) {
        startActivity(new Intent(MainActivity.this, calledActivity));
    }
}

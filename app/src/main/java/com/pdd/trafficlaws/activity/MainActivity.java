package com.pdd.trafficlaws.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.callcentre.activity.CallCentreActivity;
import com.pdd.trafficlaws.fine.FineActivity;
import com.pdd.trafficlaws.frequent.FrequentActivity;
import com.pdd.trafficlaws.gasStationPrices.GasStationPricesActivity;
import com.pdd.trafficlaws.osago.CarInsuranceActivity;
import com.pdd.trafficlaws.sdakr.TrafficLawsActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView shtraf;
    private CardView trafficLaws;
    private CardView callCentre;
    private CardView gas_station_prices;
    private CardView car_insurance;
    private CardView addition;
    private CardView webView;
    private CardView frequent;
    private SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLanguage();
        setContentView(R.layout.activity_main);
        setupViews();
        setupListeners();
        Toolbar toolbar = findViewById(R.id.app_bar_layout);
        setSupportActionBar(toolbar);
    }

    private void setupListeners() {
        addition.setOnClickListener(this);
        car_insurance.setOnClickListener(this);
        gas_station_prices.setOnClickListener(this);
        callCentre.setOnClickListener(this);
        trafficLaws.setOnClickListener(this);
        shtraf.setOnClickListener(this);
        webView.setOnClickListener(this);
        frequent.setOnClickListener(this);
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
        car_insurance = findViewById(R.id.car_insurance);
        frequent = findViewById(R.id.frequently_violated_traffic_rules);
        addition = findViewById(R.id.addition);
        webView = findViewById(R.id.webViewid);
        switchCompat = findViewById(R.id.switchCompat);
        Boolean isKyrgyz = getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", true);
        switchCompat.setChecked(isKyrgyz);
    }

    private void setLanguage() {
        Boolean isKyrgyz = getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", true);
        if (isKyrgyz) {
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.setLocale(new Locale("ky"));
            res.updateConfiguration(conf, dm);
        } else {
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.setLocale(new Locale(""));
            res.updateConfiguration(conf, dm);
        }
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
            case R.id.webViewid:
                launchActivity(WebViewActivity.class);
                break;
            case R.id.frequently_violated_traffic_rules:
                launchActivity(FrequentActivity.class);
                break;
        }
    }

    private void launchActivity(Class<?> calledActivity) {
        startActivity(new Intent(MainActivity.this, calledActivity));
    }
}

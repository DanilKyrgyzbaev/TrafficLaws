package com.pdd.trafficlaws.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
    private boolean isKyrgyz;

    private TextView pddText, frequentText, finesText, trafficLawsText, callcentreText, gas_station_pricesText, fine_checkText, additionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isKyrgyz = getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", true);
        setupViews();
        setupListeners();
        Toolbar toolbar = findViewById(R.id.app_bar_layout);
        setSupportActionBar(toolbar);
        changeLanguage(isKyrgyz);
    }

    private void setupListeners() {
        addition.setOnClickListener(this);
//        car_insurance.setOnClickListener(this);
        gas_station_prices.setOnClickListener(this);
        callCentre.setOnClickListener(this);
        trafficLaws.setOnClickListener(this);
        shtraf.setOnClickListener(this);
        webView.setOnClickListener(this);
        frequent.setOnClickListener(this);
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                getSharedPreferences("settings", MODE_PRIVATE).edit().putBoolean("ky", true).apply();
            } else {
                getSharedPreferences("settings", MODE_PRIVATE).edit().putBoolean("ky", false).apply();
            }
            changeLanguage(isChecked);
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
      //  car_insurance = findViewById(R.id.car_insurance);
        frequent = findViewById(R.id.frequently_violated_traffic_rules);
        addition = findViewById(R.id.addition);
        webView = findViewById(R.id.webViewid);
        switchCompat = findViewById(R.id.switchCompat);
        switchCompat.setChecked(isKyrgyz);
        pddText = findViewById(R.id.pdd_text);
        frequentText = findViewById(R.id.tv_frequent);
        finesText = findViewById(R.id.tv_fines);
        trafficLawsText = findViewById(R.id.tv_trafficLaws);
        callcentreText = findViewById(R.id.tv_callcentre);
        gas_station_pricesText = findViewById(R.id.tv_gas_station_prices);
        fine_checkText = findViewById(R.id.tv_fine_check);
        additionText = findViewById(R.id.tv_addition);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addition:
                launchActivity(AdditionActivity.class);
                break;
//            case R.id.car_insurance:
//                launchActivity(CarInsuranceActivity.class);
//                break;
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

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this).setTitle("Подтвердите действие ")
                    .setMessage("Вы действительно хотите выйти?")
                    .setNegativeButton(android.R.string.no, (dialog, which) -> dialog.dismiss())
                    .setPositiveButton(android.R.string.yes, (arg0, arg1) -> {
                        finish();
                    }).create().show();
    }


    private void changeLanguage(boolean ky){
        if (ky) {
            pddText.setText(getResources().getText(R.string.pddKg));
            frequentText.setText(getResources().getText(R.string.frequentKg));
            finesText.setText(getResources().getText(R.string.finesKg));
            trafficLawsText.setText(getResources().getText(R.string.trafficLawsKg));
            callcentreText.setText(getResources().getText(R.string.callcentreKg));
            gas_station_pricesText.setText(getResources().getText(R.string.gas_station_pricesKg));
            fine_checkText.setText(getResources().getText(R.string.fine_checkKg));
            additionText.setText(getResources().getText(R.string.additionKg));
        } else {
            pddText.setText(getResources().getText(R.string.pdd));
            frequentText.setText(getResources().getText(R.string.frequent));
            finesText.setText(getResources().getText(R.string.fines));
            trafficLawsText.setText(getResources().getText(R.string.trafficLaws));
            callcentreText.setText(getResources().getText(R.string.callcentre));
            gas_station_pricesText.setText(getResources().getText(R.string.gas_station_prices));
            fine_checkText.setText(getResources().getText(R.string.fine_check));
            additionText.setText(getResources().getText(R.string.addition));
        }
    }
//    private TextView pddText, frequentText, finesText, trafficLawsText, callcentreText, gas_station_pricesText, fine_checkText, additionText;

}

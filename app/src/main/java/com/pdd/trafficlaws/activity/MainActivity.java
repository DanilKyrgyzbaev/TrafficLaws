package com.pdd.trafficlaws.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.callcentre.CallCentreActivity;
import com.pdd.trafficlaws.sda_kr.TrafficLawsActivity;
import com.pdd.trafficlaws.fine.FineActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView shtraf;
    private CardView trafficLaws;
    private CardView callCentre;
    private CardView gas_station_prices;
    private CardView auto_news_cr;
    private CardView car_insurance;
    private CardView addition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupListeners();
    }

    private void setupListeners() {
        addition.setOnClickListener(this);
        car_insurance.setOnClickListener(this);
        auto_news_cr.setOnClickListener(this);
        gas_station_prices.setOnClickListener(this);
        callCentre.setOnClickListener(this);
        trafficLaws.setOnClickListener(this);
        shtraf.setOnClickListener(this);
    }

    private void setupViews() {
        shtraf = findViewById(R.id.fines);
        trafficLaws = findViewById(R.id.trafficLaws);
        callCentre = findViewById(R.id.callCentre);
        gas_station_prices = findViewById(R.id.gas_station_prices);
        auto_news_cr = findViewById(R.id.auto_news_cr);
        car_insurance = findViewById(R.id.car_insurance);
        addition = findViewById(R.id.addition);
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

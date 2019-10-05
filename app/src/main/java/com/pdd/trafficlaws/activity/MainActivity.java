package com.pdd.trafficlaws.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pdd.trafficlaws.R;

public class MainActivity extends AppCompatActivity {

    CardView shtraf;
    CardView trafficLaws;
    CardView callCentre;
    CardView gas_station_prices;
    CardView auto_news_cr;
    CardView car_insurance;
    CardView addition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        shtraf = findViewById(R.id.fines);
        trafficLaws = findViewById(R.id.trafficLaws);
        callCentre = findViewById(R.id.callCentre);
        gas_station_prices = findViewById(R.id.gas_station_prices);
        auto_news_cr = findViewById(R.id.auto_news_cr);
        car_insurance = findViewById(R.id.car_insurance);
        addition = findViewById(R.id.addition);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AdditionActivity.class));
            }
        });

        car_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CarInsuranceActivity.class));
            }
        });

        auto_news_cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AutoNewsCarActivity.class));
            }
        });

        gas_station_prices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,GasStationPricesActivity.class));
            }
        });

        callCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CallCentreActivity.class));
            }
        });

        trafficLaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TrafficLawsActivity.class));
            }
        });

        shtraf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShtrafActivity.class));
            }
        });
    }


}

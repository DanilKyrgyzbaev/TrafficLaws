package com.pdd.trafficlaws.gasStationPrices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pdd.trafficlaws.R;

import io.grpc.Internal;


public class GasStationPricesActivity extends AppCompatActivity {
    private CardView gazprom_neft_asia_cardview ;
    private CardView bishkek_petrolium_asia;
    private CardView redpetrolium_cardview;
    private CardView rosneft_cardview;
    private TextView sda_kr_on_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station_prices);
        gazprom_neft_asia_cardview1();
        bishkek_petrolium_cardview();
        redpetrolium();
        rosneft();

        sda_kr_on_result = findViewById(R.id.sda_kr_on_result);

        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
           sda_kr_on_result.setText(getText(R.string.gas_station_pricesKg));
        }
    }

    public void gazprom_neft_asia_cardview1(){
        gazprom_neft_asia_cardview = findViewById(R.id.gazprom_neft_asia1_cardview);
        gazprom_neft_asia_cardview.setOnClickListener(v -> {
            Intent intent = new Intent(GasStationPricesActivity.this,GazpromNeftAsialActivity.class);
            startActivity(intent);
        });
    }

    public void bishkek_petrolium_cardview(){
        bishkek_petrolium_asia = findViewById(R.id.bishkek_petrolium_asia_cardview);
        bishkek_petrolium_asia.setOnClickListener(v -> {
            Intent intent = new Intent(GasStationPricesActivity.this,BishkekPetroliumActivity.class);
            startActivity(intent);
        });

    }

    public void redpetrolium (){
        redpetrolium_cardview = findViewById(R.id.red_petroleum_cardview);
        redpetrolium_cardview.setOnClickListener(v -> {
            Intent intent = new Intent(GasStationPricesActivity.this,RedPetroliumActivity.class);
            startActivity(intent);
        });
    }

    public void rosneft (){
        rosneft_cardview = findViewById(R.id.rosneft_cardview);
        rosneft_cardview.setOnClickListener(v -> {
            Intent intent = new Intent(GasStationPricesActivity.this,RosneftBNKActivity.class);
            startActivity(intent);
        });

    }


    public void onClick(View view) {
        onBackPressed();
    }
}

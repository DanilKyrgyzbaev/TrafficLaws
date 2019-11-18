package com.pdd.trafficlaws.gasStationPrices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.pdd.trafficlaws.R;

public class GasStationPricesActivity extends AppCompatActivity {
  private Toolbar toolbar;
  private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station_prices);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        cardView = findViewById(R.id.gazprom_neft_asia1_cardview);
        cardView.setOnClickListener(v -> {
            Intent intent = new Intent(GasStationPricesActivity.this,GazpromNeftAsialActivity.class);
            startActivity(intent);
        });

    }
}

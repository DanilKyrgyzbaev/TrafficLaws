package com.pdd.trafficlaws.gasStationPrices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.pdd.trafficlaws.R;

import org.json.JSONArray;
import org.json.JSONException;

public class GasStationPricesActivity extends AppCompatActivity {

    private ImageView imageView;

    static final String BNKURL = "http://johnyzak.ru/gazpromprices.php";

    private final String  PRICE = "price";
    private final String SOM = " сом";

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

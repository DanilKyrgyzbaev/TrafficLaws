package com.pdd.trafficlaws.gasStationPrices;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.pdd.trafficlaws.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GazpromNeftAsialActivity extends AppCompatActivity {
    private TextView ai98;
    private TextView ai95;
    private TextView ai92;
    private TextView ai80;
    private TextView gaz_price;
    private TextView diesel_fuel;
    private TextView diesel_fuel_winter;
    private RequestQueue mQueue;

    static final String BNKURL = "http://johnyzak.ru/gazpromprices.php";
    private final String  PRICE = "price";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazprom_neft_asial);

        ai98 = findViewById(R.id.ai98);
        ai95 = findViewById(R.id.ai95);
        ai92 = findViewById(R.id.ai92);
        ai80 = findViewById(R.id.ai80);
        diesel_fuel = findViewById(R.id.diesel_fuel);
        diesel_fuel_winter = findViewById(R.id.diesel_fuel_winter);
        gaz_price = findViewById(R.id.gaz_price);


        mQueue = Volley.newRequestQueue(this);
        getApi();

    }

    public void onClick(View view) {
        finish();
    }

    private void getApi() {
        Log.e("-----------", "getApi");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, BNKURL, null, response -> {
            try {
                JSONArray jsonArray = response.getJSONArray("gazprom");
                  ai98.setText(jsonArray.getJSONObject(1).getString(PRICE )+ " сом");
                  ai95.setText(jsonArray.getJSONObject(2).getString("price" )+ " сом");
                  ai92.setText(jsonArray.getJSONObject(3).getString("price" )+ " сом");
                  ai80.setText(jsonArray.getJSONObject(4).getString("price" )+ "");
                  diesel_fuel.setText(jsonArray.getJSONObject(5).getString("price" )+ " сом");
                diesel_fuel_winter.setText(jsonArray.getJSONObject(6).getString("price" )+ " сом");
                 gaz_price.setText(jsonArray.getJSONObject(7).getString("price" )+ " сом");



            } catch (JSONException e) {
                Log.e("-------", e.getMessage());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("-----------", error.getMessage());
            }
        });
        mQueue.add(request);
        Log.e("-----------", "end");
    }
}

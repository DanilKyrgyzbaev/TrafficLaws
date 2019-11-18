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
    private ImageView imageView;
    private TextView ai98;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazprom_neft_asial);

        ai98 = findViewById(R.id.ai98);

        mQueue = Volley.newRequestQueue(this);
        getApi();

    }

    public void onClick(View view) {
        finish();
    }

    private void getApi() {
        Log.e("-----------", "getApi");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://johnyzak.ru/gazpromprices.php", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("gazprom");
                    ai98.setText(jsonArray.getJSONObject(1).getString("price" )+ " сом");
                    jsonArray.getJSONObject(2).getString("price");
                    jsonArray.getString(3);
                    jsonArray.getString(4);
                    jsonArray.getString(5);
                    jsonArray.getString(6);
                    jsonArray.getString(7);

                } catch (JSONException e) {
                    Log.e("-------", e.getMessage());
                }

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

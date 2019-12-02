package com.pdd.trafficlaws.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pdd.trafficlaws.R;

public class AutoNewsCarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_news_car);

    }

    public void onClick(View view) {
        finish();
    }
}

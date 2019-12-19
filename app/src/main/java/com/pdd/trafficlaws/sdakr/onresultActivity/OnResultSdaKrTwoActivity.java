package com.pdd.trafficlaws.sdakr.onresultActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.sdakr.model.ModelSdaKR;

public class OnResultSdaKrTwoActivity extends AppCompatActivity  {
    private TextView description;
    private TextView general_provisions;
    private ModelSdaKR modelSdaKrTwo;
    final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;
    private String SDAKR = "SdaKr";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result_sda_kr_two);

        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            SDAKR = "SdaKrKg";
        } else {
            SDAKR = "SdaKr";
        }

        modelSdaKrTwo = (ModelSdaKR) getIntent().getSerializableExtra("SdaKr");

        description = findViewById(R.id.sda_kr_on_result_text);
        description.setTextSize(mRatio + 15);
        general_provisions = findViewById(R.id.sda_kr_on_result);

        general_provisions.setText(modelSdaKrTwo.getGeneral_provisions());
        description.setText(modelSdaKrTwo.getDescription());
        description.setText(modelSdaKrTwo.getDescription().replaceAll("xx", System.getProperty("line.separator")));

        description.setOnTouchListener((v, event) -> {
            // TODO Auto-generated method stub
            if (event.getPointerCount() == 1) {
                Log.d("Scroll", "1-pointer touch");
                v.getParent().requestDisallowInterceptTouchEvent(false);

            }
            if (event.getPointerCount() == 2) {
                Log.d("Zoom", "2-pointer touch");
                int action = event.getAction();
                int mainaction = action & MotionEvent.ACTION_MASK;
                if (mainaction == MotionEvent.ACTION_POINTER_DOWN) {
                    mBaseDist = getDistance(event);
                    mBaseRatio = mRatio;
                } else {
                    float scale = (getDistance(event) - mBaseDist) / STEP;
                    float factor = (float) Math.pow(2, scale);
                    mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * factor));
                    description.setTextSize(mRatio + 15);
                }
                v.getParent().requestDisallowInterceptTouchEvent(true);

            }
            return true;
        });

    }

    private int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

    public void onClick2(View view) {
        onBackPressed();
    }

}



package com.pdd.trafficlaws.sdakr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.pdd.trafficlaws.R;
//OnTouchListener

public class OnResultSdaKrActivity extends AppCompatActivity implements View.OnTouchListener {
    private Toolbar toolbar;
    private TextView description;
    private TextView general_provisions;
    private ModelSdaKR modelSdaKR;
    final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;
    private CardView cardView;
    private TextView textViewzoom;
    private ModelSdaKrTwo modelSdaKrTwo;
    private String SDAKR = "SdaKr";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result_sda_kr);

        modelSdaKR = (ModelSdaKR) getIntent().getSerializableExtra(SDAKR);
        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            SDAKR = "SdaKrKg";
        } else {
            SDAKR = "SdaKr";
        }



//sda_kr_on_result_text
        cardView = findViewById(R.id.card_view);



        toolbar = findViewById(R.id.sda_kr_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
          description = findViewById(R.id.sda_kr_on_result_text);
          description.setTextSize(mRatio + 15);

        general_provisions = findViewById(R.id.sda_kr_on_result);
        toolbar.setCollapseContentDescription("hknglhkg;");
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        description.setText(modelSdaKR.getDescription());
        general_provisions.setText(modelSdaKR.getGeneral_provisions());


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
    public boolean onTouchEvent (MotionEvent event){
        if (event.getPointerCount() == 2){
            int action = event.getAction();
            int mainaction = action&MotionEvent.ACTION_MASK;
            if (mainaction == MotionEvent.ACTION_POINTER_DOWN){
                mBaseDist = getDistance(event);
                mBaseRatio = mRatio;
            }else {
                float scale = (getDistance(event)- mBaseDist)/STEP;
                float factor = (float) Math.pow(2,scale);
                mRatio = Math.min(1024.0f,Math.max(0.1f,mBaseRatio*factor));
                general_provisions.setTextSize(mRatio+15);
            }
        }
        return true;
    }

    private int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

}


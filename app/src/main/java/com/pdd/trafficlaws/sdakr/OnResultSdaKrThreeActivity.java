package com.pdd.trafficlaws.sdakr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pdd.trafficlaws.R;

public class OnResultSdaKrThreeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView description;
    private TextView general_provisions;
    private ModelSdaKrThree modelSdaKrThree;
    private String SDAKR = "SdaKr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result_sda_kr_three);

        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            SDAKR = "SdaKrKg";
        } else {
            SDAKR = "SdaKr";
        }

        modelSdaKrThree= (ModelSdaKrThree) getIntent().getSerializableExtra(SDAKR);
        toolbar = findViewById(R.id.sda_kr_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        description = findViewById(R.id.sda_kr_on_result_text);
        general_provisions = findViewById(R.id.sda_kr_on_result);
        toolbar.setCollapseContentDescription("hknglhkg;");
//        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        general_provisions.setText(modelSdaKrThree.getGeneral_provisions());
        description.setText(modelSdaKrThree.getDescription());

    }
}

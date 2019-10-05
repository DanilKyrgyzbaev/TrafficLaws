package com.pdd.trafficlaws.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.pdd.trafficlaws.R;

public class CallCentreActivity extends AppCompatActivity {

    Toolbar toolbar;
    ExpandableCardView expandableCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_centre);
        expandableCardView = findViewById(R.id.expandable_cardView);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        expandableCardView.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                
            }
        });
    }
}
//card.setOnExpandedListener(new OnExpandedListener() {
//    @Override
//    public void onExpandChanged(View v, boolean isExpanded) {
//        Toast.makeText(applicationContext, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
//    }
//});
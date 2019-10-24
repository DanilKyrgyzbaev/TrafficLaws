package com.pdd.trafficlaws.callcentre;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.alespero.expandablecardview.ExpandableCardView;
import com.pdd.trafficlaws.R;

public class CallCentreActivity extends AppCompatActivity {
    private ExpandableCardView expandableCardView;
    private TextView textView112;
    private TextView textView101;
    private TextView textView102;
    private TextView textView103;
    private  TextView textView104;
    private  TextView textView110;
    private  Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_centre);
        setubView();
        setSupportActionBar(toolbar);

        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallCentreActivity.this.onBackPressed();
            }
        });
        expandableCardView.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
            }
        });
        textView104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call104("104");
            }

            private void call104( final  String phoneNumber) {
                startDialActivity(phoneNumber);
            }
        });
        textView103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call103("103");
            }

            private void call103( final String phoneNumber) {
                startDialActivity(phoneNumber);
            }
        });
        textView102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call102("102");
            }
            private void call102( final  String phoneNumber) {
                startDialActivity(phoneNumber);
            }
        });
        textView101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call101("101");
            }
            private void call101(final  String phoneNumber) {
                startDialActivity(phoneNumber);
            }
        });
        textView112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone("112");
            }

            private void dialContactPhone(final String phoneNumber) {
                startDialActivity(phoneNumber);
            }
        });
        textView110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call110("110");

            }
            private void call110( final String phoneNumber) {
                startDialActivity(phoneNumber);
            }
        });
    }


    private void setubView(){
        textView101 = findViewById(R.id.call101);
        textView102 = findViewById(R.id.call102);
        textView103 = findViewById(R.id.call103);
        textView104 = findViewById(R.id.call104);
        textView110 = findViewById(R.id.call110);
        textView112 = findViewById(R.id.call112);
        expandableCardView = findViewById(R.id.profil);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
    }



    private void startDialActivity(String phoneNumber){
        startActivity(new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",phoneNumber,null)));
    }
}

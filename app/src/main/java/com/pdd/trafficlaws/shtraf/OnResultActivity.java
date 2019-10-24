package com.pdd.trafficlaws.shtraf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pdd.trafficlaws.R;

public class OnResultActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView chast;
    private TextView fabula;
    private TextView statiya;
    private TextView violation;
    private TextView fines;
    private TextView individual_prices;
    private TextView entities_prices;
    private TextView individual;
    private TextView entities;
    private TextView category;
    private TextView note;
    private TextView absent;

    private ModelStatiya modelStatiya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result);

        modelStatiya = (ModelStatiya) getIntent().getSerializableExtra("shtraf");

        chast = findViewById(R.id.chastei);
        fabula = findViewById(R.id.fabula);
        statiya = findViewById(R.id.toolbar_statiya);
        violation = findViewById(R.id.violation);
        fines = findViewById(R.id.fines);
        individual_prices = findViewById(R.id.individual_prices);
        entities_prices = findViewById(R.id.entities_prices);
        individual = findViewById(R.id.individual);
        entities = findViewById(R.id.entities);
        category = findViewById(R.id.category);
        note = findViewById(R.id.note);
        absent = findViewById(R.id.absent);

        fines.setText(modelStatiya.getFines());
        chast.setText("Часть"+modelStatiya.getChast());
        fabula.setText(modelStatiya.getFabula());
        statiya.setText("Статья-" + modelStatiya.getStatiya());
        violation.setText(modelStatiya.getViolation());
        individual_prices.setText(modelStatiya.getIndividual_prices());
        entities_prices.setText(modelStatiya.getEntities_prices());
        individual.setText(modelStatiya.getIndividual());
        entities.setText(modelStatiya.getEntities());
        category.setText(modelStatiya.getCategory());
        note.setText(modelStatiya.getNote());
        absent.setText(modelStatiya.getAbsent());


        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}

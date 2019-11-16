package com.pdd.trafficlaws.fine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pdd.trafficlaws.R;

public class OnResultFineActivity extends AppCompatActivity {
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

    private ModelFine modelFine;
    private String FINE = "fine";
    private String STATIYA = "Статья-";
    private String CHAST = "Часть";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result_fine);

        modelFine = (ModelFine) getIntent().getSerializableExtra(FINE);

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

        fines.setText(modelFine.getFines());
        chast.setText(CHAST+ modelFine.getChast());
        fabula.setText(modelFine.getFabula());
        statiya.setText(STATIYA + modelFine.getStatiya());
        violation.setText(modelFine.getViolation());
        individual_prices.setText(modelFine.getIndividual_prices());
        entities_prices.setText(modelFine.getEntities_prices());
        individual.setText(modelFine.getIndividual());
        entities.setText(modelFine.getEntities());
        category.setText(modelFine.getCategory());
        note.setText(modelFine.getNote());
        absent.setText(modelFine.getAbsent());


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
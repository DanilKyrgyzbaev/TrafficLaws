package com.pdd.trafficlaws.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.pdd.trafficlaws.R;

public class AdditionActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    private Button calculate;
    private TextView result;
    private EditText editText;



    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        editText = findViewById(R.id.edittext);
        result = findViewById(R.id.text6);
        calculate = findViewById(R.id.buttonCalculate);
        Spinner spinner = findViewById(R.id.spiner);
        Spinner spinnertwo = findViewById(R.id.spinertwo);



        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.array));
        spinner.setAdapter(adapter);

        ArrayAdapter<?> adapterone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrayone));

        ArrayAdapter<?> adaptertwo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arraytwo));

        ArrayAdapter<?> adapterthree = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arraythree));

        ArrayAdapter<?> adapterfour = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrayfour));

        ArrayAdapter<?> adapterfive = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrayfive));

        ArrayAdapter<?> adaptersix = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arraysix));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getSelectedItemPosition()){
                    case 0:
                        spinnertwo.setAdapter(adapterone);
                        break;
                    case 1:
                        spinnertwo.setAdapter(adaptertwo);
                        break;
                    case 2:
                        spinnertwo.setAdapter(adapterthree);
                        break;
                    case 3:
                        spinnertwo.setAdapter(adapterfour);
                        break;
                    case 4:
                        spinnertwo.setAdapter(adapterfive);
                        break;
                    case 5:
                        spinnertwo.setAdapter(adaptersix);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                finish();
            }
        });



        calculate.setOnClickListener(v -> {
            if (editText.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Введите объём", Toast.LENGTH_LONG).show();
            }
            else {

                switch (spinner.getSelectedItemPosition()) {
                    case 0:
                        switch (spinnertwo.getSelectedItemPosition()) {
                            case 0:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.90 + " сом");
                                break;
                            case 1:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.75 + " сом");
                                break;
                            case 2:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.60 + " сом");
                                break;
                            case 3:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.45 + " сом");
                                break;
                        }
                        break;
                    case 1:
                        switch (spinnertwo.getSelectedItemPosition()) {
                            case 0:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.75 + " сом");
                                break;
                            case 1:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.60 + " сом");
                                break;
                            case 2:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.45 + " сом");
                                break;
                            case 3:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.30 + " сом");
                                break;
                        }
                        break;
                    case 2:
                        switch (spinnertwo.getSelectedItemPosition()) {
                            case 0:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.30 + " сом");
                                break;
                            case 1:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.15 + " сом");
                                break;
                        }
                        break;
                    case 3:
                        switch (spinnertwo.getSelectedItemPosition()) {
                            case 0:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.10 + " сом");
                                break;
                            case 1:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.05 + " сом");
                                break;
                        }
                        break;
                    case 4:
                        switch (spinnertwo.getSelectedItemPosition()) {
                            case 0:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.15 + " сом");
                                break;
                            case 1:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 0.09 + " сом");
                                break;
                        }
                        break;
                    case 5:
                        switch (spinnertwo.getSelectedItemPosition()) {
                            case 0:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 1.8 + " сом");
                                break;
                            case 1:
                                result.setText(Double.parseDouble(editText.getText().toString()) * 1.2 + " сом");
                                break;
                        }
                        break;
                }
            }
        });

    }

    public void onClick(View view) {
        onBackPressed();
    }
}

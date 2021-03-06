package com.pdd.trafficlaws.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private TextView sda_kr_on_result;



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

        sda_kr_on_result = findViewById(R.id.sda_kr_on_result);


        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            sda_kr_on_result.setText(getText(R.string.additionKg));
        }



//  final ArrayAdapter<String> spinnerArrayAdapter=new ArrayAdapter<String>(activity,R.layout.spinner_item,android.R.id.text1,spinnerItemsList)
//  { @Override public View getDropDownView(final int position,final View convertView,final ViewGroup parent)
//  { final View v=super.getDropDownView(position,convertView,parent); v.post(new Runnable() { @Override public void run()
//  { ((TextView)v.findViewById(android.R.id.text1)).setSingleLine(false); } }); return v; } };
//  spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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



        calculate.setOnClickListener(view -> {
            if (editText.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Введите объём", Toast.LENGTH_LONG).show();
            } else {
                InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
                if (imm.isActive()) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
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

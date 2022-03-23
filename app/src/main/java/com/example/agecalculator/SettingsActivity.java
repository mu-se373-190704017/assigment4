package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerUnit, spinnerColor;
    private Button buttonSave;

    static String saveString="";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String unit = "unit";
    public static final String color = "color";

    static int ageUnit=0;
    static int colorUnit=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        spinnerUnit = findViewById(R.id.spinnerUnit);
        spinnerColor = findViewById(R.id.spinnerColor);
        buttonSave = findViewById(R.id.buttonSave);

        ArrayAdapter<CharSequence> adapterUnit = ArrayAdapter.createFromResource(this,R.array.unitAge, android.R.layout.simple_spinner_item);

        adapterUnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnit.setAdapter(adapterUnit);
        spinnerUnit.setOnItemSelectedListener(new UnitSpinnerClass());

        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this,R.array.colorName, android.R.layout.simple_spinner_item);

        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adapterColor);
        spinnerColor.setOnItemSelectedListener(new colorSpinnerClass());

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    public void saveData() {
        //creating sharedpreferences

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(unit,ageUnit);
        editor.putInt(color,colorUnit);
        editor.apply();
    }



    class UnitSpinnerClass implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            if(text.equals("Days"))
            {
                ageUnit=0;
            }
            else if(text.equals("Month"))
            {
                ageUnit=1;
            }
            else if(text.equals("Years"))
            {
                ageUnit=2;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    class colorSpinnerClass implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();

            if(text.equals("Red"))
            {
                colorUnit=0;
            }
            else if(text.equals("Green"))
            {
                colorUnit=1;
            }
            else if(text.equals("Blue"))
            {
                colorUnit=2;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
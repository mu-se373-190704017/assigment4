package com.example.agecalculator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView textViewSelectDate,textViewAgeIn, textViewNumber;
    private Button buttonCalculate;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String unit = "unit";
    public static final String color = "color";

    static int ageUnit=0;
    static int colorUnit=0;

    static String currentDate="20-Jul-2021";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSelectDate= findViewById(R.id.textViewSelectDate);
        textViewAgeIn = findViewById(R.id.textViewAgeIn);
        textViewNumber = findViewById(R.id.textViewNumber);

        buttonCalculate = findViewById(R.id.buttonCalculate);

        loadData();

        textViewSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });



        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(ageUnit==0)
                {
                    LocalDate now = LocalDate.now(); //now date
                    int m=1;
                    String[] sp = currentDate.split("-");
                    if(sp[1].equals("Jan"))
                    {
                        m=1;
                    }
                    else if(sp[1].equals("Feb"))
                    {
                        m=2;
                    }
                    else if(sp[1].equals("Mar"))
                    {
                        m=3;
                    }
                    else if(sp[1].equals("Apr"))
                    {
                        m=4;
                    }
                    else if(sp[1].equals("May"))
                    {
                        m=5;
                    }
                    else if(sp[1].equals("Jun"))
                    {
                        m=6;
                    }
                    else if(sp[1].equals("Jul"))
                    {
                        m=7;
                    }
                    else if(sp[1].equals("Aug"))
                    {
                        m=8;
                    }
                    else if(sp[1].equals("Sep"))
                    {
                        m=9;
                    }
                    else if(sp[1].equals("Oct"))
                    {
                        m=10;
                    }
                    else if(sp[1].equals("Nov"))
                    {
                        m=11;
                    }
                    else if(sp[1].equals("Dec"))
                    {
                        m=12;
                    }
                    LocalDate birthDate = LocalDate.of(Integer.parseInt(sp[2]),m,Integer.parseInt(sp[0]));

                    long daysCal= ChronoUnit.DAYS.between(birthDate,now);
                    textViewAgeIn.setText("Age in Days");
                    if(colorUnit==0)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.RED);
                    }
                    else if(colorUnit==1)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.GREEN);
                    }
                    else if(colorUnit==2)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.BLUE);
                    }

                }
                else if(ageUnit==1)
                {
                    LocalDate now = LocalDate.now(); //now date
                    int m=1;
                    String[] sp = currentDate.split("-");
                    if(sp[1].equals("Jan"))
                    {
                        m=1;
                    }
                    else if(sp[1].equals("Feb"))
                    {
                        m=2;
                    }
                    else if(sp[1].equals("Mar"))
                    {
                        m=3;
                    }
                    else if(sp[1].equals("Apr"))
                    {
                        m=4;
                    }
                    else if(sp[1].equals("May"))
                    {
                        m=5;
                    }
                    else if(sp[1].equals("Jun"))
                    {
                        m=6;
                    }
                    else if(sp[1].equals("Jul"))
                    {
                        m=7;
                    }
                    else if(sp[1].equals("Aug"))
                    {
                        m=8;
                    }
                    else if(sp[1].equals("Sep"))
                    {
                        m=9;
                    }
                    else if(sp[1].equals("Oct"))
                    {
                        m=10;
                    }
                    else if(sp[1].equals("Nov"))
                    {
                        m=11;
                    }
                    else if(sp[1].equals("Dec"))
                    {
                        m=12;
                    }
                    LocalDate birthDate = LocalDate.of(Integer.parseInt(sp[2]),m,Integer.parseInt(sp[0]));

//                    Period period = Period.between(birthDate,now);
//                    textViewAgeIn.setText(period.getMonths());
                    //textViewNumber.setText(period.getMonths());
                    long daysCal= ChronoUnit.MONTHS.between(birthDate,now);
                    textViewAgeIn.setText("Age in Months");
                    if(colorUnit==0)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.RED);
                    }
                    else if(colorUnit==1)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.GREEN);
                    }
                    else if(colorUnit==2)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.BLUE);
                    }
                }
                else if(ageUnit==2)
                {
                    LocalDate now = LocalDate.now(); //now date
                    int m=1;
                    String[] sp = currentDate.split("-");
                    if(sp[1].equals("Jan"))
                    {
                        m=1;
                    }
                    else if(sp[1].equals("Feb"))
                    {
                        m=2;
                    }
                    else if(sp[1].equals("Mar"))
                    {
                        m=3;
                    }
                    else if(sp[1].equals("Apr"))
                    {
                        m=4;
                    }
                    else if(sp[1].equals("May"))
                    {
                        m=5;
                    }
                    else if(sp[1].equals("Jun"))
                    {
                        m=6;
                    }
                    else if(sp[1].equals("Jul"))
                    {
                        m=7;
                    }
                    else if(sp[1].equals("Aug"))
                    {
                        m=8;
                    }
                    else if(sp[1].equals("Sep"))
                    {
                        m=9;
                    }
                    else if(sp[1].equals("Oct"))
                    {
                        m=10;
                    }
                    else if(sp[1].equals("Nov"))
                    {
                        m=11;
                    }
                    else if(sp[1].equals("Dec"))
                    {
                        m=12;
                    }
                    LocalDate birthDate = LocalDate.of(Integer.parseInt(sp[2]),m,Integer.parseInt(sp[0]));

                    long daysCal= ChronoUnit.YEARS.between(birthDate,now);
                    textViewAgeIn.setText("Age in Years");
                    if(colorUnit==0)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.RED);
                    }
                    else if(colorUnit==1)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.GREEN);
                    }
                    else if(colorUnit==2)
                    {
                        textViewNumber.setText(String.valueOf(daysCal));
                        textViewNumber.setTextColor(Color.BLUE);
                    }
                }

                //Toast.makeText(MainActivity.this, String.valueOf(ageUnit), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.about:
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.contact:
                Intent intent1 = new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(intent1);
                return true;
            case R.id.setting:
                Intent intent2 = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        textViewSelectDate.setText(currentDate);
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        ageUnit=sharedPreferences.getInt(unit,0);
        colorUnit = sharedPreferences.getInt(color,0);
    }
}
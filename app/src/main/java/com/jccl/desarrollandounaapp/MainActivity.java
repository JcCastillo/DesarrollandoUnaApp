package com.jccl.desarrollandounaapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatePicker picker;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addDatePickerListener();
        addBtnSiguienteListener();
    }

    public void addBtnSiguienteListener(){
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        Button button= (Button) findViewById(R.id.btnSiguiente);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker dp = (DatePicker) findViewById(R.id.dpFecha);
                EditText nombre = (EditText) findViewById(R.id.etNombre);
                EditText telefono = (EditText) findViewById(R.id.etTelefono);
                EditText email = (EditText) findViewById(R.id.etEmail);
                EditText descripcion = (EditText) findViewById(R.id.etDescripcion);
                String fecha = dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear();
                Intent i = new Intent(MainActivity.this, Datos.class);
                i.putExtra(getResources().getString(R.string.pnombre),nombre.getText().toString());
                i.putExtra(getResources().getString(R.string.pfecha),fecha);
                i.putExtra(getResources().getString(R.string.ptelefono),telefono.getText().toString());
                i.putExtra(getResources().getString(R.string.pemail),email.getText().toString());
                i.putExtra(getResources().getString(R.string.pdescripcion),descripcion.getText().toString());
                startActivity(i);
            }
        });
    }

    public void addDatePickerListener(){
        picker = (DatePicker) findViewById(R.id.dpFecha);
        year = picker.getYear();
        month = picker.getMonth();
        day = picker.getDayOfMonth();
        picker.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener, year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
                // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
            // set selected date into Text View
            // set selected date into Date Picker
            picker.init(year, month, day, null);
        }
    };
}

package com.fredy.formulariodecontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText et1,et3,et4,et5 ;
    Button button2;
    TextInputEditText efecha;
    private int dia,mes,ano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String user_name = intent.getStringExtra("Dnombre");
        String user_fecha = intent.getStringExtra("Dfecha");
        String user_telefono = intent.getStringExtra("Dtelefono");
        String user_email = intent.getStringExtra("Demail");
        String user_descripcion = intent.getStringExtra("Ddescripcion");

        button2 = (Button) findViewById(R.id.button2);
        efecha = (TextInputEditText) findViewById(R.id.efecha);
        efecha.setOnClickListener(this);
        button2.setOnClickListener(this);

        MaterialDatePicker.Builder  builder = MaterialDatePicker.Builder.datePicker();

        et1 = (TextInputEditText) findViewById(R.id.Nombrecomleto);
        et3 = (TextInputEditText) findViewById(R.id.Telefono);
        et4 = (TextInputEditText)findViewById(R.id.Email);
        et5 = (TextInputEditText) findViewById(R.id.DescripcionContacto);

        et1.setText(user_name);
        efecha.setText(user_fecha);
        et3.setText(user_telefono);
        et4.setText(user_email);
        et5.setText(user_descripcion);

    }

    @Override
    public void onClick(View view) {
        if (view ==efecha ){
            final Calendar c= Calendar.getInstance();
            dia =c.get(Calendar.DAY_OF_MONTH);
            mes =c.get(Calendar.MONTH);
            ano =c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofMonth) {
                    efecha.setText(dayofMonth+"/"+(monthofyear+1)+"/"+year);

                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();

        }
        if (view == button2){
                Intent intent = new Intent(MainActivity.this,DetalleFormulario.class);

                intent.putExtra("nombre", et1.getText().toString());
                intent.putExtra("fecha", efecha.getText().toString());
                intent.putExtra("telefono", et3.getText().toString());
                intent.putExtra("email", et4.getText().toString());
                intent.putExtra("descripcion", et5.getText().toString());
                startActivity(intent);
                finish();




        }





    }
}
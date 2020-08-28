package com.fredy.formulariodecontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleFormulario extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvFecha;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_formulario);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetalleFormulario.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View view) {
        if (view == button) {
            Intent intent = new Intent(DetalleFormulario.this, MainActivity.class);
            intent.putExtra("Dnombre", tvNombre.getText().toString());
            intent.putExtra("Dfecha", tvFecha.getText().toString());
            intent.putExtra("Dtelefono", tvTelefono.getText().toString());
            intent.putExtra("Demail", tvEmail.getText().toString());
            intent.putExtra("Ddescripcion", tvDescripcion.getText().toString());
            startActivity(intent);
            finish();
        }
    }
}
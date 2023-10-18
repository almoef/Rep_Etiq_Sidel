package com.example.rep_etiq_sidel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
  private ListView listview;

  private String elementos[] = {"Alineador","Arrancador","Bobina","Bomba","Bornera","Boya","Cable","Cable-Encoder",
  "Cable-Servo","Cerradura","Chipcard","Conector","Contacto Auxiliar","Contactor","Diodo Supresor","Electroválvula",
  "Encoder","Fibra Óptica","Final de Carrera","Fuente","Fusible","Interruptor","JOG","Módulo B&R","Motor","Optoacoplador",
  "Pacdrive","Panel","Pilz", "PT100","Relé","Resistencia","Sensor","Servomotor","Tarjetas B&R","UPS","Variador",
  "Warner"};


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    listview = findViewById(R.id.listViewElement);
    Arrays.sort(elementos); // ORDENAR DE FORMA ALFABÉTICA
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.filter_view, elementos);
    listview.setAdapter(adapter);

    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      //@Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String filtro_enviar = listview.getItemAtPosition(i).toString(); //OBTIENE EL VALOR DE LA POSICIÓN Y LO GUARDA EN LA VARIABLE dato_enviar
        Intent siguiente = new Intent(MainActivity.this, activity_elements.class);
        siguiente.putExtra("filtro",filtro_enviar);
        startActivity(siguiente);
      }
    });
  }
}
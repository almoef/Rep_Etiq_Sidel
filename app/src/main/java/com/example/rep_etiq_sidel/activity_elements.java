package com.example.rep_etiq_sidel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rep_etiq_sidel.Adapater.Adapter;
import com.example.rep_etiq_sidel.Model.Model;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.checkerframework.checker.units.qual.s;

import java.util.Timer;
import java.util.TimerTask;

public class activity_elements extends AppCompatActivity {
  TextView elemento;
  RecyclerView mRecycler;
  Query query;
  Adapter mAdapter;
  FirebaseFirestore mFirestore;
  String dato; //OBTIENE EL FILTRO ENVIADO POR EL MAIN ACTIVITY

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_elements);
    mFirestore = FirebaseFirestore.getInstance();

    setupRecyclerView();

  }

  private void setupRecyclerView() {
    elemento = findViewById(R.id.elemento); //PARA MOSTRAR EL TÍTULO DEL ACTIVITY
    mRecycler = findViewById(R.id.recyclerView);
    mRecycler.setLayoutManager(new LinearLayoutManager(this));
    dato = getIntent().getStringExtra("filtro");
    elemento.setText(dato);
    textSearch(dato);
  }
  public void regresar(View view){
    Intent regresar = new Intent(this, MainActivity.class);
    startActivity(regresar);

  }
  public void textSearch(String s){
    //query = mFirestore.collection("catalogo_repuestos");
    query = mFirestore.collection("repuestos_etiq_sidel").whereEqualTo("elemento", s);
    FirestoreRecyclerOptions<Model> firestoreRecyclerOptions =
            new FirestoreRecyclerOptions.Builder<Model>().setQuery(query,Model.class).build();
    /*FirestoreRecyclerOptions<Model>firestoreRecyclerOptions =
            new FirestoreRecyclerOptions.Builder<Model>()
                    .setQuery(query.orderBy("elemento")
                            .startAt(s).endAt(s+"~"), Model.class).build();*/
    mAdapter = new Adapter(firestoreRecyclerOptions, this, getSupportFragmentManager());
    mAdapter.startListening();
    mRecycler.setAdapter(mAdapter);

  }
  @Override
  protected void onStart() {
    super.onStart();
    mAdapter.startListening();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mAdapter.stopListening();
  }

}

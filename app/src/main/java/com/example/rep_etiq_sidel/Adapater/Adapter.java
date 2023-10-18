package com.example.rep_etiq_sidel.Adapater;

import android.app.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import androidx.recyclerview.widget.RecyclerView;
import com.example.rep_etiq_sidel.Model.Model;
import com.example.rep_etiq_sidel.R;

import com.example.rep_etiq_sidel.SidelFragment;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class Adapter extends FirestoreRecyclerAdapter<Model, Adapter.ViewHolder> {
  private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
  Activity activity;
  ProgressBar progressBar;
  int counter;
  private boolean isLoading = false;
    public Adapter(@NonNull FirestoreRecyclerOptions<Model> options, Activity activity, FragmentManager fm) {
    super(options);
    this.activity = activity;

  }

  @Override
  protected void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position, @NonNull Model model) {

    DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getAbsoluteAdapterPosition());
    final String id = documentSnapshot.getId();
    viewHolder.codigoSap.setText(model.getCodigoSap());
    viewHolder.nombreTecnico.setText(model.getNombreTecnico());
    viewHolder.descripcionBreve.setText(model.getDescripcionBreve());
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
        String getSap = model.getCodigoSap();
        String getDescExt = model.getDescripcionExtensa();
        String getNumPart = model.getNumeroDeParte();
        String getTec = model.getNombreTecnico();
        String getMarc = model.getMarca();
        String getImage = model.getEnlaceImagen();
        String mensaje = getSap + "--"+ getTec + "--" + getNumPart + "--" + getDescExt + "--" + getMarc + "--" + getImage;

        Bundle bundle = new Bundle();
        bundle.putString("clave_mensaje", mensaje);


        //ACEDER AL FRAGMENT DE CARDVIEW, cuando hacemos click en el elemento
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        SidelFragment sidelFragment = new SidelFragment();
        sidelFragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conteneder, sidelFragment).addToBackStack(null).commit();

     }
   });

  }

  @NonNull
  @Override
  public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elements_view, parent, false);
    return new ViewHolder(v);
  }
  @Override
  public void onError(@NonNull FirebaseFirestoreException e) {
    super.onError(e);
    // Manejar errores de Firebase y mostrar un Toast
    Toast.makeText(activity, "Error al acceder a los datos de Firebase", Toast.LENGTH_SHORT).show();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView elemento, codigoSap, id, marca,numeroDeParte,cantidad,descripcionBreve,descripcionExtensa,enlaceImagen,nombreTecnico;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      codigoSap = itemView.findViewById(R.id.cod_sap);
      nombreTecnico = itemView.findViewById(R.id.nombreTecnico);
      descripcionBreve = itemView.findViewById(R.id.descripcionBreve);

    }
  }
}
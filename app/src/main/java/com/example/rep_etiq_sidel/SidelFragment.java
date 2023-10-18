package com.example.rep_etiq_sidel;

import android.os.Bundle;


import androidx.fragment.app.DialogFragment;

import androidx.fragment.app.FragmentManager;



import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SidelFragment extends DialogFragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogFragmentStyle);

  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_, container, false);
    TextView txt_codsap = rootView.findViewById(R.id.txt_codsap);
    TextView txt_descrip = rootView.findViewById(R.id.txt_descrip);
    TextView txt_nombtec = rootView.findViewById(R.id.txt_nombtec);
    TextView txt_numpart = rootView.findViewById(R.id.txt_numpart);
    TextView txt_marca = rootView.findViewById(R.id.txt_marca);
    ImageView imageView = rootView.findViewById(R.id.imageView);

    // Configura un OnClickListener para el botón de cerrar
    rootView.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Cierra el fragmento
        FragmentManager fragmentManager = requireFragmentManager();
        fragmentManager.popBackStack();
        //dismiss();
      }
    });
    rootView.findViewById(R.id.txt_cerrar).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Cierra el fragmento
        FragmentManager fragmentManager = requireFragmentManager();
        fragmentManager.popBackStack();
        //dismiss();
      }
    });
    Bundle bundle = getArguments();
    if(bundle != null){
      String mensaje = bundle.getString("clave_mensaje");
      String [] partes = mensaje.split("--");
      String mensaje1,mensaje2,mensaje3,mensaje4,mensaje5,mensaje6;

      if(partes.length >= 6)
      {
        mensaje1 = partes [0];
        mensaje2 = partes [1];
        mensaje3 = partes [2];
        mensaje4 = partes [3];
        mensaje5 = partes [4];
        mensaje6 = partes [5];

        Picasso.get().load(mensaje6).into(imageView);
        txt_codsap.setText(mensaje1);
        txt_nombtec.setText(mensaje2);
        txt_numpart.setText(mensaje3);
        txt_descrip.setText(mensaje4);
        txt_marca.setText(mensaje5);
      }
    }
    return rootView;
  }

}

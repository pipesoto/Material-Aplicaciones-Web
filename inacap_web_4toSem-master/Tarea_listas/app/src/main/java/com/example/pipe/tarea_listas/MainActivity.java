package com.example.pipe.tarea_listas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Inicializo
    private Switch swOpcion;
    private TextView tvMensaje;
    private ListView lsItem;
    private String[] Clientes;
    private String[] Productos;
    private ArrayAdapter<String> Adaptador;
    private ArrayAdapter<String> Adaptador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencias


        Clientes = new String[6];
        Clientes[0] = "Felipe Soto";
        Clientes[1] = "Andres Longton";
        Clientes[2] = "Marcos PAlma";
        Clientes[3] = "Jose Gusman";
        Clientes[4] = "Ariel Ponce";
        Clientes[5] = "Sebastian Gutierrez";


        Productos = new String[6];
        Productos[0] = "Pan";
        Productos[1] = "Azucar";
        Productos[2] = "sal";
        Productos[3] = "manjar";
        Productos[4] = "arroz";
        Productos[5] = "mantequilla";


        Adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Clientes);
        Adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Productos);


        swOpcion = (Switch)findViewById(R.id.swOpcion);
        tvMensaje =(TextView)findViewById(R.id.tvMensaje);
        lsItem = (ListView)findViewById(R.id.lsItem);
        //lsItem.setAdapter(Adaptador);//cambiar si hay mas d un adaptador
        //lsItem.setAdapter(Adaptador2);



        swOpcion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvMensaje.setText("Productos");
                    lsItem.setAdapter(Adaptador2);

                }else{
                    tvMensaje.setText("Clientes");
                    lsItem.setAdapter(Adaptador);
                }

            }
        });

        lsItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                    Intent i = new Intent(view.getContext(), segundaActivity.class);
                    startActivity(i);

                }else if(position == 1){

                    Intent i = new Intent(view.getContext(), terceraActivity.class);
                    startActivity(i);

                }else if(position == 2){
                    Toast.makeText(MainActivity.this,   "Click Largo :" +position,Toast.LENGTH_LONG).show();

                }
            }
        });






    }
}

package com.Trab2bi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Toast;
import android.view.View;



public class tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String cafe = bundle.getString("CafeEscolhido");
        TextView textView = (TextView) findViewById(R.id.tipocafeID);
        textView.setText(cafe);
        String desc = bundle.getString("DescCafeEscolhido");
        TextView desctext = (TextView) findViewById(R.id.descView);
        desctext.setText(desc);
        String valor = bundle.getString("ValorCafeEscolhido");
        TextView textValor = (TextView) findViewById(R.id.tipoValoID);
        textValor.setText(valor);


        final Intent intent2 = new Intent(this, tela3.class);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Finalizar pedido");
        builder.setMessage("Tem certeza que quer confirmar seu pedido?");

        DialogInterface.OnClickListener positivo = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent2);
            }
        };
        DialogInterface.OnClickListener negativo = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Escolha um cafe", Toast.LENGTH_SHORT).show();
            }
        };
        builder.setNegativeButton("Voltar", negativo);
        builder.setPositiveButton("Confirmar", positivo);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder.create().show();
            }
        });

    }
}


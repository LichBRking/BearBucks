package com.Trab2bi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.CompoundButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast . makeText (getApplicationContext (), "Seu desejo e uma ordem" , Toast . LENGTH_SHORT ) . show() ;
                } else {
                    Toast . makeText (getApplicationContext (), "Otima escolha" , Toast . LENGTH_SHORT ) . show() ;
                }
            }
        });


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                String cafe = "";
                String desc ="";
                String valor ="";
                if (position == 0) {
                    cafe ="Cafe com Leite";
                    desc ="Café com leite é uma bebida típica de Portugal e " +
                            "Brasil. A mistura entre o café e o leite, em suas diversas variações," +
                            " é uma das bebidas matinais mais consumidas do mundo.";
                    valor ="250ml" + "\n" + "4,50";
                }
                else if (position == 1) {
                    cafe ="Macchiato";
                    desc ="Caffè macchiato, também conhecido como espresso macchiato," +
                            " é um café com leite típico italiano, consistindo num café expresso" +
                            " misturado com um pouco de leite quente com espuma.";
                    valor ="250ml" + "\n" + "6,50";
                }
                else if (position == 2) {
                    cafe ="Moca";
                    desc ="O café moca ou mocha é uma variante do café com leite." +
                            " É feito com um terço de expresso e dois terços de leite vaporizado," +
                            "mas uma porção de chocolate é adicionada em forma de chocolate em pó adoçado.";
                    valor ="250ml" + "\n" + "6,50";
                }
                else if (position == 3) {
                    cafe ="Capuccino";
                    desc ="é uma bebida italiana preparada com café expresso e leite." +
                            " Um cappuccino clássico, consiste em um terço de café expresso," +
                            " um terço de leite vaporizado e um terço de espuma de leite vaporizado.";
                    valor ="250ml" + "\n" + "8,50";
                }
                else if (position == 4) {
                    cafe ="Latte";
                    desc ="Latte é uma bebida de café expresso com uma quantidade generosa de espuma de leite no topo." +
                            "Uma bebida levemente adocicada, muito cremosa e suave.";
                    valor ="250ml" + "\n" + "6,50";
                }
                Bundle bundle = new Bundle();
                bundle.putString("CafeEscolhido",cafe);
                bundle.putString("DescCafeEscolhido",desc);
                bundle.putString("ValorCafeEscolhido",valor);
                Intent intent = new Intent(getBaseContext(), tela2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        ListView listView = (ListView) findViewById(R.id.EscolhaCafeID);
        listView.setOnItemClickListener(itemClickListener);


    }
}

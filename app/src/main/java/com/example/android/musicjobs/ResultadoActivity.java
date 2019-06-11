package com.example.android.musicjobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.musicjobs.modelo.Profissionais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultadoActivity extends AppCompatActivity {


    ListView listaPerfis;
    List<Profissionais> profs;
    Button btnVoltar;
    String profi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btnVoltar = findViewById(R.id.btnVoltar);
        listaPerfis = findViewById(R.id.listResult);
        Intent i = getIntent();
        profi = i.getStringExtra("prof");

        final List<Profissionais> perfis = lista();

        listaPerfis.setAdapter(new PerfisAdapter(perfis, this));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(ResultadoActivity.this, PesquisarActivity.class));
                onBackPressed();
            }
        });
    }

    public List<Profissionais> lista() {
        if(profi.equals("Baterista")){
            List<Profissionais> profissionais = new ArrayList<>(Arrays.asList(
                    new Profissionais("Arthur Margiota", "Baterista", 2.5f),
                    new Profissionais("Francisco Felinto", "Baterista", 5f)
            ));
            return profissionais;
        }else if(profi.equals("Baixista")){
            List<Profissionais> profissionais = new ArrayList<>(Arrays.asList(
                    new Profissionais("Eduardo Camargo", "Baixista", 5f)
            ));
            return profissionais;
        }else if(profi.equals("Banda")){
            List<Profissionais> profissionais = new ArrayList<>(Arrays.asList(
                    new Profissionais("Trincaosso", "Banda", 4.5f)
            ));
            return profissionais;
        }else if(profi.equals("Guitarrista")){
            List<Profissionais> profissionais = new ArrayList<>(Arrays.asList(
                    new Profissionais("Leonardo Ribeiro", "Guitarrista", 4.5f),
                    new Profissionais("Gustavo Ribeiro de Carvalho", "Guitarrista", 1.5f)
            ));
            return profissionais;
        }
        else{
            List<Profissionais> profissionais = new ArrayList<>(Arrays.asList(
                    new Profissionais("Não encontramos profissionais com essa especificação", " ", 0f)
            ));
            return profissionais;
        }
    }
    }

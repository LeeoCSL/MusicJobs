package com.example.android.musicjobs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.musicjobs.modelo.Profissionais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultadoActivity extends AppCompatActivity {


    ListView listaPerfis;
    List<Profissionais> profs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        listaPerfis = findViewById(R.id.listResult);
        final List<Profissionais> perfis = lista();

        listaPerfis.setAdapter(new PerfisAdapter(perfis, this));
    }

    public List<Profissionais> lista() {
        List<Profissionais> profissionais = new ArrayList<>(Arrays.asList(
                new Profissionais("Arthur Margiota", "Toca Bateria", 1),
                new Profissionais("Leonardo Ribeiro", "Toca Gaita", 5),
                new Profissionais("Gustavo Ribeiro de Carvalho", "Toca Punheta", 3)


        ));
        return profissionais;
    }


    }

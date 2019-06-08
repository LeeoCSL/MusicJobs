package com.example.android.musicjobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PesquisarActivity extends AppCompatActivity {

    Spinner spProfissao, spEstado, spCidade;
    Button btnPesquisar;
    private String[] resProfissao = new String[]{"Selecione a profissão",
            "Baixista",
            "Banda",
            "Baterista",
            "DJ",
            "Engenheiro de som",
            "Guitarrista",
            "Organizador de Eventos",
            "Técnico de iluminação",
            "Técnico de som",
            "Vocalista",
    };
    private String[] resEstado = new String[]{"SP"};
    private String[] resCidade = new String[]{"Selecione a Região",
            "Araraquara",
            "Araçatuba",
            "Assis",
            "Bauru",
            "Campinas",
            "Itapetininga",
            "Litoral Sulpaulista",
            "Macro-Metropolitana Paulista",
            "Marilia",
            "Metropolitana de São Paulo",
            "Piracicaba",
            "Presidente Prudente",
            "Ribeirão Preto",
            "São José do Rio Preto",
            "Vale do Paraiba Paulista"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        spProfissao = findViewById(R.id.spProfissao);
        spEstado = findViewById(R.id.spEstado);
        spCidade = findViewById(R.id.spCidade);
        btnPesquisar = findViewById(R.id.btnPesquisar);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resProfissao);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spProfissao.setAdapter(adapter1);


        spProfissao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resEstado);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spEstado.setAdapter(adapter2);


        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resCidade);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spCidade.setAdapter(adapter3);


        spCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PesquisarActivity.this, ResultadoActivity.class));

            }
        });
    }
}

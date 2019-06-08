package com.example.android.musicjobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.musicjobs.modelo.Usuario;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etNome, etSenha;
    FancyButton btnRegistrar;
    Usuario user = new Usuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etNome = findViewById(R.id.etNome);
        etSenha = findViewById(R.id.etSenha);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();

            }
        });

    }

    private void registrar() {
//        if(etEmail.getText().length() == 0){
//            etEmail.setError("Digite o email");
//            return;
//        }
//        if(etNome.getText().length() == 0){
//            etNome.setError("Digite o nome");
//            return;
//        }
//        if(etSenha.getText().length() < 6){
//            etSenha.setError("Digite o email");
//            return;
//        }

        user.setEmail("teste@teste.com1");
        user.setSenha("123456");
        user.setId("teste@teste.com1");
        user.setNome("teste");

        Call<Usuario> call = new RetrofitInit(RegisterActivity.this).getUsuarioService().register(user);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(RegisterActivity.this, "foi em", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("vai carai", t.getMessage());
                Toast.makeText(RegisterActivity.this, "deu ruim" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

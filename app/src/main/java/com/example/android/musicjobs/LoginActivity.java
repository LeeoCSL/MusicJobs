package com.example.android.musicjobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicjobs.modelo.Usuario;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    Button btn_registrar_se;

    EditText et_email;
    EditText et_senha;



    Usuario user = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_registrar_se = findViewById(R.id.btn_registrar_se);
        et_email = findViewById(R.id.et_email);
        et_senha = findViewById(R.id.et_senha);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaLogin();
            }
        });

        btn_registrar_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    private void realizaLogin() {
        String email;
        final String senha;
        if (et_email.getText().length() == 0) {
            et_email.setError("Digite o email");
            return;
        }
        if (et_senha.getText().length() < 6) {
            et_senha.setError("Digite a senha corretamente");
            return;
        }

        email = et_email.getText().toString();
        senha = et_senha.getText().toString();

        user.setId(email);
        user.setEmail(email);
        user.setSenha(senha);

        Call<Usuario> call = new RetrofitInit(LoginActivity.this).getUsuarioService().getUser(user.getId());
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if(response.body().getSenha().equals(senha)){

                    Toast.makeText(LoginActivity.this, "logou", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, PesquisarActivity.class));

                }else{
//                    Toast.makeText(LoginActivity.this, "senha invalida", Toast.LENGTH_SHORT).show();
                    et_senha.setError("Senha invalida");
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "deu ruim" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}

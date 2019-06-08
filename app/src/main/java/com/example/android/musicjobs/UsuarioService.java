package com.example.android.musicjobs;



import com.example.android.musicjobs.modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsuarioService {

    @POST("users")
    Call<Usuario> register(@Body Usuario user);

    @PATCH("users/{id}")
    Call<Usuario> att(@Path("id") String id, @Body Usuario user);

    @GET("users/{id}")
    Call<Usuario> getUser(@Path("id") String id);

    @DELETE("users/{id}")
    Call<Usuario> deleteUser(@Path("id") String id);
}
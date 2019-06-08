package com.example.android.musicjobs.modelo;

public class Profissionais {

    String nome;
    String profissao;
    int rating;

    public Profissionais() {
    }

    public Profissionais(String nome, String profissao, int rating) {
        this.nome = nome;
        this.profissao = profissao;
        this.rating = rating;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Profissionais{" +
                "nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", rating=" + rating +
                '}';
    }
}

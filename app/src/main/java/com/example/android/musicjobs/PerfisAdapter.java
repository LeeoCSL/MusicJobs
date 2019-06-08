package com.example.android.musicjobs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.musicjobs.modelo.Profissionais;

import java.util.List;

public class PerfisAdapter extends BaseAdapter {
    private final List<Profissionais> prof;
    private final Context context;

    public PerfisAdapter(List<Profissionais> prof, Context context) {

        this.prof = prof;
        this.context = context;
    }

    @Override
    public int getCount() {
        return prof.size();
    }

    @Override
    public Profissionais getItem(int posicao) {
        return prof.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.perfils, parent, false);

        Profissionais profi = prof.get(posicao);

        mostraRate(viewCriada, profi);

        mostraProfissao(viewCriada, profi);
        mostraNome(viewCriada, profi);
        return viewCriada;
    }

    private void mostraNome(View viewCriada, Profissionais prof) {
        TextView tvNome = viewCriada.findViewById(R.id.txtNomeResult);
        tvNome.setText(prof.getNome());
    }


    private void mostraProfissao(View viewCriada, Profissionais prof) {
        TextView tvProfissao = viewCriada.findViewById(R.id.txtProfissaoResult);
        tvProfissao.setText(prof.getProfissao());
    }



    private void mostraRate(View viewCriada, Profissionais prof) {
        RatingBar ratingBar = viewCriada.findViewById(R.id.ratingResult);
        ratingBar.setRating(prof.getRating());
    }
}

package devandroid.kauamatheus.appanotacoes.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.kauamatheus.appanotacoes.model.Anotacoes;
import devandroid.kauamatheus.appanotacoes.view.MainActivity;

public class ControllerAnotacoes {
    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public ControllerAnotacoes(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado...");

        return super.toString();
    }

    public Anotacoes salvar(Anotacoes outraAnotacao) {
        Log.d("MVC_Controller","Salvo"+outraAnotacao.toString());

        listaVip.putString("titulo", outraAnotacao.getTitulo());
        listaVip.putString("observacoes", outraAnotacao.getObservacoes());
        listaVip.apply();
        return outraAnotacao;
    }

    public Anotacoes buscar(Anotacoes outraAnotacao){
        outraAnotacao.setTitulo(preferences.getString("titulo", "NA"));
        outraAnotacao.setObservacoes(preferences.getString("observacoes", "NA"));
        return outraAnotacao;
    }

    public void limpar(){

        listaVip.clear();
        listaVip.apply();
    }
}

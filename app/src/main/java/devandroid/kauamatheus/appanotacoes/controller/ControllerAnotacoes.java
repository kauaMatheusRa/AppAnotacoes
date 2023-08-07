package devandroid.kauamatheus.appanotacoes.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import devandroid.kauamatheus.appanotacoes.database.Lista_DB;
import devandroid.kauamatheus.appanotacoes.model.Anotacoes;
import devandroid.kauamatheus.appanotacoes.view.MainActivity;

public class ControllerAnotacoes extends Lista_DB {
    SharedPreferences preferences;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public ControllerAnotacoes(MainActivity mainActivity) {
        super(mainActivity);
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

    public void salvarDb(Anotacoes lista){
        Log.d("MVC_Controller", "Salvo");

        ContentValues dados = new ContentValues();
        dados.put("titulo", lista.getTitulo());
        dados.put("conteudo",lista.getObservacoes());

        salvarDados("Lista",dados);
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

    private List listacategorias;

    public List getListacategorias() {
        listacategorias = new ArrayList<Anotacoes>();

        listacategorias.add(new Anotacoes("Realizado"));
        listacategorias.add(new Anotacoes("Pendente"));
        listacategorias.add(new Anotacoes("Lembrete"));
        listacategorias.add(new Anotacoes("Outros"));

        return listacategorias;
    }

    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListacategorias().size();i++){
            Anotacoes objeto = (Anotacoes) getListacategorias().get(i);

            dados.add(objeto.getAnota());
        }
        return dados;
    }
}

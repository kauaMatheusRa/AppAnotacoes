package devandroid.kauamatheus.appanotacoes.model;

public class Anotacoes {

    private String titulo;
    private String observacoes;
    private String anota;

    public Anotacoes(){

    }

    public Anotacoes(String anota){
        this.anota = anota;
    }

    public Anotacoes(String titulo, String observacoes) {
        this.titulo = titulo;
        this.observacoes = observacoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getAnota() {
        return anota;
    }

    public void setAnota(String anota) {
        this.anota = anota;
    }

    @Override
    public String toString() {
        return ""+anota;
    }
}

package devandroid.kauamatheus.appanotacoes.model;

public class Anotacoes {

    private String titulo;
    private String observacoes;

    public Anotacoes(){

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

    @Override
    public String toString() {
        return "Anotacoes{" +
                "titulo='" + titulo + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}

package entidades;

public class Estudante {
    private String nome;

    public String getNome() {
        return nome;
    }

    public Estudante(String nome) {
        this.nome = nome;
    }

    public double somaPontos(double nota, String funcao) {
        double pontos = funcao.equals("Gremista") || funcao.equals("Esportista") || funcao.equals("Leitor") ? 1 : 0;
        return nota + pontos;
    }
}
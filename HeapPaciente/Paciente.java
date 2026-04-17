public class Paciente {
    private static int contadorChamada = 1;

    String nome;
    int prioridade;
    int numeroChamada;

    public Paciente(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.numeroChamada = contadorChamada++;
    }

    @Override
    public String toString() {
        return "Chamada #" + numeroChamada + " - " + nome + " (Prioridade: " + prioridade + ")";
    }
}
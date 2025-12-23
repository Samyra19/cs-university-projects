import java.util.LinkedList;
import java.util.Queue;

public class HeapPrioridade {
    private Queue<Paciente> filaPrioridade1;
    private Queue<Paciente> filaPrioridade2;
    private Queue<Paciente> filaPrioridade3;

    private int contadorPrioridade2;

    public HeapPrioridade() {
        filaPrioridade1 = new LinkedList<>();
        filaPrioridade2 = new LinkedList<>();
        filaPrioridade3 = new LinkedList<>();
        contadorPrioridade2 = 0;
    }

    public void inserir(Paciente paciente) {
        switch (paciente.prioridade) {
            case 1:
                filaPrioridade1.add(paciente);
                break;
            case 2:
                filaPrioridade2.add(paciente);
                break;
            default:
                filaPrioridade3.add(paciente);
                break;
        }
    }

    public Paciente atenderPaciente() {
        // Regra 1: Sempre priorizar pacientes de prioridade 1
        if (!filaPrioridade1.isEmpty()) {
            return filaPrioridade1.poll();
        }

        // Regra 4: A cada 2 atendimentos de prioridade 2, atender 1 de prioridade 3
        if (!filaPrioridade2.isEmpty() && !filaPrioridade3.isEmpty()) {
            if (contadorPrioridade2 >= 2) {
                contadorPrioridade2 = 0;
                return filaPrioridade3.poll();
            }
        }

        // Regra 2: Atender prioridade 2
        if (!filaPrioridade2.isEmpty()) {
            contadorPrioridade2++;
            return filaPrioridade2.poll();
        }

        // Regra 3: Atender demais prioridades
        if (!filaPrioridade3.isEmpty()) {
            return filaPrioridade3.poll();
        }

        return null;
    }

    public String getArvoreComoTexto() {
        StringBuilder sb = new StringBuilder();

        if (filaPrioridade1.isEmpty() && filaPrioridade2.isEmpty() && filaPrioridade3.isEmpty()) {
            return "";
        }

        sb.append("=== FILA DE ATENDIMENTO ===\n\n");

        if (!filaPrioridade1.isEmpty()) {
            sb.append("PRIORIDADE 1 (Urgente):\n");
            int pos = 1;
            for (Paciente p : filaPrioridade1) {
                sb.append("  ").append(pos++).append(". ").append(p).append("\n");
            }
            sb.append("\n");
        }

        if (!filaPrioridade2.isEmpty()) {
            sb.append("PRIORIDADE 2:\n");
            int pos = 1;
            for (Paciente p : filaPrioridade2) {
                sb.append("  ").append(pos++).append(". ").append(p).append("\n");
            }
            sb.append("\n");
        }

        if (!filaPrioridade3.isEmpty()) {
            sb.append("PRIORIDADE 3 e demais:\n");
            int pos = 1;
            for (Paciente p : filaPrioridade3) {
                sb.append("  ").append(pos++).append(". ").append(p).append("\n");
            }
            sb.append("\n");
        }

        sb.append("Atendimentos P2 consecutivos: ").append(contadorPrioridade2).append("/2");

        return sb.toString();
    }

    public void imprimirArvore() {
        System.out.println(getArvoreComoTexto());
    }
}
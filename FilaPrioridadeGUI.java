import javax.swing.*;
import java.awt.*;

public class FilaPrioridadeGUI {
    public static void main(String[] args) {
        HeapPrioridade heap = new HeapPrioridade();
        String[] opcoes = new String[]{"Adicionar paciente", "Atender paciente", "Ver fila", "Sair"};

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Sistema de Fila de Prioridade", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    String nome = JOptionPane.showInputDialog("Nome do paciente: ");
                    if (nome == null || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nome inválido!");
                        break;
                    }

                    String prioridadeStr = JOptionPane.showInputDialog("Prioridade (1 = urgente, 2 = normal, 3 = baixa): ");

                    try {
                        int prioridade = Integer.parseInt(prioridadeStr);
                        if (prioridade < 1 || prioridade > 3) {
                            JOptionPane.showMessageDialog(null, "Prioridade deve ser 1, 2 ou 3!");
                            break;
                        }

                        Paciente novoPaciente = new Paciente(nome, prioridade);
                        heap.inserir(novoPaciente);

                        JOptionPane.showMessageDialog(null,
                                "Paciente cadastrado com sucesso!\n\n" + novoPaciente);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Prioridade inválida!");
                    }
                    break;

                case 1:
                    Paciente atendido = heap.atenderPaciente();
                    if (atendido == null) {
                        JOptionPane.showMessageDialog(null, "Fila vazia. Nenhum paciente a ser atendido");
                    } else {
                        // Painel de chamada formatado
                        JPanel panel = new JPanel(new BorderLayout(10, 10));
                        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        JLabel titulo = new JLabel("CHAMADA DE PACIENTE", SwingConstants.CENTER);
                        titulo.setFont(new Font("Arial", Font.BOLD, 18));

                        JTextArea info = new JTextArea();
                        info.setEditable(false);
                        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
                        info.setText(
                                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                                        "   NÚMERO DA CHAMADA: " + atendido.numeroChamada + "\n" +
                                        "━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                                        "Paciente: " + atendido.nome + "\n" +
                                        "Prioridade: " + atendido.prioridade
                        );

                        panel.add(titulo, BorderLayout.NORTH);
                        panel.add(info, BorderLayout.CENTER);

                        JOptionPane.showMessageDialog(null, panel, "Painel de Chamada",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 2:
                    String arvoreTexto = heap.getArvoreComoTexto();
                    if (arvoreTexto == null || arvoreTexto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fila vazia.");
                    } else {
                        JTextArea textArea = new JTextArea(arvoreTexto);
                        textArea.setEditable(false);
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(500, 400));
                        JOptionPane.showMessageDialog(null, scrollPane, "Fila Atual",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
            }

        } while (escolha != 3);
    }
}
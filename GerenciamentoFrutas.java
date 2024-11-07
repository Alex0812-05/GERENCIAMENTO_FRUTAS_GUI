import javax.swing.*; // Importa as classes do Swing para GUI
import java.awt.*; // Importa classes para layout
import java.awt.event.*; // Importa classes para eventos
import java.util.HashSet;

public class GerenciamentoFrutas { // Nome da classe principal
    private HashSet<String> frutas = new HashSet<>(); // Conjunto de frutas
    private JFrame frame; // Janela principal
    private JTextArea areaFrutas; // Área de texto para exibir frutas
    private JTextField campoFruta; // Campo para entrada de nome de fruta

    public GerenciamentoFrutas() { // Construtor da classe para inicializar a GUI
        frame = new JFrame("Gerenciamento de Frutas"); // Cria o frame com título
        frame.setSize(400, 300); // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura o fechamento da janela

        // Cria os componentes da GUI
        areaFrutas = new JTextArea(10, 30);
        areaFrutas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaFrutas);

        campoFruta = new JTextField(20);

        // Botões para as ações
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnListar = new JButton("Listar");
        JButton btnRemover = new JButton("Remover");
        JButton btnVerificar = new JButton("Verificar");

        // Configura os botões com eventos
        btnAdicionar.addActionListener(e -> adicionarFruta());
        btnListar.addActionListener(e -> listarFrutas());
        btnRemover.addActionListener(e -> removerFruta());
        btnVerificar.addActionListener(e -> verificarFruta());

        // Painel para os botões e campo de texto
        JPanel panel = new JPanel();
        panel.add(new JLabel("Fruta:"));
        panel.add(campoFruta);
        panel.add(btnAdicionar);
        panel.add(btnListar);
        panel.add(btnRemover);
        panel.add(btnVerificar);

        // Adiciona os componentes à janela
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true); // Exibe a janela
    }

    private void adicionarFruta() { // Adiciona uma fruta
        String fruta = campoFruta.getText().trim();
        if (!fruta.isEmpty()) {
            if (frutas.add(fruta)) {
                JOptionPane.showMessageDialog(frame, fruta + " foi adicionada.");
            } else {
                JOptionPane.showMessageDialog(frame, fruta + " já está no conjunto.");
            }
            campoFruta.setText("");
        }
    }

    private void listarFrutas() { // Lista todas as frutas
        areaFrutas.setText("Frutas:\n" + String.join(", ", frutas));
    }

    private void removerFruta() { // Remove uma fruta
        String fruta = campoFruta.getText().trim();
        if (!fruta.isEmpty()) {
            if (frutas.remove(fruta)) {
                JOptionPane.showMessageDialog(frame, fruta + " foi removida.");
            } else {
                JOptionPane.showMessageDialog(frame, fruta + " não foi encontrada.");
            }
            campoFruta.setText("");
        }
    }

    private void verificarFruta() { // Verifica se uma fruta está presente
        String fruta = campoFruta.getText().trim();
        if (!fruta.isEmpty()) {
            if (frutas.contains(fruta)) {
                JOptionPane.showMessageDialog(frame, fruta + " está presente no conjunto.");
            } else {
                JOptionPane.showMessageDialog(frame, fruta + " não foi encontrada.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GerenciamentoFrutas::new); // Executa a GUI na thread de eventos
    }
}

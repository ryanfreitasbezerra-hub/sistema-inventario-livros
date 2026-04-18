import java.awt.*;
import javax.swing.*;

public class TelaCadastro extends JFrame {

    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaCadastro() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel titulo = new JLabel("CADASTRO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        campoNome = new JTextField();
        campoNome.setBorder(BorderFactory.createTitledBorder("Nome"));

        campoEmail = new JTextField();
        campoEmail.setBorder(BorderFactory.createTitledBorder("Email"));

        campoSenha = new JPasswordField();
        campoSenha.setBorder(BorderFactory.createTitledBorder("Senha"));

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado (simulado)");
                new TelaLogin().setVisible(true); // volta para login
                dispose();
            }
        });

        painel.add(titulo);
        painel.add(campoNome);
        painel.add(campoEmail);
        painel.add(campoSenha);
        painel.add(btnSalvar);

        add(painel);
        setVisible(true);
    }
}

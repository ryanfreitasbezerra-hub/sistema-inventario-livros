import java.awt.*;
import javax.swing.*;

public class TelaLogin extends JFrame {

    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaLogin() {
        setTitle("Login - Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel(new GridLayout(6, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel titulo = new JLabel("LOGIN", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        campoEmail = new JTextField();
        campoEmail.setBorder(BorderFactory.createTitledBorder("Email"));

        campoSenha = new JPasswordField();
        campoSenha.setBorder(BorderFactory.createTitledBorder("Senha"));

        JButton btnLogin = new JButton("Entrar");
        JButton btnCadastrar = new JButton("Cadastrar Usuário");

        // 🔐 Login
        btnLogin.addActionListener(e -> {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());

            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                JOptionPane.showMessageDialog(null, "Login realizado (simulado)");
            }
        });

        // 👉 Ir para cadastro
        btnCadastrar.addActionListener(e -> {
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.setVisible(true);
            dispose();
        });

        painel.add(titulo);
        painel.add(campoEmail);
        painel.add(campoSenha);
        painel.add(btnLogin);
        painel.add(btnCadastrar);

        add(painel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}

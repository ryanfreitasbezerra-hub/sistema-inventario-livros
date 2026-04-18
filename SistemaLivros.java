import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SistemaLivros {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://br4k3x.h.filess.io:61002/inventario_livros_avoidasmap?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "inventario_livros_avoidasmap";
        String senha = "6f304e3583fb3a926e4bdf3305267a45330b4287";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);

            System.out.println("=== CADASTRO DE LIVROS ===");

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("Ano: ");
            int ano = scanner.nextInt();

            String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setInt(3, ano);

            ps.executeUpdate();

            System.out.println("✅ Livro cadastrado com sucesso!");

            conn.close();

        } catch (Exception e) {
            System.out.println("❌ Erro:");
            e.printStackTrace();
        }
    }
}
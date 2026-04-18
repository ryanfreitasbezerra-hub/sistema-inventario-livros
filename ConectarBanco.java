import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ConectarBanco {

    public static void main(String[] args) {

        String host = "br4k3x.h.filess.io";
        String porta = "61002";
        String banco = "inventario_livros_avoidasmap";
        String usuario = "inventario_livros_avoidasmap";
        String senha = "6f304e3583fb3a926e4bdf3305267a45330b4287";

        String url = "jdbc:mysql://" + host + ":" + porta + "/" + banco +
                "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ CONECTADO COM SUCESSO!");

            // 🔹 Criar tabela
            String criarTabela = "CREATE TABLE IF NOT EXISTS livros (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "titulo VARCHAR(255) NOT NULL," +
                    "autor VARCHAR(255) NOT NULL," +
                    "ano INT" +
                    ")";

            Statement stmt = conn.createStatement();
            stmt.execute(criarTabela);
            System.out.println("📚 Tabela pronta!");

            // 🔹 Inserir livro
            String inserir = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(inserir);

            ps.setString(1, "Dom Casmurro");
            ps.setString(2, "Machado de Assis");
            ps.setInt(3, 1899);

            ps.executeUpdate();
            System.out.println("📥 Livro inserido!");

            conn.close();

        } catch (Exception e) {
            System.out.println("❌ ERRO:");
            e.printStackTrace();
        }
    }
}
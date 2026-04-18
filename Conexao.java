import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "jdbc:mysql://br4k3x.h.filess.io:61002/inventario_livros_avoidasmap?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "inventario_livros_avoidasmap";
    private static final String PASSWORD = "6f304e3583fb3a926e4bdf3305267a45330b4287";

    public static Connection conectar() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
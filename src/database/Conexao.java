package database;

/**
 *
 * @author joseelias14
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    private Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulapoo?allowPublicKeyRetrieval=true&useSSL=false",
                    "fatec", "fatec2021");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}
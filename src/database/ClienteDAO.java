package database;

import java.sql.*;
import entity.Cliente;

/**
 *
 * @author joseelias14
 */
public class ClienteDAO {
    private Conexao conexao = new Conexao();
    
    
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?,?,?)";
        try (PreparedStatement st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCpf());
            st.setString(3, cliente.getTelefone());
            st.executeUpdate();
            
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
            }
        }
    }
    
        
        public Cliente buscarPorId(int id) throws SQLException {
            String sql = "SELECT * FROM cliente WHERE id = ?";
            try (PreparedStatement st = conexao.getConexao().prepareStatement(sql)) {
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    return cliente;
                }
            }
            return null;
        }
        
        
}

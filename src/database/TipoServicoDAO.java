package database;

import entity.TipoServico;
import java.sql.*;

/**
 *
 * @author joseelias14
 */
public class TipoServicoDAO {
    private Conexao conexao = new Conexao();
    
    public TipoServico buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM tipo_servico WHERE id = ?";
        try (PreparedStatement st = conexao.getConexao().prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TipoServico ts = new TipoServico();
                ts.setIdTipoServico(rs.getInt("id"));
                ts.setDescricao(rs.getString("descricao"));
                ts.setPreco(rs.getDouble("preco"));
                return ts;
            }
        }
        return null;
    }
}

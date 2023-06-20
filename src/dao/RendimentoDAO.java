package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Rendimento;

public class RendimentoDAO {
	private Connection conn;
	
	public RendimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (Rendimento rendimento) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into rendimento (nome, valor, recorrencia, codigo_categoria_rendimento) values (1, 2, 3, 4)");
			
			st.setString(1, rendimento.getNome());
			st.setFloat(2, rendimento.getValor());
			st.setBoolean(3, rendimento.isRecorrencia());
			st.setInt(4, rendimento.getCategoria().getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
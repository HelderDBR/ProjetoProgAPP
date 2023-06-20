package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.Rendimento;

public class RendimentoDAO {
	private Connection conn;
	
	public void cadastrar (Rendimento rendimento) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into rendimento (categoria, nome, valor, recorrencia) values (1, 2, 3, 4)");
			
			st.setString(1, rendimento.getCategoria());
			st.setString(2, rendimento.getNome());
			st.setString(3, "oi");
			st.setBoolean(4, rendimento.getRecorrencia());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
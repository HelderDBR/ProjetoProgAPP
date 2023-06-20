package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.CategoriaRendimento;

public class CategoriaRendimentoDAO {
	private Connection conn;
	
	public CategoriaRendimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (CategoriaRendimento categoriaRendimento) throws SQLException{
		PreparedStatement st = null;
		
		try {

			st = conn.prepareStatement("insert into categoria_rendimento (descricao) values (?)");
			
			st.setString(1, categoriaRendimento.getDescricao());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

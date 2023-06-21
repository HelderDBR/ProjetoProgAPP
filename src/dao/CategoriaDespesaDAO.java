package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.CategoriaDespesa;

public class CategoriaDespesaDAO {
	private Connection conn;
	
	public CategoriaDespesaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (CategoriaDespesa categoriaDespesa) throws SQLException{
		PreparedStatement st = null;
		
		try {

			st = conn.prepareStatement("insert into categoria_despesa (descricao) values (?)");
			
			st.setString(1, categoriaDespesa.getDescricao());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

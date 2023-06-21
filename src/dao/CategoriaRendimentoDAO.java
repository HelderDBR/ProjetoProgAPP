package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<CategoriaRendimento> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from categoria_rendimento");
			rs = st.executeQuery();
			
			List<CategoriaRendimento> listaCategoriaRendimento = new ArrayList<>();
			
			while(rs.next()) {
				CategoriaRendimento categoriaRendimento = new CategoriaRendimento();
				
				categoriaRendimento.setDescricao(rs.getString("descricao"));
				
				listaCategoriaRendimento.add(categoriaRendimento);
			}
			
			return listaCategoriaRendimento;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}

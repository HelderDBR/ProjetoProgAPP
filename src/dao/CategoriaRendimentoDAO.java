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
	
	public CategoriaRendimento buscarPorCodigo(int codigo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from categoria_rendimento where codigo = ?");
			st.setInt(1, codigo);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				CategoriaRendimento categoriaRendimento = new CategoriaRendimento();
				
				categoriaRendimento.setCodigo(rs.getInt("codigo"));
				categoriaRendimento.setDescricao(rs.getString("descricao"));
				
				return categoriaRendimento;
			}
			
			return null;

		}finally {
			BancoDados.finalizarStatement(st);
			
<<<<<<< Updated upstream
			
=======
>>>>>>> Stashed changes
		}
	}
	
	public int excluir(int codigo) throws SQLException{
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from categoria_rendimento where codigo = ?");
			st.setInt(1, codigo);

			int modificacoes = st.executeUpdate();
			
			if(modificacoes != 0) {
				return modificacoes;
			}else {
				return 0;
			}
			
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

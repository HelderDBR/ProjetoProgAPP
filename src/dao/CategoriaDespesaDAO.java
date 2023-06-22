package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
	
	public List<CategoriaDespesa> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from categoria_despesa");
			rs = st.executeQuery();
			
			List<CategoriaDespesa> listaCategoriaDespesa = new ArrayList<>();
			
			while(rs.next()) {
				CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
				
				categoriaDespesa.setCodigo(rs.getInt("codigo"));
				categoriaDespesa.setDescricao(rs.getString("descricao"));
				
				listaCategoriaDespesa.add(categoriaDespesa);
			}
			
			return listaCategoriaDespesa;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public CategoriaDespesa buscarPorCodigo(int codigo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from categoria_despesa where codigo = ?");
			st.setInt(1, codigo);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
				
				categoriaDespesa.setCodigo(rs.getInt("codigo"));
				categoriaDespesa.setDescricao(rs.getString("descricao"));
				
				return categoriaDespesa;
			}
			
			return null;

		}finally {
			BancoDados.finalizarStatement(st);
			
		}
	}
	
	public void editar(CategoriaDespesa categoriaDespesa) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update categoria_despesa set descricao = ? where codigo = ?");
			
			st.setString(1, categoriaDespesa.getDescricao());
			st.setInt(2, categoriaDespesa.getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int codigo) throws SQLException{
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from categoria_despesa where codigo = ?");
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

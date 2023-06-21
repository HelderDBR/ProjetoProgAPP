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
}

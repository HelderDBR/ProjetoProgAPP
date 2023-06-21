package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.CategoriaDespesa;
import entities.CategoriaRendimento;
import entities.Despesas;

public class DespesaDAO {
	private Connection conn;
	
	public DespesaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (Despesas despesa) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into despesas (nome, valor, mes, ano, codigo_categoria_despesa) values (?, ?, ?, ?, ?)");
			
			st.setString(1, despesa.getNome());
			st.setFloat(2, despesa.getValor());
			st.setInt(3, despesa.getMes());
			st.setInt(4, despesa.getAno());
			st.setInt(5, despesa.getCategoriaDespesa().getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Despesas> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from despesas");
			rs = st.executeQuery();
			
			List<Despesas> listaDespesas = new ArrayList<>();
			
			while(rs.next()) {
				Despesas despesa = new Despesas();
				
				CategoriaDespesa categoriaDespesa = new CategoriaDespesaDAO(conn).buscarPorCodigo(rs.getInt("codigo_categoria_despesa"));
				
				despesa.setNome(rs.getString("nome"));
				despesa.setCategoriaDespesa(categoriaDespesa);
				despesa.setValor(rs.getFloat("valor"));
				despesa.setMes(rs.getInt("mes"));
				despesa.setAno(rs.getInt("ano"));
				
				listaDespesas.add(despesa);
			}
			
			return listaDespesas;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}

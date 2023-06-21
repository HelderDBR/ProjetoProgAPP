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
import entities.Rendimento;

public class RendimentoDAO {
	private Connection conn;
	
	public RendimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (Rendimento rendimento) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into rendimento (nome, valor, mes, ano, codigo_categoria_rendimento) values (?, ?, ?, ?, ?)");
			
			st.setString(1, rendimento.getNome());
			st.setFloat(2, rendimento.getValor());
			st.setInt(3, rendimento.getMes());
			st.setInt(4, rendimento.getAno());
			st.setInt(5, rendimento.getCategoriaRendimento().getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Rendimento> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from rendimento");
			rs = st.executeQuery();
			
			List<Rendimento> listaRendimentos = new ArrayList<>();
			
			while(rs.next()) {
				Rendimento rendimento = new Rendimento();
				
				rendimento.setNome(rs.getString("nome"));
				int codigoCategoriaRendimento = rs.getInt("codigo_categoria_rendimento");
				rendimento.setCategoriaRendimento(new CategoriaRendimento(codigoCategoriaRendimento, ""));
				rendimento.setValor(rs.getFloat("valor"));
				rendimento.setMes(rs.getInt("mes"));
				rendimento.setAno(rs.getInt("ano"));
				
				listaRendimentos.add(rendimento);
			}
			
			return listaRendimentos;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
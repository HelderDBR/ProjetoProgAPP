package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.CategoriaRendimento;
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
				
				CategoriaRendimento categoriaRendimento = new CategoriaRendimentoDAO(conn).buscarPorCodigo(rs.getInt("codigo_categoria_rendimento"));
				
				rendimento.setCodigo(rs.getInt("codigo"));
				rendimento.setNome(rs.getString("nome"));
				rendimento.setCategoriaRendimento(categoriaRendimento);
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
	
	public void editar(Rendimento rendimento) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update rendimento set nome = ?, valor = ?, mes = ?, ano = ?, codigo_categoria_rendimento = ? where codigo = ?");
			
			st.setString(1, rendimento.getNome());
			st.setFloat(2, rendimento.getValor());
			st.setInt(3, rendimento.getMes());
			st.setInt(4, rendimento.getAno());
			st.setInt(5, rendimento.getCategoriaRendimento().getCodigo());
			st.setInt(6, rendimento.getCodigo());
			
			st.executeUpdate();
			
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int codigo) throws SQLException{
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from rendimento where codigo = ?");
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
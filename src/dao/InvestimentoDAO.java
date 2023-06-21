package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Investimento;

public class InvestimentoDAO {
	
	private Connection conn;
	
	public InvestimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Investimento investimento) throws SQLException{
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO investimento (nome, valor, mes, ano) VALUES (?, ?, ?, ?)");
			
			st.setString(1, investimento.getNome());
			st.setFloat(2, investimento.getValor());
			st.setInt(3, investimento.getMes());
			st.setInt(4, investimento.getAno());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
	}
	
	public List<Investimento> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from investimento");
			rs = st.executeQuery();
			
			List<Investimento> listaInvestimentos = new ArrayList<>();
			
			while(rs.next()) {
				Investimento investimento = new Investimento();
				
				investimento.setNome(rs.getString("nome"));
				investimento.setValor(rs.getFloat("valor"));
				investimento.setMes(rs.getInt("mes"));
				investimento.setAno(rs.getInt("ano"));
				
				listaInvestimentos.add(investimento);
			}
			
			return listaInvestimentos;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void editar(Investimento investimento) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update investimento nome = ?, valor = ?, mes = ?, ano = ? where codigo = ?");
			
			st.setString(1, investimento.getNome());
			st.setFloat(2, investimento.getValor());
			st.setInt(3, investimento.getMes());
			st.setInt(4, investimento.getAno());
			
			st.executeUpdate();
			
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int codigo) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from investimento where codigo = ?");
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
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.FundoDespesasOcasionais;

public class FundoDespesasOcasionaisDAO {
	private Connection conn;
	
	public FundoDespesasOcasionaisDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (FundoDespesasOcasionais fundoDespesasOcasionais) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into fundo_despesas_ocasionais (nome, valor, recorrencia) values (?, ?, ?)");
			
			st.setString(1, fundoDespesasOcasionais.getNome());
			st.setFloat(2, fundoDespesasOcasionais.getValor());
			st.setBoolean(3, fundoDespesasOcasionais.isRecorrencia());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

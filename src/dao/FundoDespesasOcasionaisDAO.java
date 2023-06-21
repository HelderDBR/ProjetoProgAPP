package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.FundoDespesasOcasionais;

public class FundoDespesasOcasionaisDAO {
	private Connection conn;
	
	public FundoDespesasOcasionaisDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (FundoDespesasOcasionais fundoDespesasOcasionais) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into fundo_despesas_ocasionais (nome, valor, mes, ano) values (?, ?, ?, ?)");
			
			st.setString(1, fundoDespesasOcasionais.getNome());
			st.setFloat(2, fundoDespesasOcasionais.getValor());
			st.setInt(3, fundoDespesasOcasionais.getMes());
			st.setInt(4, fundoDespesasOcasionais.getAno());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<FundoDespesasOcasionais> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from fundo_despesas_ocasionais");
			rs = st.executeQuery();
			
			List<FundoDespesasOcasionais> listaFundoDespesasOcasionais = new ArrayList<>();
			
			while(rs.next()) {
				FundoDespesasOcasionais fundoDespesasOcasionais = new FundoDespesasOcasionais();
				
				fundoDespesasOcasionais.setNome(rs.getString("nome"));
				fundoDespesasOcasionais.setValor(rs.getFloat("valor"));
				fundoDespesasOcasionais.setMes(rs.getInt("mes"));
				fundoDespesasOcasionais.setAno(rs.getInt("ano"));
				
				listaFundoDespesasOcasionais.add(fundoDespesasOcasionais);
			}
			
			return listaFundoDespesasOcasionais;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public int excluir(int codigo) throws SQLException{
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from fundo_despesas_ocasionais where codigo = ?");
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

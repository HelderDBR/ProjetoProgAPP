package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.FundoDespesasOcasionais;

public class FundoDespesasOcasionaisDAOTeste{
	public static void main(String[] args)  throws SQLException, IOException{
		FundoDespesasOcasionais fundoDespesasOcasionais = new FundoDespesasOcasionais();
		
		fundoDespesasOcasionais.setNome("IPTU");
		fundoDespesasOcasionais.setValor(25);
		fundoDespesasOcasionais.setRecorrencia(false);
		
		Connection conn = BancoDados.conectar();
		
		new FundoDespesasOcasionaisDAO(conn).cadastrar(fundoDespesasOcasionais);
	}
}
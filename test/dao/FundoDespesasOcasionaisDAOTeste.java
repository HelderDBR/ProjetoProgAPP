package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.FundoDespesasOcasionais;

public class FundoDespesasOcasionaisDAOTeste{
	public static void main(String[] args)  throws SQLException, IOException{
		FundoDespesasOcasionais fundoDespesasOcasionais = new FundoDespesasOcasionais();
		
		fundoDespesasOcasionais.setNome("IPTU");
		fundoDespesasOcasionais.setValor(25);
		
		Connection conn = BancoDados.conectar();
		
		//new FundoDespesasOcasionaisDAO(conn).cadastrar(fundoDespesasOcasionais);
		
		List<FundoDespesasOcasionais> fdo = new FundoDespesasOcasionaisDAO(conn).buscarTodos();
		fdo.forEach(System.out::println);
	}
}
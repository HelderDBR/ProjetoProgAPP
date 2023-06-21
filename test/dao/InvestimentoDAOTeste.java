package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Investimento;

public class InvestimentoDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		Investimento investimento = new Investimento();
		
		investimento.setNome("CDB");
		investimento.setValor(150);
		//investimento.setRecorrencia(false);
		
		List<Investimento> investimentos = new InvestimentoDAO(conn).buscarTodos();
		investimentos.forEach(System.out::println);
	}
}
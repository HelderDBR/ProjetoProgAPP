package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.CategoriaRendimento;
import entities.FundoDespesasOcasionais;

public class CategoriaRendimentoDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		CategoriaRendimento categoriaRendimento = new CategoriaRendimento();
		
		categoriaRendimento.setDescricao("Teste");
		
		Connection conn = BancoDados.conectar();
		
		//new CategoriaRendimentoDAO(conn).cadastrar(categoriaRendimento);
		
		List<CategoriaRendimento> catRendimento = new CategoriaRendimentoDAO(conn).buscarTodos();
		catRendimento.forEach(System.out::println);
	}
}
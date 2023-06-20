package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.CategoriaRendimento;

public class CategoriaRendimentoDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		CategoriaRendimento categoriaRendimento = new CategoriaRendimento();
		
		categoriaRendimento.setDescricao("Teste");
		
		Connection conn = BancoDados.conectar();
		
		new CategoriaRendimentoDAO(conn).cadastrar(categoriaRendimento);
	}
}
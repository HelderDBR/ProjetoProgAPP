package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Rendimento;
import entities.CategoriaRendimento;

public class RendimentoDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		Rendimento rendimento = new Rendimento();
		
		rendimento.setNome("Oioi");
		rendimento.setValor(240);
		rendimento.setCategoriaRendimento(new CategoriaRendimento(2, "Teste"));
		
		Connection conn = BancoDados.conectar();
		
		//List<Rendimento> listaRendimentos = new RendimentoDAO(conn).buscarTodos();
		
		//listaRendimentos.forEach(System.out::println);
		new RendimentoDAO(conn).cadastrar(rendimento);

	}
}
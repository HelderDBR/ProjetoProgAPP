package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Rendimento;
import entities.CategoriaRendimento;

public class RendimentoDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		Rendimento rendimento = new Rendimento();
		
		rendimento.setNome("Teste");
		rendimento.setValor(100);
		rendimento.setRecorrencia(true);
		rendimento.setCategoriaRendimento(new CategoriaRendimento(2, "Teste"));
		
		Connection conn = BancoDados.conectar();
		
		new RendimentoDAO(conn).cadastrar(rendimento);
	}
}

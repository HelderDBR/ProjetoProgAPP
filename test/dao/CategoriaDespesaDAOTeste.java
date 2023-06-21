package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.CategoriaDespesa;

public class CategoriaDespesaDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
		
		categoriaDespesa.setDescricao("Alimentacao");
		
		Connection conn = BancoDados.conectar();
		
		new CategoriaDespesaDAO(conn).cadastrar(categoriaDespesa);
	}
}
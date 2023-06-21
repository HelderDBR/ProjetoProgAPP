package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.CategoriaDespesa;

public class CategoriaDespesaDAOTeste {
	public static void main(String[] args) throws SQLException, IOException {
		/*
		 * CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
		 * 
		 * categoriaDespesa.setDescricao("Serviços");
		 */ 
		 Connection conn = BancoDados.conectar();
		 
		List<CategoriaDespesa> listaCategoriaDespesa = new ArrayList<>();
		
		listaCategoriaDespesa = new CategoriaDespesaDAO(conn).buscarTodos();
		
		listaCategoriaDespesa.forEach(System.out::println);
	}
}
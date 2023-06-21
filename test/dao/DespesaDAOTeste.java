package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.CategoriaDespesa;
import entities.Despesas;

public class DespesaDAOTeste {
	public static void main(String[] args) throws IOException, SQLException{
		Despesas despesa = new Despesas();
		
		despesa.setCategoria(new CategoriaDespesa(2, "Serviços"));
		despesa.setNome("Spotify");
		despesa.setValor((float) 9.90);
		despesa.setMes(0);
		despesa.setAno(2023);
		
		Connection conn = BancoDados.conectar();
		
		//new DespesaDAO(conn).cadastrar(despesa);
		
		List<Despesas> listaDespesas = new ArrayList<>();
		
		listaDespesas = new DespesaDAO(conn).buscarTodos();
		
		listaDespesas.forEach(System.out::println);
		
		new DespesaDAO(conn).excluir(2);
	}
}
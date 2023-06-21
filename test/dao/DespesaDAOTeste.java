package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.CategoriaDespesa;
import entities.Despesas;

public class DespesaDAOTeste {
	public static void main(String[] args) throws IOException, SQLException{
		Despesas despesa = new Despesas();
		
		despesa.setCategoria(new CategoriaDespesa(2, "Serviços"));
		despesa.setNome("Netflix");
		despesa.setValor(20);
		despesa.setMes(0);
		despesa.setAno(2023);
		
		Connection conn = BancoDados.conectar();
		
		new DespesaDAO(conn).cadastrar(despesa);
	}
}
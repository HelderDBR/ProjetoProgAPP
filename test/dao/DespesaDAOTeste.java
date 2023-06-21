package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.CategoriaDespesa;
import entities.Despesas;

public class DespesaDAOTeste {
	public static void main(String[] args) throws IOException, SQLException{
		Despesas despesa = new Despesas();
		
		despesa.setCategoria(new CategoriaDespesa(1, "Live"));
		despesa.setNome("Mercado");
		despesa.setValor(400);
		despesa.setRecorrencia(false);
		
		Connection conn = BancoDados.conectar();
		
		new DespesaDAO(conn).cadastrar(despesa);
	}
}
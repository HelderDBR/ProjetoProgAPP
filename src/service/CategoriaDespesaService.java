package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.CategoriaDespesa;
import dao.CategoriaDespesaDAO;

public class CategoriaDespesaService {
	public void cadastrarCategoriaDespesa(CategoriaDespesa categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaDespesaDAO(conn).cadastrar(categoria);
	}

	public List<CategoriaDespesa> buscarCategoriasDespesa() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new CategoriaDespesaDAO(conn).buscarTodos();
	}

	public void excluirCategoriaDespesa(int codigoCategoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaDespesaDAO(conn).excluir(codigoCategoria);
	}
}

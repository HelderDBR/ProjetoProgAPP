package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.CategoriaRendimento;
import dao.CategoriaRendimentoDAO;

public class CategoriaRendimentoService {
	public void cadastrarCategoriaRendimento(CategoriaRendimento categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaRendimentoDAO(conn).cadastrar(categoria);
	}

	public List<CategoriaRendimento> buscarCategoriasRendimento() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new CategoriaRendimentoDAO(conn).buscarTodos();
	}
	
	public void editarCategoriaRendimento (int codigoCategoria, CategoriaRendimento categoria)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new CategoriaRendimentoDAO(conn).editar(codigoCategoria, categoria);
	}

	public void excluirCategoriaRendimento(int codigoCategoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaRendimentoDAO(conn).excluir(codigoCategoria);
	}

}

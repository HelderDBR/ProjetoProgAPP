package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.Categoria;
import entities.CategoriaRendimento;
import dao.CategoriaDAO;
import dao.CategoriaRendimentoDAO;

public class CategoriaService {

	public void cadastrarCategoria(CategoriaRendimento categoria) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new CategoriaRendimentoDAO(conn).cadastrar(categoria);
		}

	public List<CategoriaRendimento> buscarCategorias() throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			return new CategoriaRendimentoDAO(conn).buscarTodos();
		}
	
	public void excluirCategoria(int codigoCategoria) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new CategoriaRendimentoDAO(conn).excluir(codigoCategoria);
		}
}

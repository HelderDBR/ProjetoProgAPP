package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.Categoria;
import dao.CategoriaDAO;

public class CategoriaService {

	public void cadastrarCategoria(Categoria categoria) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new CategoriaDAO(conn).cadastrar(categoria);
		}

	public List<Categoria> buscarCategorias() throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			return new CategoriaDAO(conn).buscarTodos();
		}
	
	public void excluirCategoria(int codigoCategoria) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new CategoriaDAO(conn).excluir(codigoCategoria);
		}
}

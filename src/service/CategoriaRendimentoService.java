package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.CategoriaRendimento;
import entities.Rendimento;
import dao.CategoriaRendimentoDAO;
import dao.RendimentoDAO;

public class CategoriaRendimentoService {
	public void cadastrarCategoriaRendimento(CategoriaRendimento categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaRendimentoDAO(conn).cadastrar(categoria);
	}

	public List<CategoriaRendimento> buscarCategoriasRendimento() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new CategoriaRendimentoDAO(conn).buscarTodos();
	}
	
	public void editarCategoriaRendimento (CategoriaRendimento categoria)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new CategoriaRendimentoDAO(conn).editar(categoria);
	}

	public void excluirCategoriaRendimento(int codigoCategoria) throws SQLException, IOException {
		
		RendimentoService rnd = new RendimentoService();
		List<Rendimento> rendimento = rnd.buscarRendimentos();
		
		for(Rendimento rendi: rendimento)
		{
			if(rendi.getCategoriaRendimento().getCodigo() == codigoCategoria)
			{
				rnd.excluirRendimento(rendi.getCodigo());
			}
		}
		Connection conn = BancoDados.conectar();
		new CategoriaRendimentoDAO(conn).excluir(codigoCategoria);
	}

}

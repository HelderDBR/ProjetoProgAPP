package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.CategoriaDespesa;
import entities.CategoriaRendimento;
import entities.Despesas;
import entities.Rendimento;
import dao.CategoriaDespesaDAO;
import dao.CategoriaRendimentoDAO;

public class CategoriaDespesaService {
	public void cadastrarCategoriaDespesa(CategoriaDespesa categoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CategoriaDespesaDAO(conn).cadastrar(categoria);
	}

	public List<CategoriaDespesa> buscarCategoriasDespesa() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new CategoriaDespesaDAO(conn).buscarTodos();
	}
	
	public void editarCategoriaDespesa (CategoriaDespesa categoria)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new CategoriaDespesaDAO(conn).editar(categoria);
	}

	public void excluirCategoriaDespesa(int codigoCategoria) throws SQLException, IOException {
		
		DespesasService rnd = new DespesasService();
		List<Despesas> despesas = rnd.buscarDespesas();
		
		for(Despesas rendi: despesas)
		{
			if(rendi.getCategoriaDespesa().getCodigo() == codigoCategoria)
			{
				rnd.excluirDespesas(rendi.getCodigo());
			}
		}
		Connection conn = BancoDados.conectar();
		new CategoriaDespesaDAO(conn).excluir(codigoCategoria);
	}
}

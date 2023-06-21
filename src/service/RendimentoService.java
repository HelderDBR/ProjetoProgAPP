package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CategoriaDespesaDAO;
import entities.CategoriaDespesa;
import entities.Rendimento;
import dao.RendimentoDAO;

public class RendimentoService {

	public void cadastrarRendimento(Rendimento rendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new RendimentoDAO(conn).cadastrar(rendimento);
	}

	public List<Rendimento> buscarRendimentos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new RendimentoDAO(conn).buscarTodos();
	}
	
	public void editarRendimento (Rendimento rendimento)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new RendimentoDAO(conn).editar(rendimento);
	}

	public void excluirRendimento(int codigoRendimento) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new RendimentoDAO(conn).excluir(codigoRendimento);
	}
	
}

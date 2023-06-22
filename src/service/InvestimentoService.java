package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CategoriaDespesaDAO;
import entities.CategoriaDespesa;
import entities.Investimento;
import dao.InvestimentoDAO;

public class InvestimentoService {

	public void cadastrarInvestimento(Investimento investimento) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new InvestimentoDAO(conn).cadastrar(investimento);
		}
	
	public List<Investimento> buscarInvestimento() throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			return new InvestimentoDAO(conn).buscarTodos();
		}
	
	public void editarInvestimento (Investimento investimento)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new InvestimentoDAO(conn).editar(investimento);
	}
	
	public void excluirInvestimento(int codigoInvestimento) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new InvestimentoDAO(conn).excluir(codigoInvestimento);
		}
	
}

package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CategoriaRendimentoDAO;
import entities.CategoriaRendimento;
import entities.Despesas;
import dao.DespesaDAO;

public class DespesasService {
	
	public void cadastrarDespesas(Despesas despesas) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new DespesaDAO(conn).cadastrar(despesas);
		}
	
	public List<Despesas> buscarDespesas() throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			return new DespesaDAO(conn).buscarTodos();
		}
	
	public void editarDespesas (Despesas despesas)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new DespesaDAO(conn).editar(despesas);
	}
	
	public void excluirDespesas(int codigoDespesas) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new DespesaDAO(conn).excluir(codigoDespesas);
		}
		

}

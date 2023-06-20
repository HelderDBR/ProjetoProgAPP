package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import entities.Despesas;
import dao.DespesasDAO;

public class DespesasService {
	
	public void cadastrarDespesas(Despesas despesas) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new DespesasDAO(conn).cadastrar(despesas);
		}
	
	public List<Despesas> buscarDespesas() throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			return new DespesasDAO(conn).buscarTodos();
		}
	
	public void excluirDespesas(int codigoDespesas) throws SQLException, IOException {
			
			Connection conn = BancoDados.conectar();
			new Despesas(conn).excluir(codigoDespesas);
		}
		

}

package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CategoriaRendimentoDAO;
import entities.CategoriaRendimento;
import entities.FundoDespesasOcasionais;
import dao.FundoDespesasOcasionaisDAO;

public class FundoDespesasOcasionaisService {

	public void cadastrarFundoDespesasOcasionais(FundoDespesasOcasionais fundoDespesasOcasionais) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new FundoDespesasOcasionaisDAO(conn).cadastrar(fundoDespesasOcasionais);
	}

	public List<FundoDespesasOcasionais> buscarFundoDespesasOcasionais() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new FundoDespesasOcasionaisDAO(conn).buscarTodos();
	}

	public void editarFundoDespesasOcasionais (int codigoFundo, FundoDespesasOcasionais fundo)throws SQLException, IOException
	{
		Connection conn = BancoDados.conectar();
		new FundoDespesasOcasionaisDAO(conn).editar(codigoFundo, fundo);
	}
	
	public void excluirFundoDespesasOcasionais(int codigoFundoDespesasOcasionais) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new FundoDespesasOcasionaisDAO(conn).excluir(codigoFundoDespesasOcasionais);
	}
	
}

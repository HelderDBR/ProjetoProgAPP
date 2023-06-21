package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Despesas;

public class DespesaDAO {
	private Connection conn;
	
	public DespesaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (Despesas despesa) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into despesas (nome, valor, mes, ano, codigo_categoria_despesa) values (?, ?, ?, ?, ?)");
			
			st.setString(1, despesa.getNome());
			st.setFloat(2, despesa.getValor());
			st.setInt(3, despesa.getMes());
			st.setInt(4, despesa.getAno());
			st.setInt(5, despesa.getCategoriaDespesa().getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

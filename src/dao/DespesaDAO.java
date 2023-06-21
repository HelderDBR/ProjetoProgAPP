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

			st = conn.prepareStatement("insert into despesas (nome, valor, recorrencia, codigo_categoria_despesa) values (?, ?, ?, ?)");
			
			st.setString(1, despesa.getNome());
			st.setFloat(2, despesa.getValor());
			st.setBoolean(3, despesa.isRecorrencia());
			st.setInt(4, despesa.getCategoriaDespesa().getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

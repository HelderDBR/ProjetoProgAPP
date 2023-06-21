package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Rendimento;

public class RendimentoDAO {
	private Connection conn;
	
	public RendimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar (Rendimento rendimento) throws SQLException{
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into rendimento (nome, valor, mes, ano, codigo_categoria_rendimento) values (?, ?, ?, ?, ?)");
			
			st.setString(1, rendimento.getNome());
			st.setFloat(2, rendimento.getValor());
			st.setInt(3, rendimento.getMes());
			st.setInt(4, rendimento.getAno());
			st.setInt(5, rendimento.getCategoriaRendimento().getCodigo());
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
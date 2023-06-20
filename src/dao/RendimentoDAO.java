package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> main

import entities.Rendimento;

public class RendimentoDAO {
	private Connection conn;
	
<<<<<<< HEAD
	public RendimentoDAO(Connection conn) {
		this.conn = conn;
	}
	
=======
>>>>>>> main
	public void cadastrar (Rendimento rendimento) throws SQLException{
		PreparedStatement st = null;
		
		try {
<<<<<<< HEAD
			st = conn.prepareStatement("insert into rendimento (nome, valor, recorrencia, codigo_categoria_rendimento) values (1, 2, 3, 4)");
			
			st.setString(1, rendimento.getNome());
			st.setFloat(2, rendimento.getValor());
			st.setBoolean(3, rendimento.isRecorrencia());
			st.setInt(4, rendimento.getCategoria().getCodigo());
=======
			st = conn.prepareStatement("insert into rendimento (categoria, nome, valor, recorrencia) values (1, 2, 3, 4)");
			
			st.setString(1, rendimento.getCategoria());
			st.setString(2, rendimento.getNome());
			st.setString(3, "oi");
			st.setBoolean(4, rendimento.getRecorrencia());
>>>>>>> main
			
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
package entities;

public class CategoriaRendimento {
	int codigo;
	String descricao;
	
	public CategoriaRendimento() {
		
	}
	
	public CategoriaRendimento(String descricao) {
		this.descricao = descricao;
	}
	
	public CategoriaRendimento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

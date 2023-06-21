package entities;

public class CategoriaDespesa {
	int codigo;
	String descricao;
	
	public CategoriaDespesa() {
	}
	
	public CategoriaDespesa(String descricao) {
		this.descricao = descricao;
	}
	
	public CategoriaDespesa(int codigo, String descricao) {
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

	@Override
	public String toString() {
		return this.getDescricao();
	}
	
	
}

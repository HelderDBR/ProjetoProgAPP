package entities;

public class Categoria {

	private int codigo;
	private String nome;
	
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
	public Categoria(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

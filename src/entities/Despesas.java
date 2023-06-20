package entities;

public class Despesas {

	private int codigo;
	private String categoria;
	private String nome;
	private float valor;
	private boolean recorrencia;
	
	public Despesas() {
		
	}
	
	public Despesas(int codigo, String categoria, String nome, float valor, boolean recorrencia) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}
	

	@Override
	public String toString() {
		return "Rendimento [codigo=" + codigo + ", categoria=" + categoria + ", nome=" + nome + ", valor=" + valor
				+ ", recorrencia=" + recorrencia + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isRecorrencia() {
		return recorrencia;
	}

	public void setRecorrencia(boolean recorrencia) {
		this.recorrencia = recorrencia;
	}
	
	
	
}

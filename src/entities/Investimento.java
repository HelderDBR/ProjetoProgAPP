package entities;

public class Investimento {

	private int codigo;
	private String nome;
	private float valor;
	private boolean recorrencia;
	
	public Investimento() {
	}

	public Investimento(int codigo, String nome, float valor, boolean recorrencia) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}

	@Override
	public String toString() {
		return "Investimento [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", recorrencia=" + recorrencia
				+ "]";
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

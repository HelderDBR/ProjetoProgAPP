package entities;

public class Despesas {

	private int codigo;
	private CategoriaDespesa categoriaDespesa;
	private String nome;
	private float valor;
	private boolean recorrencia;
	
	public Despesas() {
		
	}
	
	public Despesas(CategoriaDespesa categoriaDespesa, String nome, float valor, boolean recorrencia) {
		super();
		this.categoriaDespesa = categoriaDespesa;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}
	
	public Despesas(int codigo, CategoriaDespesa categoriaDespesa, String nome, float valor, boolean recorrencia) {
		super();
		this.codigo = codigo;
		this.categoriaDespesa = categoriaDespesa;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}
	

	@Override
	public String toString() {
		return "Rendimento [codigo=" + codigo + ", categoria=" + categoriaDespesa + ", nome=" + nome + ", valor=" + valor
				+ ", recorrencia=" + recorrencia + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaDespesa getCategoriaDespesa() {
		return categoriaDespesa;
	}

	public void setCategoria(CategoriaDespesa categoriaDespesa) {
		this.categoriaDespesa = categoriaDespesa;
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

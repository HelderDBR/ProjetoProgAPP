package entities;

public class Rendimento {

	private int codigo;
	private CategoriaRendimento categoriaRendimento;
	private String nome;
	private float valor;
	private boolean recorrencia;
	
	public Rendimento() {
		
	}

	public Rendimento(Categoria categoria, String nome, float valor, boolean recorrencia) {
		super();
		this.categoria = categoria;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}
	
	public Rendimento(int codigo, CategoriaRendimento categoriaRendimento, String nome, float valor, boolean recorrencia) {
		super();
		this.categoria = categoria;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}
	
	public Rendimento(int codigo, Categoria categoria, String nome, float valor, boolean recorrencia) {
		super();
		this.codigo = codigo;
		this.categoriaRendimento = categoriaRendimento;
		this.nome = nome;
		this.valor = valor;
		this.recorrencia = recorrencia;
	}

	@Override
	public String toString() {
		return "Rendimento [codigo=" + codigo + ", categoria=" + categoriaRendimento + ", nome=" + nome + ", valor=" + valor
				+ ", recorrencia=" + recorrencia + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaRendimento getCategoriaRendimento() {
		return categoriaRendimento;
	}

	public void setCategoriaRendimento(CategoriaRendimento categoriaRendimento) {
		this.categoriaRendimento = categoriaRendimento;
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

package entities;


public class Rendimento {

	private int codigo;
	private CategoriaRendimento categoriaRendimento;
	private String nome;
	private float valor;
	private int mes;
	private int ano;
	
	public Rendimento() {
		
	}

	public Rendimento(CategoriaRendimento categoriaRendimento, String nome, float valor, int mes, int ano) {
		super();
		this.categoriaRendimento = categoriaRendimento;
		this.nome = nome;
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Rendimento(int codigo, CategoriaRendimento categoriaRendimento, String nome, float valor, int mes, int ano) {
		super();
		this.codigo = codigo;
		this.categoriaRendimento = categoriaRendimento;
		this.nome = nome;
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}

	
	@Override
	public String toString() {
		return "Rendimento [categoriaRendimento=" + categoriaRendimento + ", nome=" + nome
				+ ", valor=" + valor + ", mes=" + mes + ", ano=" + ano + "]";
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

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	
}

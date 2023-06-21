package entities;

public class FundoDespesasOcasionais {
	
	private int codigo;
	private String nome;
	private float valor;
	private int mes;
	private int ano;
	
	public FundoDespesasOcasionais() {
	}
	
	public FundoDespesasOcasionais(String nome, float valor, int mes, int ano) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}

	public FundoDespesasOcasionais(int codigo, String nome, float valor, int mes, int ano) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}

	
	@Override
	public String toString() {
		return this.getNome() + this.getValor();
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

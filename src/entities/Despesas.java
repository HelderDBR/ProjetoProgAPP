package entities;

public class Despesas {

	private int codigo;
	private CategoriaDespesa categoriaDespesa;
	private String nome;
	private float valor;
	private int mes;
	private int ano;
	
	public Despesas() {
		
	}
	
	public Despesas(CategoriaDespesa categoriaDespesa, String nome, float valor, int mes, int ano) {
		super();
		this.categoriaDespesa = categoriaDespesa;
		this.nome = nome;
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Despesas(int codigo, CategoriaDespesa categoriaDespesa, String nome, float valor, int mes, int ano) {
		super();
		this.codigo = codigo;
		this.categoriaDespesa = categoriaDespesa;
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

	public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
		this.categoriaDespesa = categoriaDespesa;
	}


	
	
}

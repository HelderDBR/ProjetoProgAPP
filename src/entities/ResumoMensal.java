package entities;

public class ResumoMensal {

	private float rendimento;
	private float investimentosLongoPrazo;
	private float fundoDespesasOcasionais;
	private float totalDisponivel;
	private float totalDespesas;
	private float total;
	
	public ResumoMensal(float rendimento, float investimentosLongoPrazo, float fundoDespesasOcasionais,
			float totalDisponivel, float totalDespesas, float total) {
		super();
		this.rendimento = rendimento;
		this.investimentosLongoPrazo = investimentosLongoPrazo;
		this.fundoDespesasOcasionais = fundoDespesasOcasionais;
		this.totalDisponivel = totalDisponivel;
		this.totalDespesas = totalDespesas;
		this.total = total;
	}
	@Override
	public String toString() {
		return "ResumoMensal [rendimento=" + rendimento + ", investimentosLongoPrazo=" + investimentosLongoPrazo
				+ ", fundoDespesasOcasionais=" + fundoDespesasOcasionais + ", totalDisponivel=" + totalDisponivel
				+ ", totalDespesas=" + totalDespesas + ", total=" + total + "]";
	}
	public float getRendimento() {
		return rendimento;
	}
	public void setRendimento(float rendimento) {
		this.rendimento = rendimento;
	}
	public float getInvestimentosLongoPrazo() {
		return investimentosLongoPrazo;
	}
	public void setInvestimentosLongoPrazo(float investimentosLongoPrazo) {
		this.investimentosLongoPrazo = investimentosLongoPrazo;
	}
	public float getFundoDespesasOcasionais() {
		return fundoDespesasOcasionais;
	}
	public void setFundoDespesasOcasionais(float fundoDespesasOcasionais) {
		this.fundoDespesasOcasionais = fundoDespesasOcasionais;
	}
	public float getTotalDisponivel() {
		return totalDisponivel;
	}
	public void setTotalDisponivel(float totalDisponivel) {
		this.totalDisponivel = totalDisponivel;
	}
	public float getTotalDespesas() {
		return totalDespesas;
	}
	public void setTotalDespesas(float totalDespesas) {
		this.totalDespesas = totalDespesas;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}

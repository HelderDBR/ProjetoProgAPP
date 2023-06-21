package entities;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import service.*;

public class ResumoMensal {

	private float rendimento = 0;
	private float investimentosLongoPrazo = 0;
	private float fundoDespesasOcasionais = 0;
	private float totalDisponivel = 0;
	private float totalDespesas = 0;
	private float total = 0;
	
	public ResumoMensal(int mes, int ano) throws SQLException, IOException
	{
		RendimentoService rendimentos = new RendimentoService();
		List<Rendimento> rendimento = rendimentos.buscarRendimentos();
		for(Rendimento rendi : rendimento)
		{
			if((mes == rendi.getMes() && ano == rendi.getAno()) || rendi.getMes() == 0)
			{
				this.rendimento = this.rendimento + rendi.getValor();
			}
		}
		
		InvestimentoService investimentos = new InvestimentoService();
		List<Investimento> investimento = investimentos.buscarInvestimento();
		for(Investimento inves : investimento)
		{
			if((mes == inves.getMes() && ano == inves.getAno()) || inves.getMes() == 0)
			{
				this.investimentosLongoPrazo = this.investimentosLongoPrazo + inves.getValor();
			}
		}

		FundoDespesasOcasionaisService fundos = new FundoDespesasOcasionaisService();
		List<FundoDespesasOcasionais> fundosOcasionais = fundos.buscarFundoDespesasOcasionais();
		for(FundoDespesasOcasionais fund : fundosOcasionais)
		{
			if((mes == fund.getMes() && ano == fund.getAno()) || fund.getMes() == 0)
			{
				this.fundoDespesasOcasionais = this.fundoDespesasOcasionais + fund.getValor();
			}
		}
		
		this.totalDisponivel = this.rendimento - this.investimentosLongoPrazo - this.fundoDespesasOcasionais;
		
		DespesasService despesa = new DespesasService();
		List<Despesas> despesas = despesa.buscarDespesas();
		for(Despesas desp : despesas)
		{
			if((mes == desp.getMes() && ano == desp.getAno()) || desp.getMes() == 0)
			{
				this.totalDespesas = this.totalDespesas + desp.getValor();
			}
		}
		
		this.total = this.totalDisponivel - totalDespesas;
	}
	
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

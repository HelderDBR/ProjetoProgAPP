package entities;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import service.*;

public class ResumoAnual{

	private float rendimentoMensal = 0;
	private float rendimentoOcasional = 0;
	private float rendimentoAnual;
	private float investimentoMensal;
	private float investimentoAnual;
	private float investimentoOcasional;
	private float fundoMensal;
	private float fundoOcasional;
	private float fundoAnual;
	private float totalDisponivel;
	private float totalDespesasMensal;
	private float totalDespesasOcasional;
	private float total;
	
	public ResumoAnual() throws SQLException, IOException
	{
		RendimentoService rendimentos = new RendimentoService();
		List<Rendimento> rendimento = rendimentos.buscarRendimentos();
		for(Rendimento rendi : rendimento)
		{
			if(rendi.isRecorrencia() == true)
			{
				this.rendimentoMensal = this.rendimentoMensal + rendi.getValor();
			}else {
				this.rendimentoOcasional = this.rendimentoOcasional + rendi.getValor();
			}
			
		}
		this.rendimentoMensal = this.rendimentoMensal*12;
		
		this.rendimentoAnual = this.rendimentoMensal + this.rendimentoOcasional;
		
		
		InvestimentoService investimentos = new InvestimentoService();
		List<Investimento> investimento = investimentos.buscarInvestimento();
		for(Investimento inves : investimento)
		{
			if(inves.isRecorrencia() == true) 
			{
				this.investimentoMensal = this.investimentoMensal + inves.getValor();
			}else {
				this.investimentoOcasional = this.investimentoOcasional + inves.getValor();
			}
		}
		
		this.investimentoMensal = this.investimentoMensal*12;

		this.investimentoAnual = this.investimentoMensal + this.investimentoOcasional;

		
		FundoDespesasOcasionaisService fundos = new FundoDespesasOcasionaisService();
		List<FundoDespesasOcasionais> fundosOcasionais = fundos.buscarFundoDespesasOcasionais();
		for(FundoDespesasOcasionais fund : fundosOcasionais)
		{
			if(fund.isRecorrencia() == true)
			{
				this.fundoMensal = this.fundoMensal + fund.getValor();
			}else {
				this.fundoOcasional = this.fundoOcasional + fund.getValor();
			}
		}
		this.fundoMensal = this.fundoMensal*12;
		
		this.fundoAnual = this.fundoMensal + this.fundoOcasional;
		
		
		this.totalDisponivel = totalDisponivel;
		this.totalDespesasMensal = totalDespesasMensal;
		this.totalDespesasOcasional = totalDespesasOcasional;
		this.total = total;
		
		
	}
	
	public ResumoAnual(float rendimentoMensal, float rendimentoOcasional, float rendimentoAnual,
			float investimentoMensal, float investimentoAnual, float investimentoOcasional, float fundoMensal,
			float fundoOcasional, float fundoAnual, float totalDisponivel, float totalDespesasMensal,
			float totalDespesasOcasional, float total) {
		super();
		this.rendimentoMensal = rendimentoMensal;
		this.rendimentoOcasional = rendimentoOcasional;
		this.rendimentoAnual = rendimentoAnual;
		this.investimentoMensal = investimentoMensal;
		this.investimentoAnual = investimentoAnual;
		this.investimentoOcasional = investimentoOcasional;
		this.fundoMensal = fundoMensal;
		this.fundoOcasional = fundoOcasional;
		this.fundoAnual = fundoAnual;
		this.totalDisponivel = totalDisponivel;
		this.totalDespesasMensal = totalDespesasMensal;
		this.totalDespesasOcasional = totalDespesasOcasional;
		this.total = total;
	}



	@Override
	public String toString() {
		return "ResumoAnual [rendimentoMensal=" + rendimentoMensal + ", rendimentoOcasional=" + rendimentoOcasional
				+ ", rendimentoAnual=" + rendimentoAnual + ", investimentoMensal=" + investimentoMensal
				+ ", investimentoAnual=" + investimentoAnual + ", investimentoOcasional=" + investimentoOcasional
				+ ", fundoMensal=" + fundoMensal + ", fundoOcasional=" + fundoOcasional + ", fundoAnual=" + fundoAnual
				+ ", totalDisponivel=" + totalDisponivel + ", totalDespesasMensal=" + totalDespesasMensal
				+ ", totalDespesasOcasional=" + totalDespesasOcasional + ", total=" + total + "]";
	}



	public float getRendimentoMensal() {
		return rendimentoMensal;
	}



	public void setRendimentoMensal(float rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}



	public float getRendimentoOcasional() {
		return rendimentoOcasional;
	}



	public void setRendimentoOcasional(float rendimentoOcasional) {
		this.rendimentoOcasional = rendimentoOcasional;
	}



	public float getRendimentoAnual() {
		return rendimentoAnual;
	}



	public void setRendimentoAnual(float rendimentoAnual) {
		this.rendimentoAnual = rendimentoAnual;
	}



	public float getInvestimentoMensal() {
		return investimentoMensal;
	}



	public void setInvestimentoMensal(float investimentoMensal) {
		this.investimentoMensal = investimentoMensal;
	}



	public float getInvestimentoAnual() {
		return investimentoAnual;
	}



	public void setInvestimentoAnual(float investimentoAnual) {
		this.investimentoAnual = investimentoAnual;
	}



	public float getInvestimentoOcasional() {
		return investimentoOcasional;
	}



	public void setInvestimentoOcasional(float investimentoOcasional) {
		this.investimentoOcasional = investimentoOcasional;
	}



	public float getFundoMensal() {
		return fundoMensal;
	}



	public void setFundoMensal(float fundoMensal) {
		this.fundoMensal = fundoMensal;
	}



	public float getFundoOcasional() {
		return fundoOcasional;
	}



	public void setFundoOcasional(float fundoOcasional) {
		this.fundoOcasional = fundoOcasional;
	}



	public float getFundoAnual() {
		return fundoAnual;
	}



	public void setFundoAnual(float fundoAnual) {
		this.fundoAnual = fundoAnual;
	}



	public float getTotalDisponivel() {
		return totalDisponivel;
	}



	public void setTotalDisponivel(float totalDisponivel) {
		this.totalDisponivel = totalDisponivel;
	}



	public float getTotalDespesasMensal() {
		return totalDespesasMensal;
	}



	public void setTotalDespesasMensal(float totalDespesasMensal) {
		this.totalDespesasMensal = totalDespesasMensal;
	}



	public float getTotalDespesasOcasional() {
		return totalDespesasOcasional;
	}



	public void setTotalDespesasOcasional(float totalDespesasOcasional) {
		this.totalDespesasOcasional = totalDespesasOcasional;
	}



	public float getTotal() {
		return total;
	}



	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}

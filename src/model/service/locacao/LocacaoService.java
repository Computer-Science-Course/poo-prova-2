package model.service.locacao;

import java.time.temporal.ChronoUnit;

import model.entities.locacao.LocacaoDiaria;
import model.entities.locacao.LocacaoLongoPeriodo;

public class LocacaoService implements LocacaoServiceInterface{

	private long days, hours, minutes;
	
	@Override
	public Double valorLocacaoDiaria(LocacaoDiaria locacao) {
		
		if(locacao.getDataRetirada() != null && locacao.getDataDevolucao() != null) {			
			this.days = ChronoUnit.DAYS.between(locacao.getDataRetirada(), locacao.getDataDevolucao());
			this.hours = ChronoUnit.HOURS.between(locacao.getDataRetirada(), locacao.getDataDevolucao()) - (days * 24);
			this.minutes = ChronoUnit.MINUTES.between(locacao.getDataRetirada(), locacao.getDataDevolucao()) - ((days * 24 * 60) + (hours * 60));
			
			Double valorDiaria = locacao.getCarro().getCategoria().getPrecoDiaria();
		
			return valorDiaria * (this.days + ((double) hours / 24) + ((double) minutes / 60 * 24));
		}
		
		return null;
	}

	@Override
	public Double valorLocacaoLongoPeriodo(LocacaoLongoPeriodo locacao) {
		if(locacao.getDataRetirada() != null && locacao.getDataDevolucao() != null) {			
			this.days = ChronoUnit.DAYS.between(locacao.getDataRetirada(), locacao.getDataDevolucao());
			this.hours = ChronoUnit.HOURS.between(locacao.getDataRetirada(), locacao.getDataDevolucao()) - (days * 24);
			this.minutes = ChronoUnit.MINUTES.between(locacao.getDataRetirada(), locacao.getDataDevolucao()) - ((days * 24 * 60) + (hours * 60));
			
			Double valorDiaria = locacao.getCarro().getCategoria().getPrecoDiaria();
			
			return (valorDiaria * (this.days + ((double) hours / 24) + ((double) minutes / 60 * 24))) * (1 - locacao.getPorcentagemDesconto());
		}
		
		return null;
	}

	public long getDays() {
		return days;
	}

	public long getHours() {
		return hours;
	}

	public long getMinutes() {
		return minutes;
	}
	
	

}

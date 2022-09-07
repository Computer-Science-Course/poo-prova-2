package model.entities.locacao;

import java.time.LocalDateTime;

public class LocacaoLongoPeriodo extends Locacao{
	private Double porcentagemDesconto;
	
	public LocacaoLongoPeriodo() {
		super();
	}

	public LocacaoLongoPeriodo(LocalDateTime dataRetirada, LocalDateTime dataDevolucao,Double porcentagemDesconto) {
		super(dataRetirada, dataDevolucao);
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}
	
}

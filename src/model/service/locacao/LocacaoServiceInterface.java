package model.service.locacao;

import model.entities.locacao.LocacaoDiaria;
import model.entities.locacao.LocacaoLongoPeriodo;

public interface LocacaoServiceInterface {
	Double valorLocacaoDiaria(LocacaoDiaria locacao);
	Double valorLocacaoLongoPeriodo(LocacaoLongoPeriodo locacao);
}

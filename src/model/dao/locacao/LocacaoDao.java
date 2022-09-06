package model.dao.locacao;

import java.time.LocalDateTime;
import java.util.List;

import model.entities.locacao.Locacao;

public interface LocacaoDao {
	void criarLocacao(Locacao locacao);
	void devolverLocacao(Integer id, LocalDateTime dataDevolucao);
	List<Locacao> listarTodasLocacoes();
	List<Locacao> listarTodasLocacoesPorCliente(Integer id_cliente);
	void excluirLocacao(Integer id);
}

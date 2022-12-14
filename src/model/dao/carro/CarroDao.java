package model.dao.carro;

import java.util.List;

import model.entities.carro.Carro;

public interface CarroDao {
	void criarCarro(Carro carro);
	public Carro pegarCarro(Integer id);
	List<Carro> listarTodosCarros();
	List<Carro> listarCarrosPorCategoria(Integer id_categoria);
	void editarCarro(Integer id, Carro carro);
	void excluirCarro(Integer id);
}

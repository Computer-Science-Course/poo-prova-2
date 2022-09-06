package model.dao.carro;

import java.util.List;

import model.entities.carro.Carro;

public interface CarroDao {
	void criarCarro(Carro carro);
	List<Carro> listarTodosCarros();
	List<Carro> listarCarrosPorCategoria(Integer id_categoria);
	void editarCarro(Integer id);
	void excluirCarro(Integer id);
}

package model.dao.carro;

import java.util.List;

import model.entities.carro.Carro;
import model.entities.categoria.Categoria;

public interface CarroDao {
	void criarCarro(Carro carro);
	List<Carro> listarTodosCarros();
	List<Carro> listarCarrosPorCategoria(Categoria categoria);
	void editarCarro(Integer id);
	void excluirCarro(Integer id);
}

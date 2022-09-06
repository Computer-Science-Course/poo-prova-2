package model.dao.categoria;

import java.util.List;

import model.entities.categoria.Categoria;

public interface CategoriaDao {
	void criarCategoria(Categoria categoria);
	List<Categoria> listarTodasCategorias();
	void editarCategoria(Integer id);
	void excluirCategoria(Integer id);
}

package model.dao.cliente;

import java.util.List;

import model.entities.cliente.Telefone;

public interface TelefoneDao {
	List<Telefone> listarTodosTelefones(Integer id_cliente);
}

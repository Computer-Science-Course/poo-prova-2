package model.dao.cliente;

import java.util.List;

import model.entities.cliente.Cliente;


public interface ClienteDao {
	void criarCliente(Cliente cliente);
	List<Cliente> listarTodosClientes();
	void editarCliente(Integer id);
	void excluirCliente(Integer id);
}
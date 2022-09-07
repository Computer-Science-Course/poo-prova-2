package model.dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.cliente.Cliente;
import model.entities.cliente.Telefone;
import model.service.DbException;

public class ClienteDaoJDBC implements ClienteDao{
	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void criarCliente(Cliente cliente) {
		PreparedStatement statement = null;
		
		try {
			String query = "INSERT INTO cliente " +
					"(nome, cpf, email) " +
					"VALUES " +
					"(?, ?, ?)";
			
			statement = conn.prepareStatement(
				query, 
				Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
			statement.setString(3, cliente.getEmail());

			int rowsAffected = statement.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet result = statement.getGeneratedKeys();
				if (result.next()) {
					Integer id = result.getInt(1);
					for(Telefone telefone: cliente.getTelefones()) {						
						statement = null;
						query = "INSERT INTO telefone " +
								"(numero, id_cliente) " +
								"VALUES " +
								"(?, ?)";
						statement = conn.prepareStatement(
								query, 
								Statement.RETURN_GENERATED_KEYS);
						
						statement.setString(1, telefone.getNumero());
						statement.setInt(2, id);
						
						statement.executeUpdate();
					}
				}
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma linha foi afetada!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			String query = "SELECT * FROM cliente ";
			
			Statement statement = conn.createStatement();
;
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Integer id = result.getInt("id");
				TelefoneDaoJDBC telefoneDao = new TelefoneDaoJDBC(conn);
				List<Telefone> telefones = telefoneDao.listarTodosTelefones(id);
				
				Cliente newClient = new Cliente(
						result.getString("nome"),
						result.getString("cpf"),
						result.getString("email"),
						null
				);
				for(Telefone telefone: telefones) {
					newClient.addTelefone(telefone);
				}	
				newClient.setId(id);	
				clientes.add(newClient);
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return clientes;
	}

	@Override
	public void editarCliente(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirCliente(Integer id) {
		// TODO Auto-generated method stub
		
	}
}

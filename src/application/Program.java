package application;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.carro.CarroDaoJDBC;
import model.dao.categoria.CategoriaDaoJDBC;
import model.dao.cliente.ClienteDaoJDBC;
import model.entities.carro.Carro;
import model.entities.categoria.Categoria;
import model.entities.cliente.Cliente;
import model.entities.cliente.Telefone;
import model.enums.Cor;
import model.service.DataBase;
import views.UI.Menu;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Integer option = 0;
		
		System.out.println("Estabelecendo conexão com o banco de dados...");
		Connection conn = DataBase.getConnection();
		System.out.println("Conectado!");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			while(option != 5) {
				Menu.principal.showMenu();
				option = scanner.nextInt();
				switch(option) {
					// Categoria
					case 1:
						while(option != 5) {
							Menu.categoria.showMenu();
							option = scanner.nextInt();
							switch(option) {
								case 1:
									// Cadastrar nova categoria
									break;
								case 2:
									// Listar categorias
									break;
								case 3:
									// Editar categoria
									break;
								case 4:
									// Excluir categoria
									break;
								case 5:
									// Voltar para o menu anterior
									break;
								default:
									System.out.println("[OPÇÃO INVÁLIDA]");
									
							}
						}
						// Reseta opção pra não sair do programa
						option = 0;
						break;
					// Carro
					case 2:
						while(option != 6) {
							Menu.carro.showMenu();
							option = scanner.nextInt();
							CarroDaoJDBC carroDao = new CarroDaoJDBC(conn);
							List<Carro> carros;
							CategoriaDaoJDBC categoriaDao = new CategoriaDaoJDBC(conn);
							switch(option) {
							case 1:
								// Cadastrar novo carro
								scanner = new Scanner(System.in);
								System.out.print("Modelo: ");
								String modelo = scanner.nextLine();
								
								System.out.print("Placa: ");
								String placa = scanner.nextLine();
								
								System.out.print("cor: ");
								Cor cor = Cor.valueOf(scanner.nextLine().toUpperCase());
								
								System.out.print("Ano: ");
								Integer ano = scanner.nextInt();
								
								scanner.nextLine();
								System.out.print("Data de aquisição: ");
								LocalDate dataAquisicao = LocalDate.parse(scanner.nextLine(), formatter);
								
								System.out.print("Categoria: ");
								Categoria categoria = categoriaDao.pegarCategoria(scanner.nextInt());
								
								carroDao.criarCarro(new Carro(
										modelo, placa, cor, ano, dataAquisicao, categoria
								));
								break;
							case 2:
								// Listar carros
								carros = carroDao.listarTodosCarros();
								for(Carro carro: carros) {
									System.out.println(carro);
								}
								break;
							case 3:
								// Listar carros por categoria
								System.out.print("Categoria: ");
								Integer id_categoria = scanner.nextInt();
								carros = carroDao.listarCarrosPorCategoria(id_categoria);
								for(Carro carro: carros) {
									System.out.println(carro);
								}
								break;
							case 4:
								// Editar carro
								scanner = new Scanner(System.in);
								System.out.println("Id do carro:");
								Integer id_editCarro = scanner.nextInt();
								
								scanner.nextLine();
								System.out.print("Modelo: ");
								String editModelo = scanner.nextLine();
								
								System.out.print("Placa: ");
								String editPlaca = scanner.nextLine();
								
								System.out.print("cor: ");
								Cor editCor = Cor.valueOf(scanner.nextLine().toUpperCase());
								
								System.out.print("Ano: ");
								Integer editAno = scanner.nextInt();
								
								scanner.nextLine();
								System.out.print("Data de aquisição: ");
								LocalDate editDataAquisicao = LocalDate.parse(scanner.nextLine(), formatter);
								
								System.out.print("Categoria: ");
								Categoria editCategoria = categoriaDao.pegarCategoria(scanner.nextInt());
								
								carroDao.editarCarro(id_editCarro, new Carro(
										editModelo, editPlaca, editCor, editAno, editDataAquisicao, editCategoria
								));
								break;
							case 5:
								// Excluir carro
								scanner = new Scanner(System.in);
								System.out.print("Id do carro: ");
								Integer id_excluirCarro = scanner.nextInt();
								carroDao.excluirCarro(id_excluirCarro);
								break;
							case 6:
								// Voltar para o menu anterior
								break;
							default:
								System.out.println("[OPÇÃO INVÁLIDA]");
								
							}
						}
						// Reseta opção pra não sair do programa
						option = 0;
						break;
					// Cliente
					case 3:
						while(option != 5) {
							Menu.cliente.showMenu();
							option = scanner.nextInt();
							ClienteDaoJDBC clienteDao = new ClienteDaoJDBC(conn);
							switch(option) {
								case 1:
									// Cadastrar novo cliente
									scanner = new Scanner(System.in);
									System.out.print("Nome: ");
									String cliente_nome = scanner.nextLine();
									
									System.out.print("CPF: ");
									String cliente_cpf = scanner.nextLine();
									
									System.out.print("Email: ");
									String cliente_email = scanner.nextLine();
									
									System.out.print("Telefone: ");
									Telefone cliente_tel = new Telefone(scanner.nextLine());
									
									clienteDao.criarCliente(new Cliente(
											cliente_nome, cliente_cpf, cliente_email, cliente_tel
									));
									
									break;
								case 2:
									// Listar clientes
									List<Cliente> clientes = clienteDao.listarTodosClientes();
									for(Cliente cliente: clientes) {
										System.out.println(cliente);
									}
									break;
								case 3:
									// Editar cliente
									break;
								case 4:
									// Excluir cliente
									
									break;
								case 5:
									// Voltar para o menu anterior
									break;
								default:
									System.out.println("[OPÇÃO INVÁLIDA]");
									
							}
						}
						// Reseta opção pra não sair do programa
						option = 0;
						break;
					// Locação
					case 4:
						while(option != 6) {
							Menu.locacao.showMenu();
							option = scanner.nextInt();
							switch(option) {
							case 1:
								// Cadastrar nova locação
								break;
							case 2:
								// Devolver locação
								break;
							case 3:
								// Listar locações
								break;
							case 4:
								// Listar locações por clientes
								break;
							case 5:
								// Excluir locação
								break;
							case 6:
								// Voltar para o menu anterior
								break;
							default:
								System.out.println("[OPÇÃO INVÁLIDA]");
								
							}
						}
						// Reseta opção pra não sair do programa
						option = 0;
						break;
						
					case 5:
						System.out.println("Saindo do programa...");
						break;
						
					default:
						System.out.println("[OPÇÃO INVÁLIDA]");
						
				}
			}
			
		}catch (RuntimeException error) {
			System.out.println(error);
		}finally {
			scanner.close();
			System.out.println("Desconectando do banco de dados...");
			DataBase.closeConnection();
			System.out.println("Desconectado!");
		}
		

	}
}
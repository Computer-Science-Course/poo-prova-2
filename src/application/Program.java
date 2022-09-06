package application;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.carro.CarroDaoJDBC;
import model.dao.categoria.CategoriaDaoJDBC;
import model.entities.carro.Carro;
import model.entities.categoria.Categoria;
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
								
								scanner = new Scanner(System.in);
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
								List<Carro> carros = carroDao.listarTodosCarros();
								for(Carro carro: carros) {
									System.out.println(carro);
								}
								break;
							case 3:
								// Listar carros por categoria
								break;
							case 4:
								// Editar carro
								break;
							case 5:
								// Excluir carro
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
							switch(option) {
								case 1:
									// Cadastrar novo cliente
									break;
								case 2:
									// Listar clientes
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
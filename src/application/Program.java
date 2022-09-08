package application;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.carro.CarroDaoJDBC;
import model.dao.categoria.CategoriaDaoJDBC;
import model.dao.cliente.ClienteDaoJDBC;
import model.dao.locacao.LocacaoDaoJDBC;
import model.entities.carro.Carro;
import model.entities.categoria.Categoria;
import model.entities.cliente.Cliente;
import model.entities.cliente.Telefone;
import model.entities.locacao.Locacao;
import model.entities.locacao.LocacaoDiaria;
import model.entities.locacao.LocacaoLongoPeriodo;
import model.enums.Cor;
import model.service.DataBase;
import model.service.locacao.LocacaoService;
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
		DateTimeFormatter formatterWithHour = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
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
							CategoriaDaoJDBC categoriaDaoJDBC = new CategoriaDaoJDBC(conn);
							switch(option) {
								case 1:
									// Cadastrar nova categoria
									scanner = new Scanner(System.in);
									System.out.print("Descrição: ");
									String descricao = scanner.nextLine();
									
									System.out.print("Preço por diária: R$");
									Double preco_diaria = scanner.nextDouble();
									
									categoriaDaoJDBC.criarCategoria(new Categoria(
											descricao, preco_diaria
									));
									break;
								case 2:
									// Listar categorias
									List<Categoria> categorias = categoriaDaoJDBC.listarTodasCategorias();
									for(Categoria categoria: categorias) {
										System.out.println(categoria);
									}
									break;
								case 3:
									// Editar categoria
									scanner = new Scanner(System.in);
									System.out.println("Id da categoria:");
									Integer id_editCategoria = scanner.nextInt();
									
									scanner.nextLine();
									System.out.print("Descrição: ");
									String editDescricao = scanner.nextLine();
									
									System.out.print("Preço por diária: R$");
									Double editDPeco_diaria = scanner.nextDouble();
									
									categoriaDaoJDBC.editarCategoria(new Categoria(
											editDescricao, editDPeco_diaria
									), id_editCategoria);
									break;
								case 4:
									// Excluir categoria
									scanner = new Scanner(System.in);
									System.out.println("Id da categoria:");
									Integer id_deleteCategoria = scanner.nextInt();
									
									categoriaDaoJDBC.excluirCategoria(id_deleteCategoria);
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
								System.out.print("Data de aquisição (dd/MM/yyyy): ");
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
									scanner = new Scanner(System.in);
									System.out.print("Id: ");
									Integer id_edit_cliente = scanner.nextInt();
									
									scanner.nextLine();
									System.out.print("Nome: ");
									String edit_cliente_nome = scanner.nextLine();
									
									System.out.print("CPF: ");
									String edit_cliente_cpf = scanner.nextLine();
									
									System.out.print("Email: ");
									String edit_cliente_email = scanner.nextLine();
									
									clienteDao.editarCliente(new Cliente(
											edit_cliente_nome, edit_cliente_cpf, edit_cliente_cpf, null
									), id_edit_cliente);
									
									break;
								case 4:
									// Excluir cliente
									scanner = new Scanner(System.in);
									System.out.print("Id: ");
									Integer id_delete_cliente = scanner.nextInt();
									clienteDao.excluirCliente(id_delete_cliente);
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
							List<Locacao> locacoes;
							LocacaoDaoJDBC locacaoDao = new LocacaoDaoJDBC(conn);
							switch(option) {
							case 1:
								// Cadastrar nova locação
								// LocacaoLongoPeriodo(3, LocalDateTime.now(), LocalDateTime.now().plusDays(10), 10.0)
								scanner.nextLine();
								System.out.print("Id do cliente: ");
								Integer id_cliente = scanner.nextInt();
								
								System.out.print("Id do carro: ");
								Integer id_carro = scanner.nextInt();
								
								scanner.nextLine();
								System.out.print("Data retirada (dd/MM/yyyy HH:mm): ");
								LocalDateTime dataRetirada = LocalDateTime.parse(scanner.nextLine(), formatterWithHour);
								
								System.out.print("Dias previstos pra devolução: ");
								Integer dias_previstos = scanner.nextInt();
								
								if(dias_previstos > 10) {									
									System.out.print("Porcentagem do desconto: ");
									Double desconto = (double) scanner.nextInt() / 100;
									
									locacaoDao.criarLocacaoLongoPeriodo(new LocacaoLongoPeriodo(
											dataRetirada, null, desconto
									), id_cliente, id_carro);
								}else {
									locacaoDao.criarLocacaoDiaria(new LocacaoDiaria(
											dataRetirada, null,	dias_previstos
									), id_cliente, id_carro);
								}
								
								break;
							case 2:
								// Devolver locação
								scanner = new Scanner(System.in);
								System.out.print("Id da locacao: ");
								Integer id_returnLocacao = scanner.nextInt();
								
								scanner.nextLine();
								System.out.print("Data devolucao (dd/MM/yyyy HH:mm): ");
								LocalDateTime dataDevolucao = LocalDateTime.parse(scanner.nextLine(), formatterWithHour);
								
								locacaoDao.devolverLocacao(id_returnLocacao, dataDevolucao);
								Locacao locacaoDevolvida = locacaoDao.pegarLocacao(id_returnLocacao);
								
								LocacaoService locacaoService = new LocacaoService();
								
								Double valorLocacao = null;
								if(locacaoDevolvida instanceof LocacaoDiaria) {	
									valorLocacao = locacaoService.valorLocacaoDiaria((LocacaoDiaria) locacaoDevolvida);
								}else if((locacaoDevolvida instanceof LocacaoLongoPeriodo)) {
									valorLocacao = locacaoService.valorLocacaoLongoPeriodo((LocacaoLongoPeriodo) locacaoDevolvida);									
								}
								System.out.println("\nTempo da locação: ");
								System.out.printf("Dias: %d, Horas: %d, Minutos:%d\n", locacaoService.getDays(), locacaoService.getHours(), locacaoService.getMinutes());
								System.out.println(locacaoDevolvida);
								System.out.printf("Valor final da locação: R$%.2f\n", valorLocacao);
								break;
							case 3:
								// Listar locações
								locacoes = locacaoDao.listarTodasLocacoes();
								for(Locacao locacao: locacoes) {
									System.out.println(locacao);
								}
								break;
							case 4:
								// Listar locações por clientes
								scanner = new Scanner(System.in);
								System.out.print("Id do cliente: ");
								Integer id_cliente_locacao = scanner.nextInt();
								locacoes = locacaoDao.listarTodasLocacoesPorCliente(id_cliente_locacao);
								for(Locacao locacao: locacoes) {
									System.out.println(locacao);
								}
								break;
							case 5:
								// Excluir locação
								scanner = new Scanner(System.in);
								System.out.print("Id: ");
								Integer id_deleteLocacao = scanner.nextInt();
								locacaoDao.excluirLocacao(id_deleteLocacao);
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
package com.exemplo.hotel.roles;

import java.util.Scanner;

import com.exemplo.hotel.model.Quarto;
import com.exemplo.hotel.model.Reserva;

public class Gestor {
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu Gestor ===");
            System.out.println("1. Gerir Quartos");
            System.out.println("2. Gerir Reservas");
            System.out.println("3. Gerir Manutenção");
            System.out.println("4. Consultar Histórico de Reservas");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerirQuartos(scanner);
                    break;
                case 2:
                    gerirReservas(scanner);
                    break;
                case 3:
                    gerirManutencao(scanner);
                    break;
                case 4:
                    consultarHistoricoReservas(scanner);
                    break;
                case 5:
                    System.out.println("Voltou para o menu principal.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void gerirQuartos(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gerenciamento de Quartos ---");
            System.out.println("1. Listar Quartos");
            System.out.println("2. Adicionar Quarto");
            System.out.println("3. Editar Quarto");
            System.out.println("4. Remover Quarto");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Quarto.listarQuartos().forEach(System.out::println);
                    break;
                case 2:
                    adicionarQuarto(scanner);
                    break;
                case 3:
                    editarQuarto(scanner);
                    break;
                case 4:
                    removerQuarto(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarQuarto(Scanner scanner) {
        System.out.print("Capacidade do quarto: ");
        int capacidade = scanner.nextInt();
        System.out.print("Vista: ");
        String vista = scanner.next();
        System.out.print("Tem cozinha? (true/false): ");
        boolean temCozinha = scanner.nextBoolean();
        System.out.print("Número de casas de banho: ");
        int casasDeBanho = scanner.nextInt();
        System.out.print("Tem varanda? (true/false): ");
        boolean temVaranda = scanner.nextBoolean();

        Quarto novoQuarto = Quarto.adicionarQuarto(capacidade, vista, temCozinha, casasDeBanho, temVaranda);
        System.out.println("Quarto adicionado com sucesso: " + novoQuarto);
    }

    private static void editarQuarto(Scanner scanner) {
        System.out.print("ID do Quarto a editar: ");
        int id = scanner.nextInt();
        Quarto quarto = Quarto.encontrarQuarto(id);

        if (quarto != null) {
            System.out.print("Nova capacidade: ");
            int capacidade = scanner.nextInt();
            System.out.print("Nova vista : ");
            String vista = scanner.next();
            System.out.print("Tem cozinha?: ");
            boolean temCozinha = scanner.nextBoolean();
            System.out.print("Número de casas de banho: ");
            int casasDeBanho = scanner.nextInt();
            System.out.print("Tem varanda? (true/false): ");
            boolean temVaranda = scanner.nextBoolean();

            quarto.setCapacidade(capacidade);
            quarto.setVista(vista);
            quarto.setTemCozinha(temCozinha);
            quarto.setCasasDeBanho(casasDeBanho);
            quarto.setTemVaranda(temVaranda);

            System.out.println("Quarto atualizado com sucesso: " + quarto);
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    private static void removerQuarto(Scanner scanner) {
        System.out.print("ID do Quarto a remover: ");
        int id = scanner.nextInt();
        boolean removido = Quarto.removerQuarto(id);

        if (removido) {
            System.out.println("Quarto removido com sucesso.");
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    private static void gerirReservas(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gerenciamento de Reservas ---");
            System.out.println("1. Listar Reservas");
            System.out.println("2. Fazer Reserva");
            System.out.println("3. Confirmar Reserva");
            System.out.println("4. Cancelar Reserva");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Reserva.listarReservas().forEach(System.out::println);
                    break;
                case 2:
                    fazerReserva(scanner);
                    break;
                case 3:
                    confirmarReserva(scanner);
                    break;
                case 4:
                    cancelarReserva(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void fazerReserva(Scanner scanner) {
        System.out.print("ID do Quarto: ");
        int idQuarto = scanner.nextInt();
        System.out.print("Nome do Cliente: ");
        scanner.nextLine(); 
        String nomeCliente = scanner.nextLine();
        System.out.print("Data de início (dd/MM/yyyy): ");
        String dataInicio = scanner.next();
        System.out.print("Data de fim (dd/MM/yyyy): ");
        String dataFim = scanner.next();

        Reserva reserva = Reserva.criarReserva(idQuarto, nomeCliente, dataInicio, dataFim);
        if (reserva != null) {
        System.out.println("Reserva criada com sucesso!");
        } else {
        System.out.println("Falha ao criar reserva. Verifique os dados e tente novamente.");
}
    }

    private static void confirmarReserva(Scanner scanner) {
        System.out.print("ID da Reserva para confirmar: ");
        int idReserva = scanner.nextInt();
        Reserva.confirmarReserva(idReserva);
        System.out.println("Reserva confirmada.");
    }

    private static void cancelarReserva(Scanner scanner) {
        System.out.print("ID da Reserva para cancelar: ");
        int idReserva = scanner.nextInt();
        boolean cancelada = Reserva.cancelarReserva(idReserva);

        if (cancelada) {
            System.out.println("Reserva cancelada com sucesso.");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    private static void gerirManutencao(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gerenciamento de Manutenção ---");
            System.out.println("1. Consultar Quartos em Manutenção");
            System.out.println("2. Registrar Manutenção");
            System.out.println("3. Concluir Manutenção");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Quarto.listarQuartos().stream()
                            .filter(Quarto::isEmManutencao)
                            .forEach(System.out::println);
                    break;
                case 2:
                    registrarManutencao(scanner);
                    break;
                case 3:
                    concluirManutencao(scanner);
                    break;
                case 4:
                     System.out.println("Voltou para o menu anterior.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void consultarHistoricoReservas(Scanner scanner) {
        System.out.print("Digite o nome do hóspede para consultar o histórico: ");
        scanner.nextLine(); 
        String nomeHospede = scanner.nextLine();

        var historico = Reserva.listarHistoricoReservas(nomeHospede);
        if (historico.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o hóspede: " + nomeHospede);
        } else {
            System.out.println("\n--- Histórico de Reservas de " + nomeHospede + " ---");
            historico.forEach(System.out::println);
        }
    }

    private static void registrarManutencao(Scanner scanner) {
        System.out.print("ID do Quarto para registar manutenção: ");
        int idQuarto = scanner.nextInt();
        Quarto quarto = Quarto.encontrarQuarto(idQuarto);

        if (quarto != null) {
            quarto.registrarManutencao();
            System.out.println("Manutenção registada para o quarto " + idQuarto);
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    private static void concluirManutencao(Scanner scanner) {
        System.out.print("ID do Quarto para concluir manutenção: ");
        int idQuarto = scanner.nextInt();
        Quarto quarto = Quarto.encontrarQuarto(idQuarto);
 
        
        if (quarto != null) {
            quarto.concluirManutencao();
            System.out.println("Manutenção concluída para o quarto " + idQuarto);
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }
}

package com.exemplo.hotel.roles;

import java.util.Scanner;

import com.exemplo.hotel.model.Quarto;
import com.exemplo.hotel.model.Reserva;

public class Funcionario {
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("1. Gerir Reservas");
            System.out.println("2. Gerir Manutenção");
            System.out.println("3. Consultar Histórico de Reservas");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerirReservas(scanner);
                    break;
                case 2:
                    gerirManutencao(scanner);
                    break;
                case 3:
                    consultarHistoricoReservas(scanner);
                    break;
                case 4:
                    System.out.println("Voltou para o menu principal.");
                    return; 
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
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
                    System.out.println("\n--- Lista de Reservas ---");
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
                    System.out.println("Voltou para o menu anterior.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
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
                    System.out.println("\n--- Quartos em Manutenção ---");
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
                    System.out.println("Opção inválida. Tente novamente.");
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

    private static void fazerReserva(Scanner scanner) {
        System.out.print("ID do Quarto: ");
        int idQuarto = scanner.nextInt();
        System.out.print("Nome do Cliente: ");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        System.out.print("Data de Início (dd/MM/yyyy): ");
        String dataInicio = scanner.next();
        System.out.print("Data de Fim (dd/MM/yyyy): ");
        String dataFim = scanner.next();

        Reserva.criarReserva(idQuarto, nomeCliente, dataInicio, dataFim);
        System.out.println("Reserva criada com sucesso!");
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
        System.out.println(cancelada ? "Reserva cancelada com sucesso." : "Reserva não encontrada.");
    }

    private static void registrarManutencao(Scanner scanner) {
        System.out.print("ID do Quarto para registrar manutenção: ");
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

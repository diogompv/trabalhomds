package com.exemplo.hotel.roles;

import java.util.Scanner;

import com.exemplo.hotel.model.Quarto;
import com.exemplo.hotel.model.Reserva;

public class Hospede {
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu Hóspede ---");
            System.out.println("1. Listar Quartos Disponíveis");
            System.out.println("2. Ver Meu Histórico");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarQuartosDisponiveis();
                    break;
                case 2:
                    verMeuHistorico(scanner);
                    break;
                case 4:
                    System.out.println("Voltou ao menu principal.");
                    return; 
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void listarQuartosDisponiveis() {
        System.out.println("\n--- Quartos Disponíveis ---");
        Quarto.listarQuartos().stream()
                .filter(quarto -> !quarto.isEmManutencao())
                .forEach(System.out::println);
    }

    

    private static void verMeuHistorico(Scanner scanner) {
        System.out.print("Digite o seu nome para ver seu histórico: ");
        scanner.nextLine();
        String nomeHospede = scanner.nextLine();

        System.out.println("\n--- Histórico de Reservas ---");
        var historico = Reserva.listarHistoricoReservas(nomeHospede);
        if (historico.isEmpty()) {
            System.out.println("Não possui histórico de reservas.");
        } else {
            historico.forEach(System.out::println);
        }
    }
}

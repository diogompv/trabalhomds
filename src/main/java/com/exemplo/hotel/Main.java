package com.exemplo.hotel;

import java.util.Scanner;

import com.exemplo.hotel.roles.Funcionario;
import com.exemplo.hotel.roles.Gestor;
import com.exemplo.hotel.roles.Hospede;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Gerenciamento de Hotel ---");
            System.out.println("1. Gestor");
            System.out.println("2. Funcionário");
            System.out.println("3. Hóspede");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Gestor.menu(scanner);
                    break;
                case 2:
                    Funcionario.menu(scanner);
                    break;
                case 3:
                    Hospede.menu(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

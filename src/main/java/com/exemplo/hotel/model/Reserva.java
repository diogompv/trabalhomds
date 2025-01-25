package com.exemplo.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int id;
    private int numeroQuarto;
    private String nomeHospede;
    private String dataInicio;
    private String dataFim;
    private boolean confirmada;

    private static int proximoId = 1;
    private static List<Reserva> reservas = new ArrayList<>();

    public Reserva(int numeroQuarto, String nomeHospede, String dataInicio, String dataFim) {
        this.id = proximoId++;
        this.numeroQuarto = numeroQuarto;
        this.nomeHospede = nomeHospede;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.confirmada = false;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

   
    public static Reserva criarReserva(int numeroQuarto, String nomeHospede, String dataInicio, String dataFim) {
        if (Quarto.encontrarQuarto(numeroQuarto) == null) {
            System.out.println("Erro: O quarto com ID " + numeroQuarto + " não existe.");
            return null;
        }
        else {
        Reserva reserva = new Reserva(numeroQuarto, nomeHospede, dataInicio, dataFim);
        reservas.add(reserva);
            return reserva;}
    }

    public static void resetReservas() {
        reservas.clear();
        proximoId = 1;
    }

    public static List<Reserva> listarReservas() {
        return reservas;
    }

    public static boolean cancelarReserva(int id) {
        return reservas.removeIf(r -> r.id == id);
    }

    public static void confirmarReserva(int id) {
        reservas.stream().filter(r -> r.id == id).findFirst().ifPresent(r -> r.setConfirmada(true));
    }

    public static List<Reserva> listarHistoricoReservas(String nomeHospede) {
        List<Reserva> historico = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeHospede)) {
                historico.add(reserva);
            }
        }
        return historico;
    }

    @Override
    public String toString() { 
        
        return "Reserva{" +
                "id=" + id +
                ", numeroQuarto=" + numeroQuarto +
                ", nomeHospede='" + nomeHospede + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", confirmada=" + confirmada +
                '}';
    }
}

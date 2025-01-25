package com.exemplo.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int id;
    private int capacidade;
    private String vista;
    private boolean temCozinha;
    private int casasDeBanho;
    private boolean temVaranda;
    private boolean emManutencao;

    private static int proximoId = 1;
    private static List<Quarto> quartos = new ArrayList<>();

    public Quarto(int capacidade, String vista, boolean temCozinha, int casasDeBanho, boolean temVaranda) {
        this.id = proximoId++;
        this.capacidade = capacidade;
        this.vista = vista;
        this.temCozinha = temCozinha;
        this.casasDeBanho = casasDeBanho;
        this.temVaranda = temVaranda;
        this.emManutencao = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getVista() {
        return vista;
    }

    public boolean isTemCozinha() {
        return temCozinha;
    }

    public int getCasasDeBanho() {
        return casasDeBanho;
    }

    public boolean isTemVaranda() {
        return temVaranda;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

   
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public void setTemCozinha(boolean temCozinha) {
        this.temCozinha = temCozinha;
    }

    public void setCasasDeBanho(int casasDeBanho) {
        this.casasDeBanho = casasDeBanho;
    }

    public void setTemVaranda(boolean temVaranda) {
        this.temVaranda = temVaranda;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }

    
    public static Quarto adicionarQuarto(int capacidade, String vista, boolean temCozinha, int casasDeBanho, boolean temVaranda) {
        Quarto quarto = new Quarto(capacidade, vista, temCozinha, casasDeBanho, temVaranda);
        quartos.add(quarto);
        return quarto;
    }
    public static void resetQuartos() {
        quartos.clear();
        proximoId = 1;
    }

    public static List<Quarto> listarQuartos() {
        return quartos;
    }

    public static Quarto encontrarQuarto(int id) {
        return quartos.stream().filter(q -> q.id == id).findFirst().orElse(null);
    }

    public static boolean removerQuarto(int id) {
        return quartos.removeIf(q -> q.id == id);
    }

    public void registrarManutencao() {
        this.emManutencao = true;
    }

    public void concluirManutencao() {
        this.emManutencao = false;
    }

    @Override
    public String toString() {
        return "Quarto{" +
               "id=" + id +
               ", Capacidade=" + capacidade +
               ", Vista='" + vista + '\'' +
               ", Cozinha=" + temCozinha +
               ", Casas De Banho=" + casasDeBanho +
               ", Varanda=" + temVaranda +
               ", Manutencao=" + emManutencao +
               '}';
    }
}

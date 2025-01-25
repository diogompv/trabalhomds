package com.exemplo.hotel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exemplo.hotel.model.Quarto;
import com.exemplo.hotel.model.Reserva;

class HistoricoTest {

    @BeforeEach
    void setup() {
        
        Reserva.resetReservas();
        Quarto.resetQuartos();
    }

    @Test
    void testHistoricoReservasExistente() {
        
        Quarto.adicionarQuarto(2, "mar", true, 1, false);
        Quarto.adicionarQuarto(3, "serra", false, 1, true);

        
        Reserva.criarReserva(1, "gabriel", "01/01/2025", "05/01/2025");
        Reserva.criarReserva(2, "diogo", "02/01/2025", "06/01/2025");
        Reserva.criarReserva(1, "gabriel", "10/01/2025", "15/01/2025");

        
        List<Reserva> historico = Reserva.listarHistoricoReservas("gabriel");

       
        assertNotNull(historico);
        assertEquals(2, historico.size());
        assertEquals("gabriel", historico.get(0).getNomeHospede());
        assertEquals("gabriel", historico.get(1).getNomeHospede());
    }

    @Test
    void testHistoricoReservasInexistente() {
        // Adiciona um quarto válido
        Quarto.adicionarQuarto(2, "mar", true, 1, false);

        // Adiciona uma reserva ao sistema
        Reserva.criarReserva(1, "diogo", "02/01/2025", "06/01/2025");

        // Recupera o histórico de reservas de um hóspede sem reservas
        List<Reserva> historico = Reserva.listarHistoricoReservas("gabriel");

        // Verifica se o histórico está vazio
        assertNotNull(historico);
        assertTrue(historico.isEmpty());
    }

    @Test
    void testReservaRemovidaNaoApareceNoHistorico() {
        // Adiciona um quarto válido
        Quarto.adicionarQuarto(1, "serra", false, 1, true);

        // Cria uma reserva
        Reserva reserva = Reserva.criarReserva(1, "gabriel", "01/01/2025", "05/01/2025");

        // Remove a reserva
        Reserva.cancelarReserva(reserva.getId());

        // Recupera o histórico de reservas do João Silva
        List<Reserva> historico = Reserva.listarHistoricoReservas("gabriel");

        // Verifica que o histórico está vazio
        assertNotNull(historico);
        assertTrue(historico.isEmpty());
    }


}

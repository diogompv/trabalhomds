package com.exemplo.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exemplo.hotel.model.Quarto;
import com.exemplo.hotel.model.Reserva;

class ReservaTest {

    @BeforeEach
    void setup() {
        Reserva.resetReservas();
        Quarto.resetQuartos();
    }

    @Test
    void testCriarReserva() throws Exception {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        String dataInicio = "01/01/2025";
        String dataFim = "05/01/2025";

        Reserva reserva = Reserva.criarReserva(quarto.getId(), "gabriel", dataInicio, dataFim);
        assertNotNull(reserva);
        assertEquals("gabriel", reserva.getNomeHospede());
    }

    @Test
    void testConfirmarReserva() throws Exception {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        String dataInicio = "01/01/2025";
        String dataFim = "05/01/2025";

        Reserva reserva = Reserva.criarReserva(quarto.getId(), "gabriel", dataInicio, dataFim);
        Reserva.confirmarReserva(reserva.getId());
        assertTrue(reserva.isConfirmada());
    }

    @Test
    void testCancelarReserva() throws Exception {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        String dataInicio = "01/01/2025";
        String dataFim = "05/01/2025";

        Reserva reserva = Reserva.criarReserva(quarto.getId(), "gabriel", dataInicio, dataFim);
        boolean cancelada = Reserva.cancelarReserva(reserva.getId());
        assertTrue(cancelada);
    }
}

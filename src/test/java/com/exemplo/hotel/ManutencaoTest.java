package com.exemplo.hotel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exemplo.hotel.model.Quarto;

class ManutencaoTest {

    @BeforeEach
    void setup() {
        Quarto.resetQuartos(); 
    }

    @Test
    void testRegistrarManutencao() {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        quarto.registrarManutencao();
        assertTrue(quarto.isEmManutencao());
    }

    @Test
    void testConcluirManutencao() {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        quarto.registrarManutencao();
        quarto.concluirManutencao();
        assertFalse(quarto.isEmManutencao());
    }
}

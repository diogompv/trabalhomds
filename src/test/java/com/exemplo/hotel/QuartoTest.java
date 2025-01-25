package com.exemplo.hotel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exemplo.hotel.model.Quarto;

class QuartoTest {

    @BeforeEach
    void setup() {
        Quarto.resetQuartos();
    }

    @Test
    void testAdicionarQuarto() {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        assertNotNull(quarto);
        assertEquals(1, Quarto.listarQuartos().size());
        assertEquals("mar", quarto.getVista());
    }

    @Test
    void testEditarQuarto() {
        
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
    
        
        quarto.setVista("serra");
        quarto.setCapacidade(4);
        quarto.setTemCozinha(false);
        quarto.setCasasDeBanho(2);
        quarto.setTemVaranda(true);
    
        
        assertEquals("serra", quarto.getVista());
        assertEquals(4, quarto.getCapacidade());
        assertFalse(quarto.isTemCozinha());
        assertEquals(2, quarto.getCasasDeBanho());
        assertTrue(quarto.isTemVaranda());
    }
    
    @Test
    void testRemoverQuarto() {
        Quarto quarto = Quarto.adicionarQuarto(2, "mar", true, 1, false);
        boolean removido = Quarto.removerQuarto(quarto.getId());
        assertTrue(removido);
        assertEquals(0, Quarto.listarQuartos().size());
    }

    @Test
    void testListarQuartos() {
        Quarto.adicionarQuarto(2, "mar", true, 1, false);
        Quarto.adicionarQuarto(3, "serra", false, 2, true);
        List<Quarto> quartos = Quarto.listarQuartos();
        assertEquals(2, quartos.size());
    }
}

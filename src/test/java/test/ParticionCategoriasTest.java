package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.CalculadoraTarifas;

class ParticionCategoriasTest {

    CalculadoraTarifas calc;

    @BeforeEach
    void init() {
        calc = new CalculadoraTarifas();
    }

    // 1) CATEGORÍA: validación de entrada (parámetros inválidos)
    @Test
    void testEntradaInvalida() {
        double r = calc.calcularTarifa(0.0, -5, false);
        assertEquals(-1.0, r);   // error por peso/distancia inválidos
    }

    // 2) CATEGORÍA: urgencia
    @Test
    void testCategoriaUrgente() {
        double r = calc.calcularTarifa(5.0, 100, true);
        assertTrue(r > CalculadoraTarifas.TARIFA_BASE);
    }

    // 3) CATEGORÍA: peso por encima del crítico (sobrecoste por peso)
    @Test
    void testCategoriaPesoCritico() {
        double r = calc.calcularTarifa(17.0, 150, false);
        assertTrue(r > CalculadoraTarifas.TARIFA_BASE);
    }

    // 4) CATEGORÍA: peso que excede el máximo permitido
    @Test
    void testCategoriaPesoExcedido() {
        double r = calc.calcularTarifa(25.0, 200, false);
        assertEquals(-2.0, r);   // error por exceso de peso
    }

    // 5) CATEGORÍA: distancia extrema
    @Test
    void testCategoriaDistanciaExtrema() {
        double r = calc.calcularTarifa(10.0, 2000, false);
        assertTrue(r > CalculadoraTarifas.TARIFA_BASE);
    }
}

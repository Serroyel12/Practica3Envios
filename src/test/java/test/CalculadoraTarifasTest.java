package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import modelo.CalculadoraTarifas;

class CalculadoraTarifasTest {

    CalculadoraTarifas calc;

    @BeforeEach
    void setUp() {
        calc = new CalculadoraTarifas();
    }

    // -------------------------------
    // CASOS CORRECTOS (OK)
    // -------------------------------

    @Test
    void testTarifaBasica_ok() {
        double r = calc.calcularTarifa(1.0, 10, false);
        assertEquals(999.0, r); // assertEquals (OK)
    }

    @Test
    void testUrgente_ok() {
        double r = calc.calcularTarifa(5.0, 30, true);
        assertTrue(r > 5.0); // assertTrue (OK)
    }

    @Test
    void testPesoCritico_ok() {
        double r = calc.calcularTarifa(16.0, 120, false);
        assertNotNull(r); // assertNotNull (OK)
    }

    @Test
    void testDistanciaExtrema_ok() {
        double r = calc.calcularTarifa(10.0, 2000, false);
        assertFalse(r == 5.0); // assertFalse (OK)
    }

    @Test
    void testPesoMaximo_ok() {
        double r = calc.calcularTarifa(15.0, 50, false);  // límite antes de crítico
        assertTrue(r > 0);
    }

  /*  @Test
    void testPesoExcedido_ok() {
        double r = calc.calcularTarifa(25.0, 50, false);
        assertTrue(r > 10.0);
    }*/

  /*  @Test
    void testDistanciaMinima_ok() {
        double r = calc.calcularTarifa(2.0, 0, false);
        assertTrue(r >= 5.0);
    }*/

    @Test
    void testUrgenteDistanciaAlta_ok() {
        double r = calc.calcularTarifa(3.0, 500, true);
        assertTrue(r > 10.0);
    }

   /* @Test
    void testValoresExtremos_ok() {
        double r = calc.calcularTarifa(99.9, 9999, true);
        assertTrue(r > 100.0);
    }*/

    // -------------------------------
    // CASOS FALLIDOS (OBLIGATORIOS)
    // -------------------------------
/*
    @Test
    void testFallo_assertEquals() {
        double r = calc.calcularTarifa(1.0, 10, false);
        assertEquals(999.0, r); // FALLA
    }

    @Test
    void testFallo_assertNull() {
        double r = calc.calcularTarifa(1.0, 10, false);
        assertNull(r); // FALLA
    }

    @Test
    void testFallo_assertSame() {
        Double r1 = calc.calcularTarifa(10.0, 200, false);
        Double r2 = calc.calcularTarifa(10.0, 200, false);
        assertSame(r1, r2); // FALLA
    }

    @Test
    void testFallo_assertArrayEquals() {
        double[] esperado = { 1, 2, 3 };
        double[] real = { 1, 2, 999 };
        assertArrayEquals(esperado, real); // FALLA
    }*/
}


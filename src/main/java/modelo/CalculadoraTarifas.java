package modelo;

public class CalculadoraTarifas {

    public static final double MAX_PESO = 20.0;
    public static final double TARIFA_BASE = 5.0;
    public static final double COSTE_URGENTE = 10.0;
    public static final double COSTE_EXTRA_PESO = 2.0;
    public static final double PESO_CRITICO = 15.0;

    /**
     * Calcula la tarifa final de envío.
     * Devuelve:
     *   > 0  → coste correcto
     *   -1   → error de parámetros (peso/distancia inválidos)
     *   -2   → error por exceso de peso
     */
    public double calcularTarifa(double pesoKg, int distanciaKm, boolean esUrgente) {
        double tarifaFinal = TARIFA_BASE;

        // NODO 1: verificación entrada
        if (pesoKg <= 0.0 || distanciaKm <= 0) {
            System.out.println("[C_LOG] ERROR: Peso o distancia invalida (NODO 1)");
            return -1.0;
        }

        // NODO 2: urgencia
        if (esUrgente) {
            tarifaFinal += COSTE_URGENTE;

            // NODO 3: urgente + distancia crítica
            if (distanciaKm > 500) {
                tarifaFinal += 5.0;
            }
        }

        // NODO 4: peso máximo
        if (pesoKg > MAX_PESO) {
            System.out.printf("[C_LOG] ERROR: Peso excede el limite de %.1f kg (NODO 4)%n", MAX_PESO);
            return -2.0;

        // NODO 5: peso crítico
        } else if (pesoKg > PESO_CRITICO) {
            tarifaFinal += COSTE_EXTRA_PESO;

            // NODO 6: peso crítico + distancia media
            if (distanciaKm > 100 && distanciaKm <= 500) {
                tarifaFinal += 3.0;
            }
        }

        // NODO 7: distancia de envío
        if (distanciaKm > 1000) {
            tarifaFinal *= 1.5;

            // NODO 8: distancia extrema + no urgente
            if (!esUrgente) {
                System.out.println("[C_LOG] ADVERTENCIA: Envio muy lejano y NO urgente (NODO 8)");
            }
        }

        // NODO 9: envío básico
        if (tarifaFinal == TARIFA_BASE) {
            System.out.println("[C_LOG] INFO: Tarifa minima aplicada, envio basico (NODO 9)");
        }

        // NODO 10: retorno final
        return tarifaFinal;
    }

    // Versión cómoda usando directamente CasoPrueba
    public double calcularTarifa(CasoPrueba caso) {
        return calcularTarifa(caso.getPeso(), caso.getDistancia(), caso.isUrgente());
    }
}

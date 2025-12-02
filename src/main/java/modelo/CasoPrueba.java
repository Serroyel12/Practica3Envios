package modelo;

public class CasoPrueba {

    private double peso;
    private int distancia;
    private boolean urgente;

    public CasoPrueba(double peso, int distancia, boolean urgente) {
        this.peso = peso;
        this.distancia = distancia;
        this.urgente = urgente;
    }

    public double getPeso() {
        return peso;
    }

    public int getDistancia() {
        return distancia;
    }

    public boolean isUrgente() {
        return urgente;
    }

    @Override
    public String toString() {
        return String.format("[P: %.1f, D: %d, U: %b]", peso, distancia, urgente);
    }
}

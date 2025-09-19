package models;

public class CuentaSimple {
    private int saldo;

    public CuentaSimple(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Sin synchronized, susceptible a condición de carrera
    public void agregarSaldo(int cantidad) {
        int temporal = saldo;
        try {
            // Pausa artificial para aumentar probabilidad de error
            Thread.sleep(10);
        } catch (InterruptedException ignored) {}
        saldo = temporal + cantidad;
    }

    public int getSaldo() {
        return saldo;
    }
}

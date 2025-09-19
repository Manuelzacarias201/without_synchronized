import models.CuentaSimple;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear la cuenta con saldo inicial de $1000
        CuentaSimple cuenta = new CuentaSimple(1000);

        // Definir las tareas de depósito
        Runnable d1 = () -> cuenta.agregarSaldo(200);
        Runnable d2 = () -> cuenta.agregarSaldo(300);
        Runnable d3 = () -> cuenta.agregarSaldo(500);

        // Crear los hilos
        Thread h1 = new Thread(d1, "Hilo-200");
        Thread h2 = new Thread(d2, "Hilo-300");
        Thread h3 = new Thread(d3, "Hilo-500");

        // Iniciar hilos
        h1.start();
        h2.start();
        h3.start();

        // Esperar que terminen
        h1.join();
        h2.join();
        h3.join();

        System.out.println("Saldo inicial: $1000");
        System.out.println("Saldo esperado: $2000");
        System.out.println("Saldo real (sin sync): $" + cuenta.getSaldo());
    }
}

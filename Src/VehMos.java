import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class VehMos {
    // Atributos de cada vehículo
    private int cantidadCombustible;
    private double consumoPorKm;
    private double tiempoDeLlegada;
    private int idClienteActual;
    String descripcion = "Vehiculo Vehmos";


    private State enEspera;
    private State comenzarViaje;
    private State enMovimiento;
    private State alertaDeCombustible;
    private State viajeFinalizado;
    private State estadoActual;

    // Constructor y métodos que comparten todos los vehículos
    public VehMos(int cantidadCombustible, double consumoPorKm) {
        this.cantidadCombustible = cantidadCombustible;
        this.consumoPorKm = consumoPorKm;
        // Inicialización de estados

        enEspera = new EnEspera(this);
        comenzarViaje = new ComenzarViaje(this);
        enMovimiento = new EnMovimiento(this);
        alertaDeCombustible = new AlertaDeCombustible(this);
        viajeFinalizado = new ViajeFinalizado(this);
        
        // Estado inicial
        estadoActual = enEspera;
    }
    
    public boolean encenderVehiculo(boolean encender) {
        if (encender) {
            System.out.println("VehMos encendido.");
            return true;
        } else {
            System.out.println("VehMos apagado.");
            return false;
        }
    }
    
    public boolean apagarVehiculo(boolean apagar) {
        if (apagar) {
            System.out.println("VehMos apagado.");
            return true;
        } else {
            System.out.println("VehMos sigue encendido.");
            return false;
        }
    }
    
    // Parte de template
    public abstract void recargarCombustible();
    public abstract double costoViaje();
    public abstract boolean clienteRequiereTerraceria();
    
    // Métodos de gestión de atributos
    public void setTiempoDeLlegada(double tiempo) {
        this.tiempoDeLlegada = tiempo;
    }
    
    public double getTiempoDeLlegada() {
        return this.tiempoDeLlegada;
    }
    
    public void setCantidadCombustible(int combustible) {
        this.cantidadCombustible = 100;
        // Si la cantidad de combustible es menor a 80, cambiar al estado de alerta
        if (this.cantidadCombustible < 10 && !(estadoActual instanceof AlertaDeCombustible)) {
            setState(alertaDeCombustible);
        }
    }
    
    public int getCantidadCombustible() {
        return this.cantidadCombustible;
    }

    public double getConsumoPorKm(){return this.consumoPorKm;}
    
    // Métodos adicionales
    public void limiteDeTuning(int numerolimite) {
        // Implementar la lógica de límite de tuning aquí
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void calcularDistancia() {
        // Implementar la lógica de cálculo de distancia aquí
    }
    
    // Getters y Setters para los estados
    public State getEnEspera() {
        return enEspera;
    }

    public State getComenzarViaje() {
        return enMovimiento;//comenzarViaje;
    }

    public State getEnMovimiento() {
        return enMovimiento;
    }

    public State getAlertaDeCombustible() {
        return alertaDeCombustible;
    }

    public State getViajeFinalizado() {
        return viajeFinalizado;
    }

    public State getState() {
        System.out.println("El estado actual del vehículo es: "+ estadoActual);
        return estadoActual;
    }

    public void setState(State estado) {
        this.estadoActual = estado;
    }

    // Método para leer la entrada del usuario
    protected String getUserInput(String prompt) {
        String answer = null;
        System.out.println(prompt);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error tratando de leer la respuesta");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para calcular cuántos kilómetros puede recorrer antes de quedarse sin combustible
    public double calcularKmRestantes() {
        return cantidadCombustible / consumoPorKm;
    }

    // Método para reducir el combustible cuando el vehículo avanza
    public void consumirCombustible(double distancia) {
        double combustibleNecesario = distancia * consumoPorKm;
        if (combustibleNecesario > cantidadCombustible) {
            System.out.println("El vehículo no tiene suficiente combustible para continuar el viaje.");
            cantidadCombustible = 0;  // El vehículo se queda sin combustible
        } else {
            cantidadCombustible -= combustibleNecesario;
            System.out.println("Combustible restante: " + cantidadCombustible + " litros/kWh");
        }
    }

    // Método para asignar un ID al cliente actual
    public void setIdClienteActual(int idCliente) {
        this.idClienteActual = idCliente;
    }

    public int getIdClienteActual() {
        return idClienteActual;
    }

    // Método para verificar el ID del cliente
    public boolean verificarIdCliente(int idCliente) {
        return this.idClienteActual == idCliente;
    }

}

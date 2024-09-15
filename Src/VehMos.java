import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La clase abstracta VehMos representa un vehículo genérico que puede tener diferentes estados
 * y comportamientos dependiendo del contexto. Esta clase implementa el patrón de diseño
 * State para gestionar las acciones que el vehículo puede realizar en diferentes momentos,
 * y también sigue el patrón Template Method para la recarga de combustible y otras acciones
 * específicas de subclases.
 *
 * Los vehículos pueden estar en varios estados como "En espera", "En movimiento",
 * "Alerta de combustible" y "Viaje finalizado". También se proporciona funcionalidad para
 * gestionar el combustible, el costo del viaje, y el estado del cliente actual.
 *
 * @author Los Hijos de Krohal
 */
public abstract class VehMos {
    // Atributos de cada vehículo
    private int cantidadCombustible;
    private double consumoPorKm;
    private double tiempoDeLlegada;
    private int idClienteActual;
    String descripcion = "Vehiculo Vehmos";

    // Estados del vehiculo
    private State enEspera;
    private State comenzarViaje;
    private State enMovimiento;
    private State alertaDeCombustible;
    private State viajeFinalizado;
    private State estadoActual;

    /**
     * Constructor para inicializar un vehículo con una cantidad de combustible
     * y un consumo por kilómetro específico.
     *
     * @param cantidadCombustible La cantidad inicial de combustible del vehículo.
     * @param consumoPorKm El consumo de combustible del vehículo por kilómetro.
     */
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

    /**
     * Método para encender el vehículo.
     *
     * @param encender Indica si el vehículo debe encenderse.
     * @return true si el vehículo se encendió, false en caso contrario.
     */
    public boolean encenderVehiculo(boolean encender) {
        if (encender) {
            System.out.println("VehMos encendido.");
            return true;
        } else {
            System.out.println("VehMos apagado.");
            return false;
        }
    }

    /**
     * Método para apagar el vehículo.
     *
     * @param apagar Indica si el vehículo debe apagarse.
     * @return true si el vehículo se apagó, false en caso contrario.
     */
    public boolean apagarVehiculo(boolean apagar) {
        if (apagar) {
            System.out.println("VehMos apagado.");
            return true;
        } else {
            System.out.println("VehMos sigue encendido.");
            return false;
        }
    }

    // Métodos abstractos que deben ser implementados por las subclases.
    public abstract void recargarCombustible();
    public abstract double costoViaje();
    public abstract boolean clienteRequiereTerraceria();

    /**
     * Establece el tiempo estimado de llegada del vehículo.
     *
     * @param tiempo El tiempo de llegada en minutos.
     */
    public void setTiempoDeLlegada(double tiempo) {
        this.tiempoDeLlegada = tiempo;
    }

    /**
     * Obtiene el tiempo estimado de llegada del vehículo.
     *
     * @return El tiempo de llegada en minutos.
     */
    public double getTiempoDeLlegada() {
        return this.tiempoDeLlegada;
    }

    /**
     * Establece la cantidad de combustible del vehículo. Si el nivel de combustible es
     * menor a un valor crítico, cambia el estado del vehículo a "Alerta de combustible".
     *
     * @param combustible La cantidad de combustible en litros o kWh.
     */
    public void setCantidadCombustible(int combustible) {
        this.cantidadCombustible = 100;
        // Si la cantidad de combustible es menor a 80, cambiar al estado de alerta
        if (this.cantidadCombustible < 10 && !(estadoActual instanceof AlertaDeCombustible)) {
            setState(alertaDeCombustible);
        }
    }

    /**
     * Obtiene la cantidad de combustible restante del vehículo.
     *
     * @return La cantidad de combustible en litros o kWh.
     */
    public int getCantidadCombustible() {
        return this.cantidadCombustible;
    }

    /**
     * Obtiene el consumo de combustible por kilómetro del vehículo.
     *
     * @return El consumo de combustible en litros o kWh por kilómetro.
     */
    public double getConsumoPorKm(){return this.consumoPorKm;}

    /**
     * Obtiene la descripción del vehículo.
     *
     * @return La descripción actual del vehículo.
     */
    public String getDescripcion() {
        return this.descripcion;
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


    /**
     * Obtiene el estado actual del vehículo.
     *
     * @return El estado actual del vehículo.
     */
    public State getState() {
        System.out.println("El estado actual del vehículo es: "+ estadoActual);
        return estadoActual;
    }

    /**
     * Establece el estado del vehículo.
     *
     * @param estado El nuevo estado del vehículo.
     */
    public void setState(State estado) {
        this.estadoActual = estado;
    }

    /**
     * Lee la entrada del usuario desde la consola.
     *
     * @param prompt El mensaje que se mostrará al usuario.
     * @return La entrada proporcionada por el usuario.
     */
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

    /**
     * Establece la descripción del vehículo.
     *
     * @param descripcion La nueva descripción del vehículo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Calcula la distancia que el vehículo puede recorrer con el combustible restante.
     *
     * @return La distancia en kilómetros que el vehículo puede recorrer.
     */
    public double calcularKmRestantes() {
        return cantidadCombustible / consumoPorKm;
    }

    /**
     * Reduce la cantidad de combustible del vehículo en función de la distancia recorrida.
     *
     * @param distancia La distancia que el vehículo ha recorrido en kilómetros.
     */
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

    /**
     * Asigna un ID del cliente actual al vehiculo que usará.
     *
     * @param idCliente El ID del cliente que está usando el vehículo.
     */
    public void setIdClienteActual(int idCliente) {
        this.idClienteActual = idCliente;
    }

    /**
     * Obtiene el ID del cliente actual.
     *
     * @return El ID del cliente actual.
     */
    public int getIdClienteActual() {
        return idClienteActual;
    }

    /**
     * Verifica si el ID proporcionado coincide con el ID del cliente actual.
     *
     * @param idCliente El ID del cliente a verificar.
     * @return true si el ID coincide, false en caso contrario.
     */
    public boolean verificarIdCliente(int idCliente) {
        return this.idClienteActual == idCliente;
    }

}

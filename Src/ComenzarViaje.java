/**
 * La clase ComenzarViaje implementa el estado "Comenzar Viaje" dentro del patrón de diseño **State**.
 * Representa el estado en el que el vehículo está listo para comenzar el viaje después de la verificación del ID.
 * En este estado, el vehículo está en la transición entre "En Espera" y "En Movimiento", y varios comportamientos
 * como recargar combustible o finalizar el viaje están restringidos.
 *
 * Esta clase es parte de un sistema de gestión de estados para vehículos, donde el comportamiento de cada acción
 * varía según el estado actual del vehículo.
 *
 * @author Los Hijos de Korhal
 */
public class ComenzarViaje implements State {
    private VehMos vehmos;

    /**
     * Constructor que inicializa el estado "Comenzar Viaje" para un vehículo.
     *
     * @param vehmos El vehículo que está en el estado de comenzar el viaje.
     */
    public ComenzarViaje(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    /**
     * Informa que el ID del cliente ya ha sido verificado, por lo que no se puede volver a verificar.
     */
    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID.");
    }

    /**
     * Cambia el estado del vehículo a "En Movimiento" y comienza a seguir la ruta.
     */
    @Override
    public void seguirRuta() {
        System.out.println("Siguiendo la ruta...");
        vehmos.setState(vehmos.getEnMovimiento());
    }

    /**
     * Informa que el vehículo aún tiene suficiente combustible para comenzar el viaje.
     */
    @Override
    public void sinCombustible() {
        System.out.println("El vehiculo aún tiene combustible.");
    }

    /**
     * Informa que no se puede recargar combustible en este estado, ya que el viaje está comenzando.
     */
    @Override
    public void recargar() {
        System.out.println("No se puede recargar.");
    }

    /**
     * Informa que no es posible verificar la ubicación del vehículo porque el viaje apenas ha comenzado.
     */
    @Override
    public void verificarUbicacion() {
        System.out.println("A penas inicio el viaje, no se puede verificar si ya se llegó a la ubicación.");
    }

    /**
     * Informa que no es posible finalizar el viaje ya que acaba de comenzar.
     */
    @Override
    public void finalizaViaje() {
        System.out.println("El viaje apenas ha comenzado.");
    }

    /**
     * Informa que no se puede buscar un nuevo viaje mientras el vehículo está en medio de uno.
     */
    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar otro viaje si hay uno en curso.");
    }

    /**
     * Devuelve una representación en cadena del estado actual del vehículo.
     *
     * @return Una cadena que indica que el estado del vehículo es "Comenzando viaje".
     */
    @Override
    public String toString() {
        return "Comenzando viaje";
    }
}

/**
 * La clase AlertaDeCombustible implementa el estado "Alerta de Combustible" dentro del patrón de diseño **State**.
 * Representa el estado en el que el vehículo ha entrado en alerta debido a niveles bajos de combustible,
 * lo que requiere que el vehículo se detenga y recargue antes de continuar.
 *
 * Esta clase es parte de un sistema de gestión de estados para vehículos, donde el comportamiento de cada acción
 * varía según el estado actual del vehículo.
 *
 * @author Los Hijos de Korhal
 */
public class AlertaDeCombustible implements State {
    private VehMos vehmos;

    /**
     * Constructor que inicializa el estado "Alerta de Combustible" para un vehículo.
     *
     * @param vehmos El vehículo que ha entrado en estado de alerta de combustible.
     */
    public AlertaDeCombustible(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    /**
     * Informa que el ID ya ha sido verificado, por lo que no se puede volver a verificar.
     */
    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID, no se puede hacer nuevamente.");
    }

    /**
     * Informa que no se puede continuar con la ruta mientras el vehículo está recargando combustible.
     */
    @Override
    public void seguirRuta() {
        System.out.println("No se puede seguir si el coche está recargando.");
    }

    /**
     * Informa que el vehículo ya está en estado de alerta de combustible.
     */
    @Override
    public void sinCombustible() {
        System.out.println("Ya se está en estado de alerta de combustible.");
    }

    /**
     * Recarga el combustible del vehículo y, una vez recargado, cambia el estado del vehículo a "En Movimiento".
     */
    @Override
    public void recargar() {
        System.out.println("Recargando combustible...");
        // Llama al método específico de recarga del vehículo
        vehmos.recargarCombustible();
        // Después de recargar, vuelve al estado EnMovimiento
        vehmos.setState(vehmos.getEnMovimiento());
    }

    /**
     * Informa que no es posible verificar la ubicación del vehículo mientras se está recargando.
     */
    @Override
    public void verificarUbicacion() {
        System.out.println("No se puede verificar la ubicación si el coche está recargando.");
    }

    /**
     * Informa que no se puede finalizar el viaje mientras el vehículo está en estado de recarga de combustible.
     */
    @Override
    public void finalizaViaje() {
        System.out.println("No se puede finalizar si el coche está recargando.");
    }

    /**
     * Informa que no se puede buscar un nuevo viaje mientras el vehículo ya está en uno y en estado de alerta.
     */
    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar un viaje cuando ya se está en uno.");
    }
}

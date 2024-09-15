/**
 * La clase EnMovimiento implementa el estado "En Movimiento" de un vehículo dentro del patrón de diseño **State**.
 * Representa el estado en el que el vehículo está en movimiento y define los comportamientos asociados a este estado,
 * tales como la verificación de ID, la verificación de la ubicación, y la detección de combustible bajo.
 *
 * Esta clase es parte de un sistema de gestión de estados para vehículos, donde el comportamiento de cada acción
 * varía según el estado actual del vehículo.
 *
 * @author Los Hijos de Korhal
 */
public class EnMovimiento implements State {
    private VehMos vehmos;

    /**
     * Constructor que inicializa el estado "En Movimiento" para un vehículo.
     *
     * @param vehmos El vehículo que está en movimiento.
     */
    public EnMovimiento(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    /**
     * Informa que el ID del cliente ya ha sido verificado y no puede ser verificado nuevamente mientras el vehículo está en movimiento.
     */
    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID, no se puede hacer nuevamente.");
    }

    /**
     * Informa que el vehículo ya está en movimiento, por lo que no se puede iniciar un nuevo recorrido.
     */
    @Override
    public void seguirRuta() {
        System.out.println("Ya se está en movimiento.");
    }

    /**
     * Informa que el vehículo se ha quedado sin combustible y cambia el estado del vehículo a "Alerta de Combustible".
     */
    @Override
    public void sinCombustible() {
        System.out.println("Vehículo sin combustible. Deteniendo el viaje.");
        vehmos.setState(vehmos.getAlertaDeCombustible());
    }

    /**
     * Informa que no es posible recargar combustible mientras el vehículo está en movimiento.
     */
    @Override
    public void recargar() {
        System.out.println("No se puede recargar en movimiento.");
    }

    /**
     * Verifica la ubicación actual del vehículo. Si el vehículo ha llegado al destino, cambia su estado a "Viaje Finalizado".
     */
    @Override
    public void verificarUbicacion() {
        System.out.println("Verificando ubicación...");
        // Aquí va la lógica para verificar la ubicación
        // Si el vehículo ha llegado al destino, se cambia al estado ViajeFinalizado
        vehmos.setState(vehmos.getViajeFinalizado());
    }

    /**
     * Informa que no es posible finalizar el viaje mientras el vehículo sigue en movimiento.
     */
    @Override
    public void finalizaViaje() {
        System.out.println("No se puede finalizar el viaje si el coche sigue en movimiento.");
    }

    /**
     * Informa que no se puede buscar un nuevo viaje mientras el vehículo está en movimiento.
     */
    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar un viaje cuando ya se está en uno.");
    }

    /**
     * Devuelve una representación en cadena del estado actual del vehículo.
     *
     * @return Una cadena que indica que el estado del vehículo es "En Movimiento".
     */
    @Override
    public String toString() {
        return "En Movimiento";
    }
}

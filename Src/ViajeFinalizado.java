/**
 * La clase ViajeFinalizado implementa la interfaz State y representa el estado en el cual
 * un vehículo ha completado su viaje. En este estado, no se pueden realizar ciertas acciones
 * como continuar la ruta o recargar combustible, ya que el viaje ha concluido. Sin embargo,
 * se puede iniciar la búsqueda de un nuevo viaje.
 *
 * Esta clase es parte del patrón de diseño State, donde las diferentes acciones que puede
 * realizar el vehículo dependen de su estado actual.
 *
 * @author Los Hijos de Korhal
 */
public class ViajeFinalizado implements State {
    private VehMos vehmos;

    /**
     * Constructor que inicializa el estado ViajeFinalizado con una referencia al vehículo.
     *
     * @param vehmos El vehículo que ha finalizado su viaje.
     */
    public ViajeFinalizado(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    /**
     * Informa que ya se ha verificado el ID y no es posible volver a hacerlo,
     * ya que el viaje ha finalizado.
     */
    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID, no se puede hacer nuevamente.");
    }

    /**
     * Informa que no es posible seguir la ruta, ya que el viaje ha finalizado.
     */
    @Override
    public void seguirRuta() {
        System.out.println("No se puede seguir la ruta el viaje ha finalizado.");
    }

    /**
     * Informa que el vehículo ya ha finalizado su viaje, por lo que no es posible
     * quedarse sin combustible en este estado.
     */
    @Override
    public void sinCombustible() {
        System.out.println("El viaje ha finalizado.");
    }

    /**
     * Informa que no se puede recargar combustible, ya que el viaje ha concluido.
     */
    @Override
    public void recargar() {
        System.out.println("No se puede recargar si el viaje ha finalizado.");
    }

    /**
     * Informa que el vehículo ya ha llegado a su destino final.
     */
    @Override
    public void verificarUbicacion() {
        System.out.println("Ya se ha llegado a la ubicación final.");
    }

    /**
     * Informa que el viaje ya está finalizado y no es posible finalizarlo nuevamente.
     */
    @Override
    public void finalizaViaje() {
        System.out.println("El viaje ha está finalizado.");
    }

    /**
     * Cambia el estado del vehículo a "En espera" y permite que el vehículo
     * comience a buscar un nuevo viaje.
     */
    @Override
    public void buscarViaje() {
        System.out.println("Buscando nuevo viaje...");
        vehmos.setState(vehmos.getEnEspera());
    }

    /**
     * Devuelve una representación en cadena del estado actual del vehículo.
     *
     * @return Una cadena que indica que el viaje está finalizando.
     */
    @Override
    public String toString() {
        return "Finalizando viaje";
    }
}

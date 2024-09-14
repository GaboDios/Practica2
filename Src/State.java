/**
 * Interfaz que define los métodos que serán implementados por cada estado de un vehículo Vehmos.
 * Cada estado tendrá su propia implementación de las acciones disponibles.
 */
public interface State {
    
    /**
     * Verifica la identificación del cliente o usuario si es correcto transiciona al estado Comenzar viaje.
     */
    public void verificaID();

    /**
     * Inicia o sigue la ruta preestablecida en el vehículo Vehmos.
     * Este método será invocado cuando el vehículo hay comenzado el viaje, transiciona al estado en movimiento.
     */
    public void seguirRuta();

    /**
     * Maneja el caso en el que el vehículo Vehmos se quede sin combustible.
     * Este método detiene el viaje y transiciona al estado de alertaDeCombustible.
     */
    public void sinCombustible();

    /**
     * Realiza la recarga de combustible del vehículo Vehmos.
     * Este método recarga el combustible del vehiculo Vehmos y regresa al estado En movimiento.
     */
    public void recargar();

    /**
     * Verifica la ubicación actual del vehículo Vehmos.
     * Se utiliza para comprobar si el vehículo ha llegado a su destino si ha llegado transiciona al estado viajeFinalizado.
     */
    public void verificarUbicacion();

    /**
     * Finaliza el viaje del vehículo cuando se ha alcanzado el destino.
     * Este método indica que el viaje ha concluido y transiciona a un estado final.
     */
    public void finalizaViaje();

    /**
     * Finaliza el viaje del vehículo cuando se ha alcanzado el destino.
     * Este método indica que el conductor quiere seguir llevando pasajeros y transiciona al estado en espera para continuar el ciclo.
     */

    public void buscarViaje();

}

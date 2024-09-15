/**
 * La clase VidriosPolarizados extiende de TunningDecorator y representa una
 * modificación que agrega vidrios polarizados a un vehículo. Esta modificación
 * puede afectar la descripción y el costo del viaje del vehículo, mientras que
 * otros comportamientos, como el uso de combustible o los requerimientos de
 * terracería, se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño Decorator, permitiendo agregar nuevas
 * características a los objetos de tipo VehMos sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class VidriosPolarizados extends TunningDecorator {

    /**
     * Constructor que inicializa la clase VidriosPolarizados.
     *
     * @param vehiculo El vehículo al cual se le añadirán los vidrios polarizados.
     */
     public VidriosPolarizados(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con la modificación de vidrios polarizados.
     *
     * @return Una cadena que describe el vehículo con vidrios polarizados.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con vidrios polarizados";
     }

    /**
     * Calcula el costo adicional del viaje por tener vidrios polarizados.
     * El costo del viaje se incrementa en una cantidad fija de 10 unidades monetarias.
     *
     * @return El costo del viaje con el recargo por los vidrios polarizados.
     */
    @Override
     public double costoViaje(){
         return 10.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La implementación actual no afecta
     * el comportamiento relacionado al combustible, por lo que se delega la
     * llamada al vehículo base.
     */
     @Override
    public void recargarCombustible() {
        vehiculo.recargarCombustible();
    }

    /**
     * Determina si el cliente requiere que el vehículo pueda transitar por terracería.
     * Actualmente, el comportamiento se delega al vehículo base, pero puede ajustarse
     * según las necesidades de negocio.
     *
     * @return true si el cliente requiere terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria();
    }
 }
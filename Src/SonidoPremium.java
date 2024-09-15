/**
 * La clase SonidoPremium extiende de TunningDecorator y representa una mejora
 * que añade un sistema de sonido premium al vehículo. Esta mejora afecta tanto
 * la descripción del vehículo como el costo del viaje. Otros comportamientos,
 * como la recarga de combustible o la necesidad de rutas por terracería, se
 * delegan al vehículo base.
 *
 * La clase sigue el patrón de diseño Decorator, permitiendo que se añadan
 * características adicionales a un vehículo sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class SonidoPremium extends TunningDecorator {

    /**
     * Constructor que inicializa la clase SonidoPremium, agregando un sistema
     * de sonido premium al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirá el sistema de sonido premium.
     */
     public SonidoPremium(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con el sistema de sonido premium añadido.
     *
     * @return Una cadena de texto que describe el vehículo con el sistema de sonido premium.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con sonidoPremium";
     }

    /**
     * Calcula el costo adicional del viaje por tener un sistema de sonido premium.
     * El costo del viaje se incrementa en 15 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por el sistema de sonido premium.
     */
    @Override
     public double costoViaje(){
         return 15.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. El sistema de sonido premium no afecta
     * el comportamiento relacionado con el combustible, por lo que la llamada se
     * delega al método del vehículo base.
     */
    @Override
    public void recargarCombustible() {
        // Aquí podrías decidir si el alerón afecta el uso de combustible.
        // Si no, simplemente delegamos la llamada al vehículo base
        vehiculo.recargarCombustible();
    }

    /**
     * Determina si el cliente requiere que el vehículo pueda transitar por terracería.
     * Este comportamiento se delega al vehículo base, pero puede ajustarse según
     * las necesidades de negocio.
     *
     * @return true si el cliente requiere una ruta por terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar según la lógica
    }
     
 }
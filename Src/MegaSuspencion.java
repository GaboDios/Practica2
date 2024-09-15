/**
 * La clase MegaSuspencion extiende de TunningDecorator y añade una mejora de suspensión
 * avanzada al vehículo. Esta mejora afecta tanto la descripción del vehículo como el costo
 * del viaje. Otros comportamientos, como la recarga de combustible y la necesidad de transitar
 * por terracería, se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño **Decorator**, permitiendo añadir características
 * adicionales a un vehículo sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class MegaSuspencion extends TunningDecorator {

    /**
     * Constructor que inicializa la clase MegaSuspencion, añadiendo la suspensión avanzada
     * al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirá la suspensión avanzada.
     */
     public MegaSuspencion(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con la suspensión avanzada añadida.
     *
     * @return Una cadena de texto que describe el vehículo con MegaSuspencion.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con MegaSuspecion.";
     }

    /**
     * Calcula el costo adicional del viaje por tener la mejora de suspensión avanzada.
     * El costo del viaje se incrementa en 7 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por la suspensión avanzada.
     */
    @Override
     public double costoViaje(){
         return 7.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La mejora de suspensión no afecta
     * el comportamiento relacionado con el combustible, por lo que se delega
     * la llamada al método del vehículo base.
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
     * la lógica del negocio.
     *
     * @return true si el cliente requiere una ruta por terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar según la lógica
    }

 }
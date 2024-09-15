/**
 * La clase Portavasos extiende de TunningDecorator y añade un portavasos al vehículo.
 * Esta mejora afecta la descripción del vehículo y el costo del viaje, pero otros
 * comportamientos, como la recarga de combustible o la necesidad de transitar por
 * terracería, se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño **Decorator**, permitiendo añadir
 * características adicionales a un vehículo sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class Portavasos extends TunningDecorator {

    /**
     * Constructor que inicializa la clase Portavasos, añadiendo un portavasos al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirá el portavasos.
     */
     public Portavasos(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con el portavasos añadido.
     *
     * @return Una cadena de texto que describe el vehículo con el portavasos.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con portavasos.";
     }

    /**
     * Calcula el costo adicional del viaje por tener un portavasos en el vehículo.
     * El costo del viaje se incrementa en 3 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por el portavasos.
     */
    @Override
     public double costoViaje(){
         return 3.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La presencia del portavasos no afecta
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
     * la lógica del negocio.
     *
     * @return true si el cliente requiere una ruta por terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar según la lógica
    }
     
 }
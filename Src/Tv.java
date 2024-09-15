/**
 * La clase Tv extiende de TunningDecorator y representa una mejora que agrega una televisión
 * al vehículo. Esta mejora puede afectar tanto la descripción como el costo del viaje,
 * mientras que otros comportamientos como la recarga de combustible y la necesidad de terracería
 * se delegan al vehículo base.
 *
 * La clase sigue el patrón de diseño Decorator, permitiendo añadir características adicionales
 * al vehículo sin alterar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class Tv extends TunningDecorator {

    /**
     * Constructor que inicializa la clase Tv agregando una televisión al vehículo especificado.
     *
     * @param vehiculo El vehículo al cual se le añadirá la televisión.
     */
     public Tv(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con la televisión añadida.
     *
     * @return Una cadena de texto que describe el vehículo con la televisión.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con television";
     }

    /**
     * Calcula el costo adicional del viaje por tener una televisión instalada en el vehículo.
     * El costo del viaje se incrementa en 5 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por la televisión.
     */
     public double costoViaje(){
         return 5.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La implementación actual no afecta el comportamiento
     * relacionado con el combustible debido a la presencia de la televisión, por lo que se delega
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
     * Este comportamiento se delega al vehículo base, pero puede ajustarse según la lógica de negocio.
     *
     * @return true si el cliente requiere terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar según la lógica
    }
 }
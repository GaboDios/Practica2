/**
 * La clase Sirena extiende de TunningDecorator y añade una sirena al vehículo.
 * Esta mejora afecta tanto la descripción como el costo del viaje. Otros comportamientos,
 * como la recarga de combustible y la necesidad de rutas por terracería, se delegan
 * al vehículo base.
 *
 * Esta clase sigue el patrón de diseño Decorator, permitiendo agregar características
 * adicionales a un vehículo sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class Sirena extends TunningDecorator {

    /**
     * Constructor que inicializa la clase Sirena, agregando una sirena al vehículo especificado.
     *
     * @param vehiculo El vehículo al cual se le añadirá la sirena.
     */
    public Sirena(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con la sirena añadida.
     *
     * @return Una cadena de texto que describe el vehículo con la sirena.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con sirena";
     }

    /**
     * Calcula el costo adicional del viaje por tener una sirena en el vehículo.
     * El costo del viaje se incrementa en 15 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por la sirena.
     */
    @Override
     public double costoViaje(){
         return 15.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La presencia de la sirena no afecta
     * el comportamiento relacionado con el combustible, por lo que se delega la
     * llamada al método del vehículo base.
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
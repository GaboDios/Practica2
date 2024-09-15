/**
 * La clase AsientosDeLeopardo extiende de TunningDecorator y añade una mejora decorativa de asientos de leopardo
 * al vehículo. Esta mejora afecta tanto la descripción del vehículo como el costo del viaje. Otros comportamientos,
 * como la recarga de combustible y la necesidad de transitar por terracería, se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño **Decorator**, permitiendo agregar características adicionales a un vehículo
 * sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class AsientosDeLeopardo extends TunningDecorator {

    /**
     * Constructor que inicializa la clase AsientosDeLeopardo, añadiendo asientos de leopardo al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirán los asientos de leopardo.
     */
    public AsientosDeLeopardo(VehMos vehiculo){
        super(vehiculo);
    }

    /**
     * Devuelve la descripción del vehículo con los asientos de leopardo añadidos.
     *
     * @return Una cadena de texto que describe el vehículo con asientos de leopardo.
     */
    @Override
    public String getDescripcion(){
        return vehiculo.getDescripcion() + ", con asientos de Leopardo";
    }

    /**
     * Calcula el costo adicional del viaje por tener asientos de leopardo en el vehículo.
     * El costo del viaje se incrementa en 10 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por los asientos de leopardo.
     */
    @Override
    public double costoViaje(){
        return 10.0 + vehiculo.costoViaje();
    }

    /**
     * Recarga el combustible del vehículo. La mejora de asientos de leopardo no afecta
     * el comportamiento relacionado con el combustible, por lo que se delega la llamada
     * al método del vehículo base.
     */
    @Override
    public void recargarCombustible() {
        // Aquí podrías decidir si el alerón afecta el uso de combustible.
        // Si no, simplemente delegamos la llamada al vehículo base
        vehiculo.recargarCombustible();
    }

    /**
     * Determina si el cliente requiere que el vehículo pueda transitar por terracería.
     * Este comportamiento se delega al vehículo base, pero puede ajustarse según la lógica del negocio.
     *
     * @return true si el cliente requiere una ruta por terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar según la lógica
    }
}

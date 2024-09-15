/**
 * La clase DadosDePeluche extiende de TunningDecorator y añade dados de peluche como mejora decorativa al vehículo.
 * Esta mejora afecta la descripción del vehículo y el costo del viaje, pero otros comportamientos como la recarga
 * de combustible y la necesidad de transitar por terracería se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño **Decorator**, permitiendo agregar características adicionales a un vehículo
 * sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class DadosDePeluche extends TunningDecorator {

    /**
     * Constructor que inicializa la clase DadosDePeluche, añadiendo dados de peluche al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirán los dados de peluche.
     */
     public DadosDePeluche(VehMos vehiculo){
         super(vehiculo);
     }

    /**
     * Devuelve la descripción del vehículo con los dados de peluche añadidos.
     *
     * @return Una cadena de texto que describe el vehículo con dados de peluche.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con Dados de peluche";
     }

    /**
     * Calcula el costo adicional del viaje por tener dados de peluche en el vehículo.
     * El costo del viaje se incrementa en 5 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por los dados de peluche.
     */
    @Override
     public double costoViaje(){
         return 5.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La mejora de dados de peluche no afecta el comportamiento
     * relacionado con el combustible, por lo que se delega la llamada al método del vehículo base.
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
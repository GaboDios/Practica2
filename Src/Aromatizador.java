/**
 * La clase Aromatizador extiende de TunningDecorator y añade un aromatizador como mejora al vehículo.
 * Esta mejora afecta tanto la descripción del vehículo como el costo del viaje. Otros comportamientos,
 * como la recarga de combustible y la necesidad de transitar por terracería, se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño **Decorator**, permitiendo agregar características adicionales a un vehículo
 * sin modificar su estructura original.
 *
 * @author Los Hijos de Korhal
 */
public class Aromatizador extends TunningDecorator {

    /**
     * Constructor que inicializa la clase Aromatizador, añadiendo un aromatizador al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirá el aromatizador.
     */
     public Aromatizador(VehMos vehiculo){
         super(vehiculo);
     }
    /**
     * Devuelve la descripción del vehículo con el aromatizador añadido.
     *
     * @return Una cadena de texto que describe el vehículo con aromatizador.
     */
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con aromatizador";
     }

    /**
     * Calcula el costo adicional del viaje por tener un aromatizador en el vehículo.
     * El costo del viaje se incrementa en 3 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por el aromatizador.
     */
    @Override
     public double costoViaje(){
         return 3.0 + vehiculo.costoViaje();
     }

    /**
     * Recarga el combustible del vehículo. La mejora del aromatizador no afecta
     * el comportamiento relacionado con el combustible, por lo que se delega la llamada al método del vehículo base.
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

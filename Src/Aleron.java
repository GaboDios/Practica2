/**
 * La clase Aleron extiende de TunningDecorator y añade un alerón deportivo como mejora al vehículo.
 * Esta mejora afecta tanto la descripción del vehículo como el costo del viaje. Otros comportamientos,
 * como la recarga de combustible y la necesidad de transitar por terracería, se delegan al vehículo base.
 *
 * Esta clase sigue el patrón de diseño **Decorator**, permitiendo agregar características adicionales a un vehículo
 * sin modificar su estructura original.
 *
 * Ejemplo de uso:
 * <pre>
 * VehMos miVehiculo = new Carro();
 * miVehiculo = new Aleron(miVehiculo);
 * System.out.println(miVehiculo.getDescripcion());
 * </pre>
 *
 * @version 1.0
 */
public class Aleron extends TunningDecorator {

    /**
     * Constructor que inicializa la clase Aleron, añadiendo un alerón deportivo al vehículo especificado.
     *
     * @param vehiculo El vehículo al que se le añadirá el alerón deportivo.
     */
    public Aleron(VehMos vehiculo) {
        super(vehiculo);
    }

    /**
     * Devuelve la descripción del vehículo con el alerón deportivo añadido.
     *
     * @return Una cadena de texto que describe el vehículo con alerón deportivo.
     */
    @Override
    public String getDescripcion() {
        return vehiculo.getDescripcion() + ", con alerón deportivo";
    }

    /**
     * Calcula el costo adicional del viaje por tener un alerón deportivo en el vehículo.
     * El costo del viaje se incrementa en 500 unidades monetarias.
     *
     * @return El costo total del viaje con el recargo por el alerón deportivo.
     */
    @Override
    public double costoViaje() {
        return vehiculo.costoViaje() + 500;  // El valor puede ajustarse según la lógica
    }

    /**
     * Recarga el combustible del vehículo. La mejora de alerón no afecta el comportamiento relacionado
     * con el combustible, por lo que se delega la llamada al método del vehículo base.
     */
    @Override
    public void recargarCombustible() {
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
        return vehiculo.clienteRequiereTerraceria();
    }
}

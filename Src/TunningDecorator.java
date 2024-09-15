/**
 * La clase abstracta TunningDecorator extiende de VehMos y actúa como una clase decoradora
 * para agregar funcionalidades adicionales a los vehículos. Sigue el patrón de diseño
 * Decorator, permitiendo que objetos de tipo VehMos puedan ser mejorados dinámicamente
 * sin alterar la estructura del objeto original.
 *
 * Esta clase sirve como la base para cualquier tipo de personalización (tunning) que se
 * desee realizar en un vehículo, como agregar elementos adicionales (ej. televisión, alerón).
 * Los métodos no modificados se delegan al objeto VehMos original.
 *
 * @author Los Hijos de Korhal
 */
public abstract class TunningDecorator extends VehMos {

    /**
     * El vehículo que está siendo decorado con mejoras adicionales.
     */
    protected VehMos vehiculo;  // El objeto que está siendo decorado

    /**
     * Constructor que inicializa el decorador con un vehículo base.
     * Este constructor también inicializa el consumo y la cantidad de combustible
     * del vehículo decorado.
     *
     * @param vehiculo El vehículo que está siendo decorado.
     */
    public TunningDecorator(VehMos vehiculo) {
        super(vehiculo.getCantidadCombustible(),vehiculo.getConsumoPorKm());
        this.vehiculo = vehiculo;
    }

    /**
     * Devuelve la descripción del vehículo decorado. Este método puede ser sobrescrito
     * por subclases concretas para agregar más información sobre las mejoras adicionales.
     *
     * @return La descripción del vehículo base, que puede ser ampliada por las subclases.
     */
    @Override
    public String getDescripcion() {
        return vehiculo.getDescripcion();
    }

}

public abstract class TunningDecorator extends VehMos {
    protected VehMos vehiculo;  // El objeto que está siendo decorado

    public TunningDecorator(VehMos vehiculo) {
        super(vehiculo.getCantidadCombustible(),vehiculo.getConsumoPorKm());
        this.vehiculo = vehiculo;
    }

    @Override
    public String getDescripcion() {
        return vehiculo.getDescripcion();
    }

    // Otros métodos pueden delegarse al objeto vehiculo
}

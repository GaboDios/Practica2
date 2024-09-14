public abstract class TunningDecorator extends VehMos {
    protected VehMos vehiculo;  // El objeto que está siendo decorado

    public TunningDecorator(VehMos vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String getDescripcion() {
        return vehiculo.getDescripcion();
    }

    // Otros métodos pueden delegarse al objeto vehiculo
}

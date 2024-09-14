public class Aleron extends TunningDecorator {

    public Aleron(VehMos vehiculo) {
        super(vehiculo);  // Llamada al constructor de la clase base
    }

    @Override
    public String getDescripcion() {
        return vehiculo.getDescripcion() + ", con alerón deportivo";
    }

    @Override
    public double costoViaje() {
        // Aumenta el costo del viaje por el alerón
        return vehiculo.costoViaje() + 500; // El valor puede ajustarse según la lógica
    }

    @Override
    public void recargarCombustible() {
        // Aquí podrías decidir si el alerón afecta el uso de combustible.
        // Si no, simplemente delegamos la llamada al vehículo base
        vehiculo.recargarCombustible();
    }

    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar según la lógica
    }

}

public class LucesLed extends TunningDecorator {
    public LucesLed(VehMos vehiculo){
         super(vehiculo);
     }
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con luces led";
     }
     
     public double costoViaje(){
         return 5.0 + vehiculo.costoViaje();
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
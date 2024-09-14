public class MegaSuspencion extends TunningDecorator {

     public MegaSuspencion(VehMos vehiculo){
         super(vehiculo);
     }
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con MegaSuspecion.";
     }
     
     public double costoViaje(){
         return 7.0 + vehiculo.costoViaje();
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
public class Aromatizador extends TunningDecorator {

     public Aromatizador(VehMos vehiculo){
         super(vehiculo);
     }
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con aromatizador.";
     }
     
     public double costoViaje(){
         return 3.0 + vehiculo.costoViaje();
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

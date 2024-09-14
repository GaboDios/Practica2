public class VidriosPolarizados extends TunningDecorator {
    
     public VidriosPolarizados(VehMos vehiculo){
         super(vehiculo);
     }
     @Override
     public String getDescripcion(){
         return vehiculo.getDescripcion() + ", con vidrios polarizados.";
     }
     
     public double costoViaje(){
         return 10.0 + vehiculo.costoViaje();
     }
     
     @Override
    public void recargarCombustible() {
        // Aqui podrias decidir si el aleron afecta el uso de combustible.
        // Si no, simplemente delegamos la llamada al veh�culo base
        vehiculo.recargarCombustible();
    }

    @Override
    public boolean clienteRequiereTerraceria() {
        return vehiculo.clienteRequiereTerraceria(); // O ajustar seg�n la l�gica
    }
 }
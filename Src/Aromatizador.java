public class Aromatizador extends TunningDecorator {
    VehMos vehmos;
    
     public Aromatizador(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con aromatizador.";
     }
     
     public double costoViaje(){
         return 3.0 + vehmos.costoViaje();
     }
     
 }

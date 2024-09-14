public class Sirena extends TunningDecorator {
    VehMos vehmos;
    
     public Sirena(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con sirena.";
     }
     
     public double costoViaje(){
         return 15.0 + vehmos.costoViaje();
     }
     
 }
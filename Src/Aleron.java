public class Aleron extends TunningDecorator {
    VehMos vehmos;
    
     public Aleron(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con aleron.";
     }
     
     public double costoViaje(){
         return 10.0 + vehmos.costoViaje();
     }
     
 }

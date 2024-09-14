public class Tv extends TunningDecorator {
    VehMos vehmos;
    
     public Tv(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con television.";
     }

     
     public double costoViaje(){
         return 5.0 + vehmos.costoViaje();
     }
     
 }
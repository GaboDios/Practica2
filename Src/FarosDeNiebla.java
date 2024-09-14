public class FarosDeNiebla extends TunningDecorator {
    VehMos vehmos;
    
     public FarosDeNiebla(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con faros para niebla.";
     }
     
     public double costoViaje(){
         return 10.0 + vehmos.costoViaje();
     }
     
 }
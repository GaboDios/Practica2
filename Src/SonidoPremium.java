public class SonidoPremium extends TunningDecorator {
    VehMos vehmos;
    
     public SonidoPremium(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con sonidoPremium.";
     }
     
     public double costoViaje(){
         return 15.0 + vehmos.costoViaje();
     }
     
 }
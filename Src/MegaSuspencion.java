public class MegaSuspencion extends TunningDecorator {
    VehMos vehmos;
    
     public MegaSuspencion(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con MegaSuspecion.";
     }
     
     public double costoViaje(){
         return 7.0 + vehmos.costoViaje();
     }
     
 }
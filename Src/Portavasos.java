public class Portavasos extends TunningDecorator {
    VehMos vehmos;
    
     public Portavasos(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con portavasos.";
     }
     
     public double costoViaje(){
         return 3.0 + vehmos.costoViaje();
     }
     
 }
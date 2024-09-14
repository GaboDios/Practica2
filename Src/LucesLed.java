public class LucesLed extends TunningDecorator {
    VehMos vehmos;
    
     public LucesLed(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con luces led.";
     }
     
     public double costoViaje(){
         return 5.0 + vehmos.costoViaje();
     }
     
 }
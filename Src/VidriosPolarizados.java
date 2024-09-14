public class VidriosPolarizados extends TunningDecorator {
    VehMos vehmos;
    
     public VidriosPolarizados(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con vidrios polarizados.";
     }
     
     public double costoViaje(){
         return 10.0 + vehmos.costoViaje();
     }
     
 }
public class DadosDePeluche extends TunningDecorator {
    VehMos vehmos;
    
     public DadosDePeluche(VehMos vehmos){
         this.vehmos = vehmos;
     }
     @Override
     public String getDescripcion(){
         return vehmos.getDescripcion() + ", con Dados de peluche.";
     }
     
     public double costoViaje(){
         return 5.0 + vehmos.costoViaje();
     }
     
 }
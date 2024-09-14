public class AsientosDeLeopardo extends TunningDecorator {
   VehMos vehmos;
   
    public AsientosDeLeopardo(VehMos vehmos){
        this.vehmos = vehmos;
    }
    @Override
    public String getDescripcion(){
        return vehmos.getDescripcion() + ", con asientos de Leopardo.";
    }
    
    public double costoViaje(){
        return 10.0 + vehmos.costoViaje();
    }
    
}

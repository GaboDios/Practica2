public abstract class VehMos implements State{
    //Variables de cada vehiculo
    private static int cantidadCombustible;
    private static double tiempoDeLlegada;
    //Variables de referencia State
    private static State esperarUnViaje;
    private static State comenzarUnViaje;
    private static State enMovimiento;
    private static State alertaDeCombustible;
    private static State finalizarElViaje;
    //Constructor y metodos que comparten todos los vehiculos
    public VehMos(){};
    public boolean encenderVehiculo(){};
    public boolean apagarVehiculo(){};
    //Parte de template
    public abstract void recargarCombustible(){};
    public abstract void seguirRuta(){};
    public abstract void hook();
    //Metodos a checar uso
    public void setTiempo(double tiempo){};
    public double getTiempo(){};
    public void setCombustible(int combustible){};
    public int getCombustible(){};
    //Cantidad de complementos, distanciarecorrida, obtener numero de modificaciones
    public void limiteDeTuning(int numerolimite){};
    public void getModificacion(){};
    public void calcularDistancia(){};
    //obtener estado y actualizar estado
    public State getState(){};
    public void setState(State state){};
    
}

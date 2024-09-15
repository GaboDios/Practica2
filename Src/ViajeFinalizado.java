public class ViajeFinalizado implements State {
    private VehMos vehmos;

    public ViajeFinalizado(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID, no se puede hacer nuevamente.");
    }

    @Override
    public void seguirRuta() {
        System.out.println("No se puede seguir la ruta el viaje ha finalizado.");
    }

    @Override
    public void sinCombustible() {
        System.out.println("El viaje ha finalizado.");
    }

    @Override
    public void recargar() {
        System.out.println("No se puede recargar si el viaje ha finalizado.");
    }

    @Override
    public void verificarUbicacion() {
        System.out.println("Ya se ha llegado a la ubicación final.");
    }

    @Override
    public void finalizaViaje() {
        System.out.println("El viaje ha está finalizado.");
    }

    @Override
    public void buscarViaje() {
        System.out.println("Buscando nuevo viaje...");
        vehmos.setState(vehmos.getEnEspera());
    }
    @Override
    public String toString() {
        return "Finalizando viaje";
    }
}

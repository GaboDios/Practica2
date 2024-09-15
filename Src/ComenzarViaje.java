public class ComenzarViaje implements State {
    private VehMos vehmos;

    public ComenzarViaje(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID.");
    }

    @Override
    public void seguirRuta() {
        System.out.println("Siguiendo la ruta...");
        vehmos.setState(vehmos.getEnMovimiento());
    }

    @Override
    public void sinCombustible() {
        System.out.println("El vehiculo aún tiene combustible.");
    }

    @Override
    public void recargar() {
        System.out.println("No se puede recargar.");
    }

    @Override
    public void verificarUbicacion() {
        System.out.println("A penas inicio el viaje, no se puede verificar si ya se llegó a la ubicación.");
    }

    @Override
    public void finalizaViaje() {
        System.out.println("El viaje apenas ha comenzado.");
    }

    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar otro viaje si hay uno en curso.");
    }

    @Override
    public String toString() {
        return "Comenzando viaje";
    }
}

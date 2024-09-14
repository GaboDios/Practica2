public class AlertaDeCombustible implements State {
    private VehMos vehmos;

    public AlertaDeCombustible(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID, no se puede hacer nuevamente.");
    }

    @Override
    public void seguirRuta() {
        System.out.println("No se puede seguir si el coche está recargando.");
    }

    @Override
    public void sinCombustible() {
        System.out.println("Ya se está en estado de alerta de combustible.");
    }

    @Override
    public void recargar() {
        System.out.println("Recargando combustible...");
        // Llama al método específico de recarga del vehículo
        vehmos.recargarCombustible();
        // Después de recargar, vuelve al estado EnMovimiento
        vehmos.setState(vehmos.getEnMovimiento());
    }
    

    @Override
    public void verificarUbicacion() {
        System.out.println("No se puede verificar la ubicación si el coche está recargando.");
    }

    @Override
    public void finalizaViaje() {
        System.out.println("No se puede finalizar si el coche está recargando.");
    }

    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar un viaje cuando ya se está en uno.");
    }
}

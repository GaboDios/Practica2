public class EnMovimiento implements State {
    private VehMos vehmos;

    public EnMovimiento(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    @Override
    public void verificaID() {
        System.out.println("Ya se ha verificado el ID, no se puede hacer nuevamente.");
    }

    @Override
    public void seguirRuta() {
        System.out.println("Ya se está en movimiento.");
    }

    @Override
    public void sinCombustible() {
        System.out.println("Vehículo sin combustible. Deteniendo el viaje.");
        vehmos.setState(vehmos.getAlertaDeCombustible());
    }

    @Override
    public void recargar() {
        System.out.println("No se puede recargar en movimiento.");
    }

    @Override
    public void verificarUbicacion() {
        System.out.println("Verificando ubicación...");
        // Aquí va la lógica para verificar la ubicación
        // Si el vehículo ha llegado al destino, se cambia al estado ViajeFinalizado
        vehmos.setState(vehmos.getViajeFinalizado());
    }

    @Override
    public void finalizaViaje() {
        System.out.println("No se puede finalizar el viaje si el coche sigue en movimiento.");
    }

    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar un viaje cuando ya se está en uno.");
    }

    @Override
    public String toString() {
        return "En Movimiento";
    }
}

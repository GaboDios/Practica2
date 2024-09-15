public class EnEspera implements State {
    private VehMos vehmos;

    public EnEspera(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    @Override
    public void verificaID() {

        System.out.println("Verificando ID");
        // Si ID es correcto
        vehmos.setState(vehmos.getComenzarViaje());
    }

    @Override
    public void seguirRuta() {
        System.out.println("No se puede seguir la ruta en el estado EnEspera.");
    }

    @Override
    public void sinCombustible() {
        System.out.println("No se puede manejar el caso sin combustible en el estado EnEspera.");
    }

    @Override
    public void recargar() {
        System.out.println("No se puede recargar en el estado EnEspera.");
    }

    @Override
    public void verificarUbicacion() {
        System.out.println("No se puede verificar la ubicación en el estado EnEspera.");
    }

    @Override
    public void finalizaViaje() {
        System.out.println("No se puede finalizar el viaje en el estado EnEspera.");
    }

    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar un viaje en el estado EnEspera.");
    }

    @Override
    public String toString() {
        return "En Espera";
    }
}
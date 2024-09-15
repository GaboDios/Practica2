/**
 * La clase EnEspera implementa el estado "En Espera" de un vehículo dentro del patrón de diseño **State**.
 * Representa el estado en el cual un vehículo está esperando antes de iniciar el viaje. En este estado,
 * solo es posible verificar el ID del cliente, y otras acciones como seguir la ruta, recargar o finalizar
 * el viaje están restringidas.
 *
 * Esta clase es parte de un sistema de gestión de estados para vehículos, donde el comportamiento de cada acción
 * varía según el estado actual del vehículo.
 *
 * @author Los Hijos de Korhal
 */
public class EnEspera implements State {
    private VehMos vehmos;

    /**
     * Constructor que inicializa el estado "En Espera" para un vehículo.
     *
     * @param vehmos El vehículo que está en estado de espera.
     */
    public EnEspera(VehMos vehmos) {
        this.vehmos = vehmos;
    }

    /**
     * Verifica el ID del cliente y, si es correcto, cambia el estado del vehículo a "Comenzar Viaje".
     *
     * Si el ID es correcto, el estado cambia para que el vehículo pueda iniciar el viaje.
     */
    @Override
    public void verificaID() {

        System.out.println("Verificando ID");
        // Si ID es correcto
        vehmos.setState(vehmos.getComenzarViaje());
    }

    /**
     * Informa que no es posible seguir la ruta mientras el vehículo está en el estado "En Espera".
     */
    @Override
    public void seguirRuta() {
        System.out.println("No se puede seguir la ruta en el estado EnEspera.");
    }

    /**
     * Informa que no es posible manejar la situación de falta de combustible en el estado "En Espera".
     */
    @Override
    public void sinCombustible() {
        System.out.println("No se puede manejar el caso sin combustible en el estado EnEspera.");
    }

    /**
     * Informa que no es posible recargar combustible mientras el vehículo está en el estado "En Espera".
     */
    @Override
    public void recargar() {
        System.out.println("No se puede recargar en el estado EnEspera.");
    }

    /**
     * Informa que no es posible verificar la ubicación del vehículo mientras está en el estado "En Espera".
     */
    @Override
    public void verificarUbicacion() {
        System.out.println("No se puede verificar la ubicación en el estado EnEspera.");
    }

    /**
     * Informa que no es posible finalizar el viaje mientras el vehículo está en el estado "En Espera".
     */
    @Override
    public void finalizaViaje() {
        System.out.println("No se puede finalizar el viaje en el estado EnEspera.");
    }

    /**
     * Informa que no es posible buscar un nuevo viaje mientras el vehículo está en el estado "En Espera".
     */
    @Override
    public void buscarViaje() {
        System.out.println("No se puede buscar un viaje en el estado EnEspera.");
    }

    /**
     * Devuelve una representación en cadena del estado actual del vehículo.
     *
     * @return Una cadena que indica que el estado del vehículo es "En Espera".
     */
    @Override
    public String toString() {
        return "En Espera";
    }
}
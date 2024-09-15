import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La clase Vehiculo4x4 extiende de VehMos y representa un vehículo todoterreno
 * con características específicas, como el consumo de combustible y la capacidad
 * para transitar por rutas de terracería. Implementa los métodos abstractos de
 * la clase VehMos, proporcionando comportamientos personalizados para un vehículo 4x4.
 *
 * Esta clase permite recargar combustible, determinar el costo del viaje, y
 * gestionar si el cliente requiere rutas de terracería o carretera.
 *
 * @author Los Hijos de Korhal
 */
public class Vehiculo4x4 extends VehMos {

    /**
     * Constructor para crear un vehículo 4x4 con 85 litros de combustible
     * y un consumo de 0.125 litros por kilómetro.
     * Se establece también una descripción por defecto para el vehículo.
     */
    public Vehiculo4x4() {
        super(85,0.125);// 85 litros de combustible y consume 0.125 litros por KM
        setDescripcion("Vehículo 4x4");
    }

    /**
     * Método para recargar el combustible del vehículo 4x4.
     * Este método establece el tanque lleno con 85 litros de combustible.
     */
    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para el vehículo 4x4...");
        setCantidadCombustible(85);
    }

    /**
     * Método que devuelve el costo fijo de un viaje en el vehículo 4x4.
     *
     * @return El costo del viaje, que es de 39.99 unidades monetarias.
     */
    @Override
    public double costoViaje() {
        return 39.99;
    }

    /**
     * Determina si el cliente requiere hacer la ruta por terracería.
     * Este método solicita la entrada del usuario para confirmar si desea tomar
     * una ruta por terracería o no.
     *
     * @return true si el cliente requiere una ruta por terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        String respuesta = getUserInput();
        return respuesta.toLowerCase().startsWith("s");
    }

    /**
     * Método privado para solicitar la entrada del usuario mediante consola.
     * Pregunta al usuario si requiere una ruta por terracería.
     *
     * @return La respuesta del usuario. Si ocurre un error de entrada/salida,
     * se devuelve "no" por defecto.
     */
    private String getUserInput() {
        String respuesta = null;
        System.out.println("¿Requieres hacer ruta por terracería? (s/n)");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            respuesta = in.readLine();
        } catch (IOException ioe) {
            System.err.println("Error de IO tratando de leer la respuesta");
        }
        if (respuesta == null) {
            return "no";
        }
        return respuesta;
    }

    /**
     * Método que determina la ruta a seguir. Dependiendo de si el cliente
     * requiere terracería, seguirá una ruta por terracería o por carretera.
     */
    public void seguirRuta() {
        if (clienteRequiereTerraceria()) {
            System.out.println("Siguiendo la ruta por terracería.");
        } else {
            System.out.println("Siguiendo la ruta por carretera.");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La clase Scooter extiende de VehMos y representa un vehículo de tipo scooter.
 * La scooter tiene una capacidad de combustible de 8 litros y un consumo de 0.033 litros por kilómetro.
 * Este vehículo puede recargar combustible, calcular el costo del viaje y determinar si el cliente
 * requiere transitar por terracería.
 *
 * Esta clase sigue el patrón de diseño Template Method, donde los métodos `recargarCombustible`,
 * `costoViaje`, y `clienteRequiereTerraceria` se implementan de manera específica para la scooter.

 * @author Los Hijos de Korhal
 */
public class Scooter extends VehMos {
    /**
     * Constructor que inicializa una scooter con 8 litros de combustible y un consumo de 0.033 litros por kilómetro.
     * También establece la descripción del vehículo como "Scooter".
     */
    public Scooter() {
        super(8,0.033);// 8 litros de combustible y consume 0.033 litros por KM
        setDescripcion("Scooter");
    }

    /**
     * Recarga el combustible de la scooter, llenando el tanque a 8 litros.
     * Imprime un mensaje indicando que se ha recargado gasolina.
     */
    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para la scooter...");
        setCantidadCombustible(8);
    }

    /**
     * Calcula el costo del viaje en scooter. El costo es fijo y es de 9.99 unidades monetarias.
     *
     * @return El costo del viaje, que es de 9.99 unidades monetarias.
     */
    @Override
    public double costoViaje() {
        return 9.99;
    }

    /**
     * Determina si el cliente requiere que la scooter transite por una ruta de terracería.
     * Solicita la entrada del usuario para confirmar si desea tomar una ruta por terracería.
     *
     * @return true si el cliente requiere una ruta por terracería, false en caso contrario.
     */
    @Override
    public boolean clienteRequiereTerraceria() {
        String respuesta = getUserInput();
        return respuesta.toLowerCase().startsWith("s");
    }

    /**
     * Solicita la entrada del usuario mediante consola para confirmar si desea tomar una ruta de terracería.
     *
     * @return La respuesta del usuario. Si ocurre un error de entrada/salida, devuelve "no" por defecto.
     * @throws IOException Si ocurre un error de entrada/salida al leer la respuesta del usuario.
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
     * Simula la ruta a seguir dependiendo de si el cliente requiere terracería o no.
     * Imprime un mensaje indicando si la scooter seguirá una ruta por terracería o carretera.
     */
    public void seguirRuta() {
        if (clienteRequiereTerraceria()) {
            System.out.println("Siguiendo la ruta por terracería.");
        } else {
            System.out.println("Siguiendo la ruta por carretera.");
        }
    }
}

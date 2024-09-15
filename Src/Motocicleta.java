import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * La clase Motocicleta extiende de VehMos y representa un vehículo de tipo motocicleta.
 * La motocicleta tiene una capacidad de combustible de 15 litros y un consumo de 0.04 litros por kilómetro.
 * Esta clase implementa métodos para recargar combustible, calcular el costo del viaje y verificar si
 * el cliente desea transitar por terracería.
 *
 * @author Los Hijos de Korhal
 */
public class Motocicleta extends VehMos {
    /**
     * Constructor que inicializa una motocicleta con 15 litros de combustible y un consumo de 0.04 litros por kilómetro.
     * También establece la descripción del vehículo como "Motocicleta".
     */
    public Motocicleta() {
        super(15,0.04); // 15 litros de combustible y consume 0.04 litros por KM
        setDescripcion("Motocicleta");
    }

    /**
     * Recarga el combustible de la motocicleta, llenando el tanque a 15 litros.
     * Imprime un mensaje indicando que se ha recargado gasolina.
     */
    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para la motocicleta...");
        // Lógica para recargar gasolina
        setCantidadCombustible(15); // Restablece el combustible a 100 después de recargar
    }

    /**
     * Calcula el costo del viaje en motocicleta. El costo es fijo y es de 19.99 unidades monetarias.
     *
     * @return El costo del viaje, que es de 19.99 unidades monetarias.
     */
    @Override
    public double costoViaje() {
        return 19.99;
    }

    /**
     * Determina si el cliente requiere que la motocicleta transite por una ruta de terracería.
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
     * Imprime un mensaje indicando si la motocicleta seguirá una ruta por terracería o carretera.
     */
    public void seguirRuta() {
        if (clienteRequiereTerraceria()) {
            System.out.println("Siguiendo la ruta por terracería.");
        } else {
            System.out.println("Siguiendo la ruta por carretera.");
        }
    }
}
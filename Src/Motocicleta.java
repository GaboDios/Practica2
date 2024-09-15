import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Motocicleta extends VehMos {
    public Motocicleta() {
        super(15,0.04); // 15 litros de combustible y consume 0.04 litros por KM
        setDescripcion("Motocicleta");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para la motocicleta...");
        // Lógica para recargar gasolina
        setCantidadCombustible(15); // Restablece el combustible a 100 después de recargar
    }

    @Override
    public double costoViaje() {
        return 19.99;
    }

    @Override
    public boolean clienteRequiereTerraceria() {
        String respuesta = getUserInput();
        return respuesta.toLowerCase().startsWith("s");
    }

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
    public void seguirRuta() {
        if (clienteRequiereTerraceria()) {
            System.out.println("Siguiendo la ruta por terracería.");
        } else {
            System.out.println("Siguiendo la ruta por carretera.");
        }
    }
}
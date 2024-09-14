import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scooter extends VehMos {
    public Scooter() {
        super();
        setDescripcion("Scooter para carretera y terracería");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para la scooter...");
        setCantidadCombustible(100);
    }

    @Override
    public void costoViaje() {
        System.out.println("El costo del viaje en scooter es de 10 pesos.");
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
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Autobus extends VehMos {
    public Autobus() {
        super();
        setDescripcion("Autobús para carretera");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para el autobús...");
        setCantidadCombustible(100);
    }

    @Override
    public void costoViaje() {
        System.out.println("El costo del viaje en autobús es de 50 pesos.");
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

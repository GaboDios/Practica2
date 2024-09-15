import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scooter extends VehMos {
    public Scooter() {
        super(8,0.033);// 8 litros de combustible y consume 0.033 litros por KM
        setDescripcion("Scooter");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para la scooter...");
        setCantidadCombustible(8);
    }

    @Override
    public double costoViaje() {
        return 9.99;
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

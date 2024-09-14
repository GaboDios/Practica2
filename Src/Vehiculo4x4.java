import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vehiculo4x4 extends VehMos {
    public Vehiculo4x4() {
        super();
        setDescripcion("Vehículo 4x4 para terracería");
    }

    @Override
    public void recargarCombustible() {
        System.out.println("Recargando gasolina para el vehículo 4x4...");
        setCantidadCombustible(100);
    }

    @Override
    public void costoViaje() {
        System.out.println("El costo del viaje en vehículo 4x4 es de 40 pesos.");
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

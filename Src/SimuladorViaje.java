import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SimuladorViaje {

    private static VehMos vehiculoSeleccionado;
    private static TuningCollection tuningCollection;
    private static ZMVM zona;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        zona = new ZMVM();
        tuningCollection = new TuningCollection();

        // 1. Selección de Vehículo
        seleccionarVehiculo(scanner);

        // 2. Modificación del Vehículo
        modificarVehiculo(scanner);

        // 3. Selección de Destino
        Coordenadas destino = seleccionarDestino(scanner);

        // 4. Simulación del Viaje
        simularViaje(destino);

        scanner.close();
    }

    // Método para seleccionar el vehículo
    public static void seleccionarVehiculo(Scanner scanner) {
        System.out.println("Seleccione su vehículo:");
        System.out.println("1. Carro");
        System.out.println("2. Motocicleta");
        System.out.println("3. Vehículo 4x4");
        System.out.println("4. Autobús");
        System.out.println("5. Scooter");

        int seleccion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        switch (seleccion) {
            case 1:
                vehiculoSeleccionado = new Carro();
                break;
            case 2:
                vehiculoSeleccionado = new Motocicleta();
                break;
            case 3:
                vehiculoSeleccionado = new Vehiculo4x4();
                break;
            case 4:
                vehiculoSeleccionado = new Autobus();
                break;
            case 5:
                vehiculoSeleccionado = new Scooter();
                break;
            default:
                System.out.println("Selección no válida, se selecciona por defecto un Carro.");
                vehiculoSeleccionado = new Carro();
        }
        System.out.println("Has seleccionado: " + vehiculoSeleccionado.getDescripcion());
    }

    // Método para modificar el vehículo
    public static void modificarVehiculo(Scanner scanner) {
        System.out.println("¿Desea modificar su vehículo con aditamentos? (s/n)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Seleccione los aditamentos para su vehículo. Puede seleccionar hasta 6.");
            System.out.println("1. Faros de Niebla");
            System.out.println("2. Vidrios Polarizados");
            System.out.println("3. Alerón");
            System.out.println("4. Mega Suspensión");
            System.out.println("5. Sirena");
            System.out.println("6. Portavasos");

            for (int i = 0; i < 6; i++) {
                System.out.print("Seleccione el número del aditamento (0 para terminar): ");
                int seleccion = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea

                if (seleccion == 0) {
                    break;
                }

                switch (seleccion) {
                    case 1:
                        vehiculoSeleccionado = new FarosDeNiebla(vehiculoSeleccionado);
                        break;
                    case 2:
                        vehiculoSeleccionado = new VidriosPolarizados(vehiculoSeleccionado);
                        break;
                    case 3:
                        vehiculoSeleccionado = new Aleron(vehiculoSeleccionado);
                        break;
                    case 4:
                        vehiculoSeleccionado = new MegaSuspencion(vehiculoSeleccionado);
                        break;
                    case 5:
                        vehiculoSeleccionado = new Sirena(vehiculoSeleccionado);
                        break;
                    case 6:
                        vehiculoSeleccionado = new Portavasos(vehiculoSeleccionado);
                        break;
                    default:
                        System.out.println("Aditamento no válido.");
                }
            }
        }
    }

    // Método para seleccionar el destino
    public static Coordenadas seleccionarDestino(Scanner scanner) {
        System.out.println("Seleccione uno de los puntos de interés:");

        zona.mostrarPuntosDeInteres();
        System.out.print("Ingrese el nombre del punto de interés: ");
        String seleccion = scanner.nextLine();

        Coordenadas destino = zona.obtenerCoordenadas(seleccion);
        if (destino == null) {
            System.out.println("Punto de interés no válido. Se selecciona el Zócalo de CDMX por defecto.");
            destino = new Coordenadas(19.432608, -99.133209);  // Coordenadas del Zócalo
        }
        return destino;
    }

    // Método para simular el viaje
    public static void simularViaje(Coordenadas destino) {
        System.out.println("Iniciando el viaje con el vehículo: " + vehiculoSeleccionado.getDescripcion());

        // Simular tiempo de viaje (ejemplo simple)
        double distancia = calcularDistancia(new Coordenadas(19.432608, -99.133209), destino);
        double tiempoDeViaje = distancia / 50;  // Asumiendo una velocidad promedio de 50 km/h
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("El tiempo estimado de llegada es: " + tiempoDeViaje + " horas");

        // Verificar si el vehículo se queda sin combustible (ejemplo simple)
        if (vehiculoSeleccionado.getCantidadCombustible() < distancia) {
            System.out.println("El vehículo se quedó sin combustible. Se realizará una parada para recargar.");
            // Aquí podrías implementar la lógica de recarga dependiendo del tipo de combustible
        } else {
            System.out.println("El vehículo ha completado el viaje sin problemas.");
        }
    }

    // Método para calcular la distancia entre dos puntos
    public static double calcularDistancia(Coordenadas origen, Coordenadas destino) {
        double latDiff = destino.getLatitud() - origen.getLatitud();
        double lonDiff = destino.getLongitud() - origen.getLongitud();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff) * 111;  // Aproximación para convertir grados en km
    }
}

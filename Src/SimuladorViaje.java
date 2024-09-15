import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase SimuladorViaje simula un viaje en un vehículo con múltiples opciones de personalización
 * y aditamentos. Los usuarios pueden seleccionar un vehículo, agregar modificaciones (tuning),
 * y elegir un destino de viaje. El programa simula el viaje, gestionando el combustible, la distancia,
 * y el estado del vehículo durante el trayecto.
 *
 * La clase también implementa una verificación de cliente por ID, el cálculo de distancia entre puntos
 * y la recarga de combustible si es necesario.
 *
 * El simulador sigue el patrón de diseño **State**, donde el comportamiento del vehículo cambia
 * dependiendo de su estado actual (En movimiento, En espera, Alerta de combustible, etc.).
 *
 * @author Los Hijos de Korhal
 */
public class SimuladorViaje {

    private static VehMos vehiculoSeleccionado;
    private static TuningCollection tuningCollection;
    private static ZMVM zona;
    private static int idCliente;

    /**
     * Método principal que inicia el simulador. Solicita al usuario su nombre, selecciona el vehículo,
     * permite modificarlo con aditamentos, elige un destino y simula el viaje.
     *
     * @param args Argumentos de línea de comando (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        zona = new ZMVM();
        tuningCollection = new TuningCollection();
        solicitarNombreCliente(scanner);

        // 1. Selección de Vehículo
        seleccionarVehiculo(scanner);

        // 2. Modificación del Vehículo
        modificarVehiculo(scanner);
        vehiculoSeleccionado.encenderVehiculo(true);
        vehiculoSeleccionado.getState();

        // 4. Selección de Destino
        Coordenadas destino = seleccionarDestino(scanner);

        // 5. Simulación del Viaje
        simularViaje(destino, scanner);

        scanner.close();
    }

    /**
     * Solicita el nombre del cliente y genera un ID aleatorio para el cliente.
     *
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
    public static void solicitarNombreCliente(Scanner scanner) {
        System.out.println("Por favor, ingrese su nombre:");
        String nombreCliente = scanner.nextLine();

        // Generar un ID aleatorio de 4 letras
        idCliente = generarIdAleatorio();

        System.out.println("Hola " + nombreCliente + ", tu ID de cliente es: " + idCliente);
    }

    /**
     * Genera un ID aleatorio de cliente de 4 dígitos.
     *
     * @return Un número aleatorio entre 1000 y 9999.
     */
    public static int generarIdAleatorio() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);  // Genera un número entre 1000 y 9999
    }

    /**
     * Permite al usuario seleccionar un vehículo de una lista de opciones predefinidas.
     * Si la selección no es válida, se selecciona un carro por defecto.
     *
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
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
        System.out.println(vehiculoSeleccionado.getState());
        vehiculoSeleccionado.getState();
    }

    /**
     * Permite al usuario modificar su vehículo con hasta 6 aditamentos.
     * Los aditamentos modifican el comportamiento o la descripción del vehículo seleccionado.
     *
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
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
            System.out.println("7. Aromatizador");
            System.out.println("8. Asientos de Leopardo");
            System.out.println("9. Dados de Peluche");
            System.out.println("10. Luces Led");
            System.out.println("11. Sonido Premium");
            System.out.println("12. TV");

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
                    case 7:
                        vehiculoSeleccionado = new Aromatizador(vehiculoSeleccionado);
                        break;
                    case 8:
                        vehiculoSeleccionado = new AsientosDeLeopardo(vehiculoSeleccionado);
                        break;
                    case 9:
                        vehiculoSeleccionado = new DadosDePeluche(vehiculoSeleccionado);
                        break;
                    case 10:
                        vehiculoSeleccionado = new LucesLed(vehiculoSeleccionado);
                        break;
                    case 11:
                        vehiculoSeleccionado = new SonidoPremium(vehiculoSeleccionado);
                        break;
                    case 12:
                        vehiculoSeleccionado = new Tv(vehiculoSeleccionado);
                    default:
                        System.out.println("Aditamento no válido.");
                }
                System.out.println(vehiculoSeleccionado.getState());
                vehiculoSeleccionado.getState();
            }
        }
    }

    /**
     * Permite al usuario seleccionar un destino de una lista de puntos de interés.
     * Los destinos se muestran por nombre, y se obtiene las coordenadas del destino seleccionado.
     *
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     * @return Las coordenadas del destino seleccionado.
     */
    public static Coordenadas seleccionarDestino(Scanner scanner) {
        System.out.println("Seleccione uno de los puntos de interés:");

        // Mostrar la lista de puntos de interés sin mostrar las coordenadas
        List<String> destinos = new ArrayList<>(zona.getPuntosDeInteres().keySet());

        for (int i = 0; i < destinos.size(); i++) {
            System.out.println((i + 1) + ". " + destinos.get(i));
        }

        int seleccion = 0;
        do {
            System.out.print("Ingrese el número del destino: ");
            seleccion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea
            if (seleccion < 1 || seleccion > destinos.size()) {
                System.out.println("Selección no válida, intente de nuevo.");
            }
        } while (seleccion < 1 || seleccion > destinos.size());

        String destinoSeleccionado = destinos.get(seleccion - 1);
        return zona.obtenerCoordenadas(destinoSeleccionado);  // Obtener las coordenadas del destino seleccionado
    }


    /**
     * Simula el viaje desde el origen hasta el destino seleccionado. Gestiona el estado del vehículo
     * durante el viaje, verifica si el cliente ingresó correctamente su ID, y gestiona el consumo
     * de combustible y la recarga si es necesario.
     *
     * @param destino Las coordenadas del destino del viaje.
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
    public static void simularViaje(Coordenadas destino, Scanner scanner) {
        vehiculoSeleccionado.setIdClienteActual(idCliente);
        System.out.println("Por favor, ingrese nuevamente su ID de cliente para iniciar el viaje:");
        int idIngresado = scanner.nextInt();
        scanner.nextLine();

        if (vehiculoSeleccionado.verificarIdCliente(idIngresado)) {
            System.out.println("ID verificado correctamente. Iniciando el viaje con el vehículo: " + vehiculoSeleccionado.getDescripcion());
            vehiculoSeleccionado.setState(vehiculoSeleccionado.getEnMovimiento());
            vehiculoSeleccionado.getState();
            // Simular tiempo de viaje (ejemplo simple)
            double distancia = calcularDistancia(new Coordenadas(19.432608, -99.133209), destino);
            double tiempoDeViaje = distancia / 50;  // Asumiendo una velocidad promedio de 50 km/h
            System.out.println("Distancia: " + distancia + " km");
            System.out.println("El tiempo estimado de llegada es: " + tiempoDeViaje + " horas");
            double distanciaRestante = distancia;

            while (distanciaRestante > 0) {
                double kmRestantes = vehiculoSeleccionado.calcularKmRestantes();

                if (kmRestantes <= 0) {
                    System.out.println("El vehículo se quedó sin combustible.");
                    vehiculoSeleccionado.setState(vehiculoSeleccionado.getAlertaDeCombustible());
                    vehiculoSeleccionado.getState();
                    vehiculoSeleccionado.recargarCombustible();
                }
                vehiculoSeleccionado.setState(vehiculoSeleccionado.getEnEspera());
                vehiculoSeleccionado.getState();
                // Calcular el tramo que se puede recorrer con el combustible disponible o hasta llegar al destino
                double tramo = Math.min(kmRestantes, distanciaRestante);
                vehiculoSeleccionado.setState(vehiculoSeleccionado.getEnMovimiento());
                vehiculoSeleccionado.consumirCombustible(tramo);   // Consumir el combustible necesario para el tramo
                distanciaRestante -= tramo;

                System.out.println("Avanzó " + tramo + " km. Distancia restante: " + distanciaRestante + " km.");

                if (distanciaRestante <= 0) {
                    System.out.println("El vehículo ha completado el viaje sin problemas.");
                    vehiculoSeleccionado.setState(vehiculoSeleccionado.getViajeFinalizado());
                    vehiculoSeleccionado.getState();
                }
            }
        } else {
            System.out.println("ID incorrecto. No se puede iniciar el viaje.");
        }
    }

    /**
     * Calcula la distancia entre dos puntos usando sus coordenadas.
     *
     * @param origen Las coordenadas de origen.
     * @param destino Las coordenadas de destino.
     * @return La distancia entre el origen y el destino en kilómetros.
     */
    public static double calcularDistancia(Coordenadas origen, Coordenadas destino) {
        double latDiff = destino.getLatitud() - origen.getLatitud();
        double lonDiff = destino.getLongitud() - origen.getLongitud();
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff) * 111;  // Aproximación para convertir grados en km
    }

    /**
     * Solicita al usuario su ID de cliente y lo registra en el vehículo seleccionado.
     *
     * @param scanner Objeto Scanner para leer la entrada del usuario.
     */
    public static void solicitarIdCliente(Scanner scanner) {
        System.out.println("Por favor, ingrese su ID de cliente:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        vehiculoSeleccionado.setIdClienteActual(idCliente);
        System.out.println("ID del cliente registrado.");
    }

}

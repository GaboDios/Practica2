import java.util.HashMap;
import java.util.Map;

public class ZMVM {
    // Mapa para almacenar puntos de interés y sus coordenadas
    private Map<String, Coordenadas> puntosDeInteres;

    // Constructor para inicializar los puntos de interés
    public ZMVM() {
        puntosDeInteres = new HashMap<>();
        cargarPuntosDeInteres();  // Cargar las ciudades y sus coordenadas
    }

    // Método para cargar las ciudades y sus coordenadas
    private void cargarPuntosDeInteres() {
        puntosDeInteres.put("Zócalo", new Coordenadas(19.432608, -99.133209));
        puntosDeInteres.put("Polanco", new Coordenadas(19.4325, -99.2005));
        puntosDeInteres.put("Xochimilco", new Coordenadas(19.2629, -99.1075));
        puntosDeInteres.put("Estadio Azteca", new Coordenadas(19.3029, -99.1505));
        puntosDeInteres.put("Torre Latino", new Coordenadas(19.4336, -99.1403));
        puntosDeInteres.put("Monumento a la Revolución", new Coordenadas(19.4360, -99.1530));
        puntosDeInteres.put("Auditorio Nacional", new Coordenadas(19.4255, -99.1919));
        puntosDeInteres.put("Cosmovitral", new Coordenadas(19.2882, -99.6677));
        puntosDeInteres.put("Pirámides de Teotihuacán", new Coordenadas(19.6928, -98.8435));
        puntosDeInteres.put("Tepotzotlán", new Coordenadas(19.7157, -99.2238));
        puntosDeInteres.put("Xochicalco", new Coordenadas(18.8089, -99.2819));
    }

    // Método para obtener las coordenadas de una ciudad por su nombre
    public Coordenadas obtenerCoordenadas(String ciudad) {
        return puntosDeInteres.get(ciudad);
    }

    // Método para obtener el mapa completo de puntos de interés (por si es necesario)
    public Map<String, Coordenadas> getPuntosDeInteres() {
        return puntosDeInteres;
    }
}

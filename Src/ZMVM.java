import java.util.HashMap;
import java.util.Map;

/**
 * La clase ZMVM representa una serie de puntos de interés en la Zona Metropolitana
 * del Valle de México. Permite almacenar y recuperar las coordenadas geográficas
 * de dichos puntos de interés mediante el uso de un mapa.
 *
 * La clase contiene un conjunto de ubicaciones predefinidas como el Zócalo, Polanco,
 * entre otros, y permite obtener las coordenadas de estos lugares.
 *
 * @author Los hijos de Korhal
 */
public class ZMVM {
    private Map<String, Coordenadas> puntosDeInteres;

    /**
     * Constructor que inicializa el mapa de puntos de interés y los carga
     * con sus respectivas coordenadas.
     */
    public ZMVM() {
        puntosDeInteres = new HashMap<>();
        cargarPuntosDeInteres();  // Cargar las ciudades y sus coordenadas
    }

    /**
     * Carga los puntos de interés en el mapa con sus respectivas coordenadas geográficas.
     * Este método es privado y se llama automáticamente durante la creación de la instancia
     * de la clase ZMVM.
     */
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

    /**
     * Obtiene las coordenadas de un punto de interes dado su nombre.
     *
     * @param ciudad El nombre de la ciudad o punto de interés cuyo par de coordenadas se desea obtener.
     * @return Las coordenadas de la ciudad si está en el mapa, o null si no se encuentra.
     */
    public Coordenadas obtenerCoordenadas(String ciudad) {
        return puntosDeInteres.get(ciudad);
    }

    /**
     * Devuelve el mapa completo de puntos de interés junto con sus coordenadas.
     * Esto puede ser útil si se desea obtener el conjunto completo de datos.
     *
     * @return Un mapa que contiene los nombres de los puntos de interés como claves y sus coordenadas como valores.
     */
    public Map<String, Coordenadas> getPuntosDeInteres() {
        return puntosDeInteres;
    }
}

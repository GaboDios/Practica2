/**
 * La clase Coordenadas representa una ubicación geográfica mediante valores de latitud y longitud.
 * Esta clase proporciona métodos para acceder a los valores de latitud y longitud, además de un
 * método `toString()` para presentar estos valores de forma legible.
 *
 * @author Los Hijos de Korhal
 */
public class Coordenadas {
    private double latitud;
    private double longitud;

    /**
     * Constructor que inicializa una instancia de Coordenadas con los valores de latitud y longitud especificados.
     *
     * @param latitud La latitud de la ubicación.
     * @param longitud La longitud de la ubicación.
     */
    public Coordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    /**
     * Devuelve la latitud de las coordenadas.
     *
     * @return La latitud de la ubicación.
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * Devuelve la longitud de las coordenadas.
     *
     * @return La longitud de la ubicación.
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Devuelve una representación en cadena de las coordenadas, mostrando la latitud y longitud.
     *
     * @return Una cadena de texto que muestra la latitud y la longitud en formato legible.
     */
    @Override
    public String toString() {
        return "Latitud: " + latitud + ", Longitud: " + longitud;
    }
}

import java.util.HashMap;
import java.util.Map;

public class ZMVM {
    private Map<String, Coordenadas> puntosDeInteres;

    public ZMVM() {
        puntosDeInteres = new HashMap<>();
        inicializarPuntosDeInteres();
    }

    private void inicializarPuntosDeInteres() {
        // Agregar las ciudades y sus coordenadas
        puntosDeInteres.put("Polanco", new Coordenadas(19.432608, -99.133209));
        puntosDeInteres.put("Xochimilco", new Coordenadas(19.257927, -99.104704));
        puntosDeInteres.put("Estadio Azteca", new Coordenadas(19.302861, -99.150528));
        puntosDeInteres.put("Torre Latino", new Coordenadas(19.433981, -99.140301));
        puntosDeInteres.put("Monumento a la Revolución", new Coordenadas(19.436111, -99.153056));
        puntosDeInteres.put("Auditorio Nacional", new Coordenadas(19.425342, -99.181890));
        puntosDeInteres.put("Cosmovitral en Toluca", new Coordenadas(19.285943, -99.664526));
        puntosDeInteres.put("Pirámides de Teotihuacan", new Coordenadas(19.692491, -98.843626));
        puntosDeInteres.put("Tepotzotlán", new Coordenadas(19.713163, -99.210484));
        puntosDeInteres.put("Zona Arqueológica de Xochicalco", new Coordenadas(18.808993, -99.284634));
    }

    public Coordenadas obtenerCoordenadas(String puntoDeInteres) {
        return puntosDeInteres.get(puntoDeInteres);
    }

    public void mostrarPuntosDeInteres() {
        for (String punto : puntosDeInteres.keySet()) {
            System.out.println(punto + ": " + puntosDeInteres.get(punto));
        }
    }

    // Método para obtener el mapa de puntos de interés
    public Map<String, Coordenadas> getPuntosDeInteres() {
        return puntosDeInteres;
    }
}

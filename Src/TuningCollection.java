import java.util.ArrayList;
import java.util.List;

/**
 * La clase TuningCollection actúa como una colección de objetos de tipo TunningDecorator,
 * permitiendo agregar elementos de tuning (mejoras) y crear un iterador para recorrerlos.
 *
 * Esta clase sigue el patrón de diseño **Iterator**, proporcionando un mecanismo para
 * gestionar una lista de mejoras y permitir la iteración sobre ella mediante un
 * `TuningIterator`.
 *
 * @author Los Hijos de Korhal
 */
public class TuningCollection {
    private List<TunningDecorator> tuningItems = new ArrayList<>();

    /**
     * Añade un objeto TunningDecorator a la colección de mejoras del vehículo.
     *
     * @param item El elemento de tuning que se añadirá a la lista.
     */
    public void addTuningItem(TunningDecorator item) {
        tuningItems.add(item);
    }

    /**
     * Crea y devuelve un iterador de tipo TuningIterator para recorrer
     * los elementos de la colección.
     *
     * @return Un objeto TuningIterator que permite iterar sobre los objetos TunningDecorator en la colección.
     */
    public TuningIterator createIterator() {
        return new TuningIterator(tuningItems);
    }
}

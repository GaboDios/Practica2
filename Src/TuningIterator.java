import java.util.List;

/**
 * La clase TuningIterator implementa la interfaz Iterator y proporciona
 * un mecanismo para recorrer una colección de objetos de tipo TunningDecorator.
 *
 * Este iterador sigue el patrón de diseño Iterator, permitiendo recorrer
 * una lista de mejoras (tuning) aplicadas a un vehículo sin exponer su
 * representación interna.
 *
 * @param <TunningDecorator> El tipo de objetos que serán iterados.
 *
 * @author Los Hijos de Korhal
 */
public class TuningIterator implements Iterator<TunningDecorator> {
    private List<TunningDecorator> items;
    private int position = 0;

    /**
     * Constructor para inicializar el iterador con una lista de mejoras.
     *
     * @param items Una lista de objetos TunningDecorator que representan las mejoras del vehículo.
     */
    public TuningIterator(List<TunningDecorator> items) {
        this.items = items;
    }

    /**
     * Verifica si existe otro elemento en la lista de mejoras.
     *
     * @return true si hay más elementos por iterar, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    /**
     * Devuelve el siguiente elemento en la lista de mejoras si existe.
     * Si no hay más elementos, devuelve null.
     *
     * @return El siguiente objeto de tipo TunningDecorator o null si no hay más elementos.
     */
    @Override
    public TunningDecorator next() {
        if (this.hasNext()) {
            return items.get(position++);
        }
        return null;
    }
}

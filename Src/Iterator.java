/**
 * La interfaz Iterator define los métodos esenciales para iterar sobre una colección de elementos.
 * Este patrón de diseño proporciona una forma uniforme de recorrer una colección sin exponer
 * su implementación interna.
 *
 * Esta interfaz es genérica y puede ser implementada para cualquier tipo de objeto.
 *
 * @param <T> El tipo de elementos que se iterarán.
 *
 * @author Los Hijos de Korhal
 */
public interface Iterator<T> {
    /**
     * Verifica si hay más elementos en la colección que se está iterando.
     *
     * @return true si hay más elementos por iterar, false en caso contrario.
     */
    boolean hasNext();
    /**
     * Devuelve el siguiente elemento en la iteración.
     *
     * @return El siguiente elemento en la colección.
     * @throws NoSuchElementException si no hay más elementos en la colección.
     */
    T next();
}

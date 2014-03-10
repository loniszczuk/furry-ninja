package ar.com.fn.storage;

import java.util.Collection;

/**
 * Basic Handlers operations
 */
public interface IdentificableHandler<T extends Identificable> {
    public T get(String id);

    public Collection<T> getAll();
    
    public String add(T t);

    public void save(T t);

    public void remove(String id);

    public void removeAll();
}

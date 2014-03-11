package ar.com.fn.domain.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static ch.lambdaj.Lambda.*;

import ar.com.fn.utils.IdGenerator;

/**
 * @author jformoso
 */
public class MemoryHandler<T extends Identificable> implements IdentificableHandler<T> {

	private Map<String, T> db = new HashMap<>();

	@Override
	public T get(String id) {
		return db.get(id);
	}

	@Override
	public Collection<T> getAll() {
		return db.values();
	}

	@Override
	public String add(T t) {
		save(t);
		return t.getId();
	}

	@Override
	public void save(T t) {
		if (t.getId() == null) {
			t.setId(IdGenerator.generate());
		}
		
		db.put(t.getId(), t);
	}

	@Override
	public void remove(String id) {
		db.remove(id);
	}

	@Override
	public void removeAll() {
		db.clear();
	}
	
	// tech specific methods (must be implemented again in different kind of handlers)
	public Collection<T> getAll(org.hamcrest.Matcher<?> matcher) {
		return filter(matcher, this.db.values());
	}
}

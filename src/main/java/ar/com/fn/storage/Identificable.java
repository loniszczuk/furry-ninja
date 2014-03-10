package ar.com.fn.storage;

import java.io.Serializable;

/**
 * @author jformoso
 */
public abstract class Identificable
    implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

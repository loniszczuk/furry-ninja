package ar.com.fn.match;

import ar.com.fn.storage.Identificable;

public abstract class Match extends Identificable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2115796460026721697L;

	protected Match() {
        Matches.instance().registerMatch(this);
    }

    public abstract State getCurrentState();
}

package ar.com.fn.domain.match;

import ar.com.fn.domain.storage.Identificable;

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

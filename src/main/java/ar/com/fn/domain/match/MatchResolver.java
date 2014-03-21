package ar.com.fn.domain.match;

import ar.com.fn.domain.storage.Identificable;

public abstract class MatchResolver extends Identificable {

	private static final long serialVersionUID = -2115796460026721697L;

    public abstract Match getMatch();
}

package ar.com.fn.utils;

import java.util.Iterator;

public class RingIterator<T> implements Iterator<T>, Iterable<T> {

    private Iterable<T> iterable;
    private Iterator<T> current;
    private boolean hasNext;

    public RingIterator(Iterable<T> iterable) {
        this.iterable = iterable;
        this.current = this.iterable.iterator();
        this.hasNext = this.current.hasNext();
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }


    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public T next() {
        if (!this.current.hasNext()) {
            this.current = this.iterable.iterator();
        }
        return this.current.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("not remove");
    }
}

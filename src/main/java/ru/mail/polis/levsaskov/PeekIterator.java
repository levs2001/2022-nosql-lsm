package ru.mail.polis.levsaskov;

import java.util.Iterator;

public class PeekIterator<E> implements Iterator<E> {
    private final Iterator<E> delegate;
    private E current = null;

    public PeekIterator(Iterator<E> delegate) {
        this.delegate = delegate;
    }

    public E peek() {
        if (current == null) {
            current = delegate.next();
        }
        return current;
    }

    @Override
    public boolean hasNext() {
        return current != null || delegate.hasNext();
    }

    @Override
    public E next() {
        E peek = peek();
        current = null;
        return peek;
    }
}

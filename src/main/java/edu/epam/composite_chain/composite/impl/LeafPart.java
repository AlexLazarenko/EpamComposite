package edu.epam.composite_chain.composite.impl;

import edu.epam.composite_chain.composite.IPart;

import java.util.Iterator;

public class LeafPart implements IPart {

    String str;

    public LeafPart(String str) {
        this.str = str;
    }

    @Override
    public void addElement(IPart part) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(IPart part) {
        throw new UnsupportedOperationException();

    }

    @Override
    public IPart getElement(int index) {
        return this;
    }

    @Override
    public void parse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<IPart> getIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return str;
    }
}

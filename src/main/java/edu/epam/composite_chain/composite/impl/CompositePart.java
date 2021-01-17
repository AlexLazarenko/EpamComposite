package edu.epam.composite_chain.composite.impl;

import edu.epam.composite_chain.composite.IPart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositePart implements IPart {
    private List<IPart> partList = new ArrayList<IPart>();

    public CompositePart() {
    }

    @Override
    public void addElement(IPart part) {
        partList.add(part);
    }

    @Override
    public void removeElement(IPart part) {
        partList.remove(part);
    }

    @Override
    public IPart getElement(int index) {
        return partList.get(index);
    }

    @Override
    public void parse() {
    }

    @Override
    public Iterator<IPart> getIterator() {
        return partList.iterator();
    }

    @Override
    public int getSize() {
        return partList.size();
    }

}

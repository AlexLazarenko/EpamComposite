package edu.epam.composite_chain.composite;

import java.util.Iterator;

public interface IPart {

    void addElement(IPart part);

    void removeElement(IPart part);

    IPart getElement(int index);

    void parse();

    Iterator<IPart> getIterator();

    int getSize();
}


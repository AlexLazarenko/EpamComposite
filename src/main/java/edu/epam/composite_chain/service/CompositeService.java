package edu.epam.composite_chain.service;


import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;

public class CompositeService {
    private static final Logger logger = LogManager.getLogger(CompositeService.class);
    public String restoreText(CompositePart text) {
        Iterator<IPart> paragraphIterator = text.getIterator();
        Iterator<IPart> sentenseIterator = null;
        Iterator<IPart> wordIterator = null;
        Iterator<IPart> symbolIterator = null;
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        while (paragraphIterator.hasNext()) {
            sentenseIterator = paragraphIterator.next().getIterator();
            while (sentenseIterator.hasNext()) {
                wordIterator = sentenseIterator.next().getIterator();
                while (wordIterator.hasNext()) {
                    symbolIterator = wordIterator.next().getIterator();
                    while (symbolIterator.hasNext()) {
                        stringBuilder.append(symbolIterator.next().getElement(counter));
                        counter++;
                    }
                }
            }
        }logger.info("text restored"+stringBuilder.toString());
        return stringBuilder.toString();
    }
}

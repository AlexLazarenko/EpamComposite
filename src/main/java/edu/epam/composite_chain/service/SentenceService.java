package edu.epam.composite_chain.service;

import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SentenceService {

    public CompositePart deleteSentenceByWordsQuantity(CompositePart text, int wordQuantity) {
        Iterator<IPart> paragraphIterator = text.getIterator();
        Iterator<IPart> sentenseIterator = null;
        int counterSentence = 0;
        while (paragraphIterator.hasNext()) {
            sentenseIterator = paragraphIterator.next().getIterator();
            while (sentenseIterator.hasNext()) {
                if (sentenseIterator.next().getSize() < wordQuantity) {
                    sentenseIterator.remove();
                }
            }
        }
        return text;
    }

}

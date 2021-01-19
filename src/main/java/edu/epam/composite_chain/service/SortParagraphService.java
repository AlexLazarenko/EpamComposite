package edu.epam.composite_chain.service;

import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortParagraphService {
    private static final Logger logger = LogManager.getLogger(SortParagraphService.class);

    private Map<Integer, Integer> countSentenceInParagraph(CompositePart text) {
        Map<Integer, Integer> countSentenceInParagraph = new HashMap<>();
        Iterator<IPart> paragraphIterator = text.getIterator();
        int counterParagraph = 0;
        while (paragraphIterator.hasNext()) {
            countSentenceInParagraph.put(counterParagraph, paragraphIterator.next().getSize());
            counterParagraph++;
        }
        return countSentenceInParagraph;
    }

    private Map<Integer, Integer> sortHashMap(Map<Integer, Integer> countedSentence) {
        Map<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
        countedSentence.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .forEach(n -> sortedHashMap.put(n.getKey(), n.getValue()));
        return sortedHashMap;
    }

    public CompositePart sortParagraphBySentence(CompositePart text) {
        Map<Integer, Integer> sortedHashMap = sortHashMap(countSentenceInParagraph(text));
        CompositePart sortedText = new CompositePart();
        for (Map.Entry<Integer, Integer> pair : sortedHashMap.entrySet()) {
            sortedText.addElement(text.getElement(pair.getKey()));
        }
        logger.info("paragraph sorted");
        return sortedText;
    }
}

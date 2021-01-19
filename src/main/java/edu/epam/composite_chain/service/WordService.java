package edu.epam.composite_chain.service;

import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordService {
    private static final Logger logger = LogManager.getLogger(WordService.class);

    public Map<String, Integer> searchSameWords(CompositePart text) {
        String allSymbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMёйцукенгшщзхъфывапролджэячсмитьбюЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
        Map<String, Integer> countWords = new HashMap<>();
        Iterator<IPart> paragraphIterator = text.getIterator();
        Iterator<IPart> sentenseIterator = null;
        Iterator<IPart> wordIterator = null;
        Iterator<IPart> symbolIterator = null;
        StringBuilder stringBuilder = new StringBuilder();
        String symbol;
        String word;
        int storeValue;
        int counter = 0;
        while (paragraphIterator.hasNext()) {
            sentenseIterator = paragraphIterator.next().getIterator();
            while (sentenseIterator.hasNext()) {
                wordIterator = sentenseIterator.next().getIterator();
                while (wordIterator.hasNext()) {
                    symbolIterator = wordIterator.next().getIterator();
                    while (symbolIterator.hasNext()) {
                        symbol = symbolIterator.next().getElement(counter).toString();
                        if (allSymbols.contains(symbol)) {
                            stringBuilder.append(symbol);
                            counter++;
                        }
                    }
                    word = stringBuilder.toString();
                    word = word.toLowerCase();
                    if (countWords.containsKey(word)) {
                        storeValue = countWords.get(word);
                        storeValue++;
                        countWords.put(word, storeValue);
                    } else {
                        countWords.put(word, 1);
                    }
                    stringBuilder.delete(0, stringBuilder.capacity());
                }
            }
        }
        logger.info("same words was found");
        return countWords;
    }

    public Map<String, Integer> searchLengthWords(CompositePart text) {
        Map<String, Integer> sameWords = searchSameWords(text);
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> pair : sameWords.entrySet()) {
            map.put(pair.getKey(), pair.getKey().length());
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(n -> sortedHashMap.put(n.getKey(), n.getValue()));
        logger.info("length of words was found");
        return sortedHashMap;
    }
}

package edu.epam.composite_chain.service;

import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LetterService {
    private static final Logger logger = LogManager.getLogger(LetterService.class);
    private final String CONSONANTS = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZzйЙцЦкКнНгГшШщЩзЗхХфФвВпПрРлЛдДжЖчЧсСмМтТбБ";
    private final String VOWELS = "AaEeYyUuIiOoёЁеЕыЫаАоОэЭУуяЯиИюЮ";

    public Map<String, Integer> countLetters(CompositePart text) {
        Iterator<IPart> paragraphIterator = text.getIterator();
        Iterator<IPart> sentenseIterator = null;
        Iterator<IPart> wordIterator = null;
        Iterator<IPart> symbolIterator = null;
        Map<String, Integer> countLetters = new HashMap<>();
        String store = "";
        String consonant="consonant";
        String vowels="vowels";
        int storeValue;
        int counter = 0;
        while (paragraphIterator.hasNext()) {
            sentenseIterator = paragraphIterator.next().getIterator();
            while (sentenseIterator.hasNext()) {
                wordIterator = sentenseIterator.next().getIterator();
                while (wordIterator.hasNext()) {
                    symbolIterator = wordIterator.next().getIterator();
                    while (symbolIterator.hasNext()) {
                        store = symbolIterator.next().getElement(counter).toString();
                        if (isConsonant(store)) {
                            if (countLetters.containsKey(consonant)) {
                                storeValue = countLetters.get(consonant);
                                storeValue++;
                                countLetters.put(consonant, storeValue);
                            } else {
                                countLetters.put(consonant, 1);
                            }
                        }
                        if (isVowel(store)) {
                            if (countLetters.containsKey(vowels)) {
                                storeValue = countLetters.get(vowels);
                                storeValue++;
                                countLetters.put(vowels, storeValue);
                            } else {
                                countLetters.put(vowels, 1);
                            }
                            counter++;
                        }
                    }
                }
            }
        }logger.info("letters is "+countLetters.toString());
        return countLetters;
    }

    private boolean isConsonant(String s) {
        return CONSONANTS.contains(s);
    }

    private boolean isVowel(String s) {
        return VOWELS.contains(s);
    }
}
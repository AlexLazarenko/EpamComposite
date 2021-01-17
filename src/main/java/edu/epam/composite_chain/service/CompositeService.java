package edu.epam.composite_chain.service;

import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.exception.ParserException;

import java.util.HashMap;
import java.util.Iterator;

public class CompositeService {
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
                    while (symbolIterator.hasNext())
                        stringBuilder.append(symbolIterator.next().getElement(counter));
                    counter++;
                }
            }
        }
        return stringBuilder.toString();
    }

    public int countSentenceInParagraph(CompositePart text) {
        HashMap<Integer,Integer> countSentenceInParagraph=new HashMap<>();
        Iterator<IPart> paragraphIterator = text.getIterator();
        Iterator<IPart> sentenseIterator = null;
        Iterator<IPart> wordIterator = null;
        int counterParagraph = 0;
        int counterSentence=0;
        while (paragraphIterator.hasNext()) {
            sentenseIterator = paragraphIterator.next().getIterator();
          //  System.out.println(paragraphIterator.next());
            paragraphIterator.next();
            counterParagraph++;
        /*    while (sentenseIterator.hasNext()) {
                wordIterator = sentenseIterator.next().getIterator();
               System.out.println(sentenseIterator.next());
                sentenseIterator.next();
                counterSentence++;*/
             /*   while (wordIterator.hasNext()) {
                    wordIterator.next();
                    counter++;
                }*/
            }return counterSentence;
        }

    }


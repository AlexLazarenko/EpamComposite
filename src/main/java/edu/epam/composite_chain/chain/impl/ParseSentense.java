package edu.epam.composite_chain.chain.impl;

import edu.epam.composite_chain.chain.BaseInterface;

import edu.epam.composite_chain.composite.impl.CompositePart;

import edu.epam.composite_chain.exception.ParserException;


public class ParseSentense implements BaseInterface {
    private ParseParagraph parent = null;

    public ParseSentense(ParseParagraph parent) {
        this.parent = parent;
    }

    @Override
    public CompositePart handleRequest(String paragraph) throws ParserException {
        if (parent == null) {
            throw new ParserException();
        } else {
            // parse to sentence
            CompositePart sentenceList = new CompositePart();
            for (String sentence:paragraph.split(BaseInterface.REGEX_SENTENCE)) {
                sentenceList.addElement(new ParseSignAndWord(this).handleRequest(sentence));
            }
            return sentenceList;
        }
    }
}

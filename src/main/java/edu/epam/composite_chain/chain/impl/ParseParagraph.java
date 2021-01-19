package edu.epam.composite_chain.chain.impl;

import edu.epam.composite_chain.chain.BaseInterface;

import edu.epam.composite_chain.composite.impl.CompositePart;

import edu.epam.composite_chain.exception.ParserException;


public class ParseParagraph implements BaseInterface {
    private String text;

    public ParseParagraph(String text) {
        this.text = text;
    }

    @Override
    public CompositePart handleRequest(String text) throws ParserException {
        CompositePart paragraphList = new CompositePart();
        for (String paragraph : text.split(REGEX_PARAGRAPH)) {
            paragraphList.addElement(new ParseSentense(this).handleRequest(paragraph));
        }
        return paragraphList;
    }
}



package edu.epam.composite_chain.chain.impl;

import edu.epam.composite_chain.chain.BaseInterface;
import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.composite.impl.LeafPart;
import edu.epam.composite_chain.exception.ParserException;
import edu.epam.composite_chain.reader.TextFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseParagraph implements BaseInterface {
    private String text ;

    public ParseParagraph(String text) {
        this.text = text;
    }

    @Override
    public CompositePart handleRequest(String text) throws ParserException {
        CompositePart paragraphList = new CompositePart();
        for (String paragraph:text.split(REGEX_PARAGRAPH)) {
            paragraphList.addElement(new ParseSentense(this).handleRequest(paragraph));
        }
        return paragraphList;
    }
}



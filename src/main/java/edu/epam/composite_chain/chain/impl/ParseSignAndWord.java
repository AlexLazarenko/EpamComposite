package edu.epam.composite_chain.chain.impl;

import edu.epam.composite_chain.chain.BaseInterface;
import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.composite.impl.LeafPart;
import edu.epam.composite_chain.exception.ParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSignAndWord implements BaseInterface {
    private ParseSentense parent = null;

    public ParseSignAndWord(ParseSentense parent) {
        this.parent = parent;
    }

    @Override
    public CompositePart handleRequest(String word) throws ParserException {
        if (parent == null) {
            throw new ParserException();
        } else {
            Pattern pattern = Pattern.compile(BaseInterface.REGEX_WORD_AND_SIGN);
            String wordSign = "";
            Matcher matcher = pattern.matcher(word);
            CompositePart wordSignList = new CompositePart();
            while (matcher.find()) {
                wordSign = matcher.group();
                wordSignList.addElement(new ParseSymbol(this).handleRequest(wordSign));
            }
            return wordSignList;
        }
    }
}


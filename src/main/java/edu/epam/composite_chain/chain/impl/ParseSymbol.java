package edu.epam.composite_chain.chain.impl;

import edu.epam.composite_chain.chain.BaseInterface;
import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.composite.impl.LeafPart;
import edu.epam.composite_chain.exception.ParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseSymbol implements BaseInterface {
    private ParseSignAndWord parent = null;

    public ParseSymbol(ParseSignAndWord parent) {
        this.parent = parent;
    }

    @Override
    public CompositePart handleRequest(String wordSign) throws ParserException {
        CompositePart symbolList = new CompositePart();
        if (parent == null) {
            throw new ParserException();
        } else {
            for (String symbol:wordSign.split(BaseInterface.REGEX_SYMBOL)) {
                symbolList.addElement(new LeafPart(symbol));
            }
                }return symbolList;
            }
        }




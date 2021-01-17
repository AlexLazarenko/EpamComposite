package edu.epam.composite_chain.chain;

import edu.epam.composite_chain.composite.IPart;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.exception.ParserException;

import java.util.List;

public interface BaseInterface {
    CompositePart handleRequest(String text) throws ParserException;

    String REGEX_PARAGRAPH = "\\s{4}";
    String REGEX_SENTENCE = "(?<=[!|?|.{1-3}]\\s)";
    String REGEX_WORD_AND_SIGN = "\\s+\\S+[^\\s]+";
    String REGEX_SYMBOL = "";
 //   "\\s{3}[^\\t]+";\r\f\n /^\s*$/   "\\s+[^[\\.+\\s]]|[^[!\\s]]|[^[\\?\\s]]+";    "(?<=[!|?|.{1-3}]\\s)";
}

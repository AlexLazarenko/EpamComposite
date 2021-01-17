package edu.epam.composite_chain;

import edu.epam.composite_chain.chain.impl.*;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.exception.ParserException;
import edu.epam.composite_chain.reader.TextFileReader;
import edu.epam.composite_chain.service.CompositeService;


public class Main {
    public static void main(String[] args) {
        String dir = "file.dir";
        TextFileReader reader = new TextFileReader();
        String inFileText = reader.initialization(dir);
        ParseParagraph parseParagraph = new ParseParagraph(inFileText);
        CompositePart wholeText = new CompositePart();
        CompositeService service = new CompositeService();
        try {
            wholeText = parseParagraph.handleRequest(inFileText);
      //      System.out.println(service.restoreText(wholeText));
            System.out.println(service.countSentenceInParagraph(wholeText));
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}


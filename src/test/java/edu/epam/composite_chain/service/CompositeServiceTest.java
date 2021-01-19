package edu.epam.composite_chain.service;

import edu.epam.composite_chain.chain.impl.ParseParagraph;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.exception.ParserException;
import edu.epam.composite_chain.reader.TextFileReader;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeServiceTest {

    @Test
    public void testRestoreText() {
        String dir = "testFile.dir";
        TextFileReader textFileReader=new TextFileReader();
        String actual ="";
        String expected= textFileReader.initialization(dir);
        ParseParagraph parseParagraph = new ParseParagraph(expected);
        CompositePart wholeText = new CompositePart();
        CompositeService compositeService=new CompositeService();
        try {
            wholeText = parseParagraph.handleRequest(expected);
            actual=compositeService.restoreText(wholeText);
            assertNotEquals(actual,expected);
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
package edu.epam.composite_chain.service;

import edu.epam.composite_chain.chain.impl.ParseParagraph;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.exception.ParserException;
import edu.epam.composite_chain.reader.TextFileReader;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class LetterServiceTest {

    @Test
    public void testCountLetters() {
        LetterService letterService=new LetterService();
        String dir = "testFile.dir";
        TextFileReader textFileReader=new TextFileReader();
        Map<String,Integer> actual ;
        String text= textFileReader.initialization(dir);
        ParseParagraph parseParagraph = new ParseParagraph(text);
        CompositePart wholeText = new CompositePart();
        Map<String,Integer> expected=new HashMap<>();
        expected.put("consonant",366);
        expected.put("vowels",241);
            try {
                wholeText = parseParagraph.handleRequest(text);
                actual=letterService.countLetters(wholeText);
                assertEquals(actual,expected);
            } catch (ParserException e) {
                e.printStackTrace();
            }
        }
}
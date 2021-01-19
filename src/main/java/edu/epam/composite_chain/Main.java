package edu.epam.composite_chain;

import edu.epam.composite_chain.chain.impl.*;
import edu.epam.composite_chain.composite.impl.CompositePart;
import edu.epam.composite_chain.exception.ParserException;
import edu.epam.composite_chain.reader.TextFileReader;
import edu.epam.composite_chain.service.*;


public class Main {
    public static void main(String[] args) {
        String dir = "file.dir";
        TextFileReader reader = new TextFileReader();
        String inFileText = reader.initialization(dir);
        ParseParagraph parseParagraph = new ParseParagraph(inFileText);
        CompositePart wholeText = new CompositePart();
        CompositePart sortedText = new CompositePart();
        CompositeService service = new CompositeService();
        SortParagraphService sortParagraphService=new SortParagraphService();
        LetterService letterService=new LetterService();
        WordService wordService=new WordService();
        SentenceService sentenceService=new SentenceService();
        try {
            wholeText = parseParagraph.handleRequest(inFileText);
      //      System.out.println(service.restoreText(wholeText));
      //     sortedText=sortParagraphService.sortParagraphBySentence(wholeText);
       //     System.out.println(service.restoreText(sortedText));
      //      System.out.println(letterService.countLetters(wholeText));
       //     System.out.println(wordService.searchSameWords(wholeText));
          //  System.out.println(service.restoreText(sentenceService.deleteSentenceByWordsQuantity(wholeText,16)));
         //   System.out.println(wordService.searchLengthWords(wholeText));
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}


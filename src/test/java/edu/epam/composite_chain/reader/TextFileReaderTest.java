package edu.epam.composite_chain.reader;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextFileReaderTest {

    @Test
    public void testInitialization() {
        String dir = "testFile.dir";
        TextFileReader textFileReader=new TextFileReader();
        String actual = textFileReader.initialization(dir);
        String expected="   It has survived - not only (five) centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)\n" +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\n" +
                "more recently with desktop publishing software like Aldus PageMaker Faclon9 including\n" +
                "versions of Lorem Ipsum!\n" +
                "\n" +
                "   It is a long a!=b established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\n" +
                "content here's, making it look like readable English?\n" +
                "\n" +
                "   It is a established fact that a reader will be of a page when looking at its layout...\n" +
                "\n" +
                "   Bye бандерлоги.";
        assertNotEquals(actual,expected);
    }
}
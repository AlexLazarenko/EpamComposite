package edu.epam.composite_chain.reader;

import edu.epam.composite_chain.utility.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
    private static final Logger logger = LogManager.getLogger(TextFileReader.class);

    public String initialization(String dir) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(PropertiesLoader.getProperty(dir));
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str); // String with all text
            // System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
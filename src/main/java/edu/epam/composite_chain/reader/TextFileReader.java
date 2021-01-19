package edu.epam.composite_chain.reader;

import edu.epam.composite_chain.utility.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class TextFileReader {
    private static final Logger logger = LogManager.getLogger(TextFileReader.class);

    public String initialization(String dir) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(PropertiesLoader.getProperty(dir));
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
        logger.info("text readed " + text);
        return text;
    }
}
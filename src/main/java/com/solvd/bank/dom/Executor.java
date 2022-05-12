package com.solvd.bank.dom;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Executor {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DomReader.readFromFile();
        DomWriter.writeToFile();
    }

}

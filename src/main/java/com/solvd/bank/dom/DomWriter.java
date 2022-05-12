package com.solvd.bank.dom;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriter {

    public static void writeToFile() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("class");
        doc.appendChild(rootElement);
        doc.createElement("bank");
        Element bank = doc.createElement("bank");
        rootElement.appendChild(bank);
        bank.setAttribute("id", "1");
        Element name = doc.createElement("name");
        name.setTextContent("Privatbank");
        bank.appendChild(name);
        Element phone = doc.createElement("phone");
        phone.setTextContent("0982383744");
        bank.appendChild(phone);

        Element bank2 = doc.createElement("bank");
        rootElement.appendChild(bank2);
        bank2.setAttribute("id", "2");
        Element name2 = doc.createElement("name");
        name2.setTextContent("Monobank");
        bank2.appendChild(name2);
        Element phone2 = doc.createElement("phone");
        phone2.setTextContent("0974329211");
        bank2.appendChild(phone2);

        Element bank3 = doc.createElement("bank");
        rootElement.appendChild(bank3);
        bank3.setAttribute("id", "3");
        Element name3 = doc.createElement("name");
        name3.setTextContent("Ukrbank");
        bank3.appendChild(name3);
        Element phone3 = doc.createElement("phone");
        phone3.setTextContent("0975683244");
        bank3.appendChild(phone3);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult("src/main/resources/to.xml");
        transformer.transform(source, result);
//        try (FileOutputStream output = new FileOutputStream("src/main/resources/to.xml")) {
//            writeXml(doc, output);
//        } catch (IOException | TransformerException e) {
//            e.printStackTrace();
//        }

    }

    private static void writeXml(Document doc,
                                 FileOutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}

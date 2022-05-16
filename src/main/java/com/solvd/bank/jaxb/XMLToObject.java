package com.solvd.bank.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

public class XMLToObject {

    private static final Logger LOGGER = LogManager.getLogger(XMLToObject.class);

    public static void xmlToObject() {
        try {
            File file = new File("src/main/resources/schedule.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Schedule.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Schedule  sch = (Schedule) jaxbUnmarshaller.unmarshal(file);
            LOGGER.info("id: "+sch.getId()+"  opening time: "+sch.getOpeningTime()+"  closing time: "
                    +sch.getClosingTime()+"  day: "+sch.getDay());

        } catch (JAXBException e) {e.printStackTrace(); }
    }
}

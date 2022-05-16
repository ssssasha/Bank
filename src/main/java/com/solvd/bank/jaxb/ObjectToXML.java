package com.solvd.bank.jaxb;

import java.io.File;
import java.io.FileOutputStream;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class ObjectToXML {
    public static void objectToXML() throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(Schedule.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Schedule schedule = new Schedule(1, "8:00", "17:00", "Monday");

        marshallerObj.marshal(schedule, new File("src/main/resources/scheduleResult.xml"));
    }
}

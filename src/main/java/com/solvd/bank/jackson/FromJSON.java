package com.solvd.bank.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bank.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FromJSON {
    private static final Logger LOGGER = LogManager.getLogger(FromJSON.class);

    public static void main(String[] args) {


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // JSON file to Java object
            File file = new File("src/main/resources/schedule.json");
            Schedule schedule = objectMapper.readValue(file, Schedule.class);

            // JSON string to Java object
            String jsonInString = "{\"id\":\"1\",\"openingTime\":\"8:30\",\"closingTime\":\"16:30\",\"day\":\"Monday\"}";
            Schedule schedule1 = objectMapper.readValue(jsonInString, Schedule.class);

            //LOGGER.info(schedule);
            // compact print
            //LOGGER.info(schedule1);

            // pretty print
            String prettySchedule1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(schedule);

            System.out.println(prettySchedule1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.solvd.bank.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bank.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class ToJSON {
    private static final Logger LOGGER = LogManager.getLogger(ToJSON.class);

    private static Schedule createSchedule() {
        Schedule schedule = new Schedule();
        schedule.setId(1);
        schedule.setOpeningTime("8:00");
        schedule.setClosingTime("18:00");
        schedule.setDay("Friday");
        return schedule;
    }

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Schedule schedule = createSchedule();

        try {

            // Java objects to JSON file
            mapper.writeValue(new File("src/main/resources/schedule.json"), schedule);

            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(schedule);

            LOGGER.info(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schedule);

            LOGGER.info(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

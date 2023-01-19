package co.com.bancolombia.certification.saf.utils.reader;


import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class PropertiesReaderJson {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReaderJson.class);

    private PropertiesReaderJson() {
        try {

            Object ob = new JSONParser().parse(new FileReader("src/test/resources/DataDriven/finance-charges.json"));
            JSONObject js = (JSONObject) ob;
            String firstName = (String) js.get("obligationIds");
            System.out.println("First name is: " + firstName);



        } catch (IOException | ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}

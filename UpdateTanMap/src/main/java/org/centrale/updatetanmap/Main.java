/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.updatetanmap;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 33671
 */
public class Main {

    public static void main(String[] argv) {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            ResourceBundle parameters = ResourceBundle.getBundle("org.centrale.updatetanmap.config");

            String url = parameters.getString("url");
            String name = parameters.getString("fileName");
            String path = parameters.getString("path");

            TanResponse tanResponse = objectMapper.readValue(new URL(url), TanResponse.class);
            int n = tanResponse.getRecords().length;
            ArrayList<BusLine> arrayBus = new ArrayList<>();
            String json = "";
            for (int i = 0; i < n; i++) {
                BusLine line = new BusLine(tanResponse.getRecords()[i]);
                arrayBus.add(line);
                json = new ObjectMapper().writeValueAsString(arrayBus);
            }
            objectMapper.writeValue(new File(path+name), json);
            

        } catch (MissingResourceException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

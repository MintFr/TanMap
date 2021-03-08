package org.centrale.mintservicetanmap;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 33671
 */
public class Main {

    public static void main(String[] argv) {
        DataTan dataTan = new DataTan();

        try {
            ResourceBundle parameters = ResourceBundle.getBundle("org.centrale.tanmap.config");

            String urlToSend = parameters.getString("url");
            String fileName = parameters.getString("fileName");
            String path = parameters.getString("path");

            dataTan.dlDataTan(urlToSend);
            JSONObject raw_data = new JSONObject(dataTan.getData());
            ArrayList<BusLine> plan = dataTan.readJSON(raw_data);


            dataTan.writeJSON(plan);
            dataTan.writeStream(path,fileName);

        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (JSONException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.mintservicetanmap;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class to download data from url
 *
 * @author 33671
 */
public class DataTan {

    private String data;
    private JSONArray result;

    public DataTan() {
        this.data = "";
        this.result = new JSONArray();
    }

    public DataTan(String data, JSONArray result) {
        this.data = data;
        this.result = new JSONArray(result);
    }

    public void setResult(JSONArray result) {
        this.result = new JSONArray(result);
    }

    public JSONArray getResult() {
        return result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * Download data from website and store it into a String
     *
     * @param urlToSend
     * @throws MalformedURLException
     * @throws IOException
     */
    public void dlDataTan(String urlToSend) throws MalformedURLException, IOException {

        URL url = new URL(urlToSend);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();//open

        InputStream in = new BufferedInputStream(urlCon.getInputStream());
        setData(readStream(in));
    }

    /**
     * Function to read a file
     *
     * @param is
     * @return
     * @throws IOException
     */
    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is), 1000);
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }

    /**
     *
     * @param json
     * @return
     */
    public ArrayList<BusLine> readJSON(JSONObject json) {
        JSONArray records = json.getJSONArray("records");
        ArrayList<BusLine> busLineArray = new ArrayList<>();

        for (int i = 0; i < records.length(); i++) {
            Record record = new Record(records.getJSONObject(i));
            BusLine busLine = new BusLine(record);
            busLineArray.add(busLine);
        }
        return busLineArray;
    }

    /**
     *
     * @param busline
     * @return
     */
    public JSONObject writeJSON(BusLine busline) {
        JSONObject res = new JSONObject();
        res.put("long_name", busline.getFullName());
        res.put("type", busline.getType());
        res.put("coordinates", busline.getCoordinates());
        res.put("color", busline.getColor());
        res.put("shortName", busline.getShortName());
        return res;
    }

    /**
     *
     * @param plan
     */
    public void writeJSON(ArrayList<BusLine> plan) {
        //this.result
        plan.forEach(line -> {
            this.result.put(writeJSON(line));
        });
    }

    public void writeStream(String path, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path+fileName));
        bufferedWriter.write(result.toString());

        bufferedWriter.flush();
        bufferedWriter.close();

    }
}

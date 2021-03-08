/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.mintservicetanmap;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class to store record (see json from url response) and contains method to 
 * transform to the new JSON format.
 * @author 33671
 */
public class Record {

    private String datasetId;
    private String recordId;
    private JSONObject fields;
    private JSONObject geometry;
    private String recordTimestamp;

    public Record() {
    }

    public Record(String datasetId, String recordId, JSONObject fields, JSONObject geometry, String recordTimestamp) {
        this.datasetId = datasetId;
        this.recordId = recordId;
        this.fields = fields;
        this.geometry = geometry;
        this.recordTimestamp = recordTimestamp;
    }

    public Record(Record record) {
        this.datasetId = record.getDatasetId();
        this.recordId = record.getRecordId();
        this.fields = record.getFields();
        this.geometry = record.getGeometry();
        this.recordTimestamp = record.getRecordTimestamp();
    }

    public Record(JSONObject record) {
        try {
            this.datasetId = record.getString("datasetid");
            this.recordId = record.getString("recordid");
            this.fields = record.getJSONObject("fields");
            this.geometry = record.getJSONObject("geometry");
            this.recordTimestamp = (String) record.get("record_timestamp");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getDatasetId() {
        return datasetId;
    }

    public String getRecordId() {
        return recordId;
    }

    public JSONObject getFields() {
        return fields;
    }

    public JSONObject getGeometry() {
        return geometry;
    }

    public String getRecordTimestamp() {
        return recordTimestamp;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setFields(JSONObject fields) {
        this.fields = fields;
    }

    public void setGeometry(JSONObject geometry) {
        this.geometry = geometry;
    }

    public void setRecordTimestamp(String recordTimestamps) {
        this.recordTimestamp = recordTimestamps;
    }

    public String getFullName() {
        Fields field = new Fields(this.fields);
        return field.getRouteLongName();
    }

    public String getType() {
        Fields field = new Fields(this.fields);
        return field.getRouteType();
    }

    public Shape getShape() {
        Fields field = new Fields(this.fields);
        Shape shape = new Shape(field.getShape());
        return shape;
    }

    public ArrayList<double[][]> getCoordinates() {
        ArrayList<double[][]> coord = new ArrayList<>();
        Shape shp = this.getShape();//tableau de routes
        for (int i = 0; i < shp.getCoordinates().length(); i++) {
            Coordinate coordinate = new Coordinate(shp.getCoordinates().getJSONArray(i));//tableau de points
            double[][] tempo = new double[coordinate.getPoints().length()][2];
            for (int j = 0; j < coordinate.getPoints().length(); j++) {
                Point point = new Point(coordinate.getPoints().getJSONArray(j));
                tempo[j][0] = point.getX();
                tempo[j][1] = point.getY();
            }
            coord.add(tempo);
        }
        return coord;
    }

    public String getColor() {
        Fields field = new Fields(this.fields);
        return field.getRouteColor();
    }

    public String getShortName() {
        Fields field = new Fields(this.fields);
        return field.getRouteShortName();
    }

}

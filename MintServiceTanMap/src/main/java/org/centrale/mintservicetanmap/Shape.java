/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.mintservicetanmap;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *See JSON from service response
 * @author 33671
 */
public class Shape {

    private String type;
    private JSONArray coordinates;

    public Shape() {
    }

    public Shape(String type, JSONArray coordinates) {
        this.type = type;
        this.coordinates = new JSONArray(coordinates);
    }
    
    public Shape(Shape shape){
        this.type = shape.getType();
        this.coordinates = new JSONArray(shape.getCoordinates());
    }
    
    public Shape(JSONObject json){
        this.type = json.getString("type");
        this.coordinates = json.getJSONArray("coordinates");
    }

    public String getType() {
        return type;
    }

    public JSONArray getCoordinates() {
        return coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinates(JSONArray coordinates) {
        this.coordinates = new JSONArray(coordinates);
 
    }

    @Override
    public String toString() {
        return "Shape{" + "type = " + type + ", coordinates = " + coordinates.toString() + '}';
    }
    
    

}

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
public class Coordinate {

    private JSONArray points;

    public Coordinate() {
    }

    public Coordinate(JSONArray route) {
        this.points = route;
    }

    public JSONArray getPoints() {
        return points;
    }

    public void setPoints(JSONArray route) {
        this.points = route;
    }
    
    

}

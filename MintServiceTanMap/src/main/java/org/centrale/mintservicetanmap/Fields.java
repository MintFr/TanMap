/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.mintservicetanmap;

import org.json.JSONObject;

/**
 * See JSON from service response
 * @author 33671
 */
public class Fields {

    private String routeLongName;
    private String routeType;
    private Object geoPoint2D;
    private String routeId;
    private JSONObject shape;
    private String routeColor;
    private String routeShortName;

    public Fields() {
    }

    public Fields(String routeLongName, String routeType, int[] geoPoint2D, String routeId, JSONObject shape, String routeColor, String routeShortName) {
        this.routeLongName = routeLongName;
        this.routeType = routeType;
        this.geoPoint2D = geoPoint2D;
        this.routeId = routeId;
        this.shape = shape;
        this.routeColor = routeColor;
        this.routeShortName = routeShortName;
    }

    public Fields(Fields fields) {
        this.routeLongName = fields.getRouteLongName();
        this.routeType = fields.getRouteType();
        this.geoPoint2D = fields.getGeoPoint2D();
        this.routeId = fields.getRouteId();
        this.shape = fields.getShape();
        this.routeColor = fields.getRouteColor();
        this.routeShortName = fields.getRouteShortName();
    }
    
    public Fields (JSONObject json){
        this.routeLongName =  json.getString("route_long_name");
        this.routeType =  json.getString("route_type");
        this.geoPoint2D = json.get("geo_point_2d");
        this.routeId =  json.getString("route_id");
        this.shape =  json.getJSONObject("shape");
        this.routeColor = json.getString("route_color");
        this.routeShortName = json.getString("route_short_name");
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public String getRouteType() {
        return routeType;
    }

    public Object getGeoPoint2D() {
        return geoPoint2D;
    }

    public String getRouteId() {
        return routeId;
    }

    public JSONObject getShape() {
        return shape;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public void setGeoPoint2D(int[] geoPoint2D) {
        this.geoPoint2D = geoPoint2D;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setShape(JSONObject shape) {
        this.shape = shape;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }
    
    
}

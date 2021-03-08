/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.updatetanmap;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 33671
 */
public class BusLine {

    private String fullName;
    private String type;
    private float[][][] coordinates;
    private String color;
    private String shortName;

    public BusLine() {
    }

    public BusLine(Record record) {
        this.fullName = record.getFields().getRoute_long_name();
        this.type = record.getFields().getRoute_type();
        this.coordinates = record.getFields().getShape().getCoordinates();
        this.color = record.getFields().getRoute_color();
        this.shortName = record.getFields().getRoute_short_name();
    }

    @JsonProperty
    public String getFullName() {
        return fullName;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public float[][][] getCoordinates() {
        return coordinates;
    }


    @JsonProperty
    public String getColor() {
        return color;
    }

    @JsonProperty
    public String getShortName() {
        return shortName;
    }

    @JsonProperty
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty
    public void setCoordinates(float[][][] coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.mintservicetanmap;

import java.util.ArrayList;

/**
 * Class to define format answer
 * @author 33671
 */
public class BusLine {

    private String fullName;
    private String type;
    ArrayList<double[][]> coordinates;
    private String color;
    private String shortName;

    public BusLine() {
    }

    public BusLine(String fullName, String type, ArrayList<double[][]> coordinates, String color, String shortName) {
        this.fullName = fullName;
        this.type = type;
        this.coordinates = coordinates;
        this.color = color;
        this.shortName = shortName;
    }

    public BusLine(BusLine busLine) {
        this.fullName = busLine.getFullName();
        this.type = busLine.getType();
        this.coordinates = busLine.getCoordinates();
        this.color = busLine.getColor();
        this.shortName = busLine.getShortName();
    }

    public BusLine(Record record) {
        this.fullName = record.getFullName();
        this.type = record.getType();
        ArrayList<double[][]> tempo = record.getCoordinates();
        this.coordinates = tempo;
        this.color = record.getColor();
        this.shortName = record.getShortName();
    }

    public String getFullName() {
        return fullName;
    }

    public String getType() {
        return type;
    }

    public ArrayList<double[][]> getCoordinates() {
        return coordinates;
    }

    public String getColor() {
        return color;
    }

    public String getShortName() {
        return shortName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinates(ArrayList<double[][]> coordinates) {
        this.coordinates = coordinates;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "BusLine{" + "fullName = " + fullName + ", type = " + type + ", coordinates = " + coordinates.toString() + ", color = " + color + ", shortName = " + shortName + '}';
    }

}

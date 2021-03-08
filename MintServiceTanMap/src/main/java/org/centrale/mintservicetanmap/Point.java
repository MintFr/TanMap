/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.mintservicetanmap;

import java.util.ArrayList;
import org.json.JSONArray;

/**
 * See JSON from service response
 * @author 33671
 */
public class Point {

    private double x;
    private double y;

    public Point() {
    }

    public Point(double[] tabInt) {
        this.x = tabInt[0];
        this.y = tabInt[1];
    }

    public Point(JSONArray json) {
        this.x = json.getDouble(0);
        this.y = json.getDouble(1);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x = " + x + ", y = " + y + '}';
    }

}

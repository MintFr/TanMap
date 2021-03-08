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
class Fields {

    private String route_long_name;
    private String route_type;
    private String route_color;
    private String route_short_name;
    private Shape shape;

    @JsonProperty
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @JsonProperty
    public Shape getShape() {
        return shape;
    }

    @JsonProperty
    public String getRoute_long_name() {
        return route_long_name;
    }

    @JsonProperty
    public String getRoute_type() {
        return route_type;
    }

    @JsonProperty
    public String getRoute_color() {
        return route_color;
    }

    @JsonProperty
    public String getRoute_short_name() {
        return route_short_name;
    }

    @JsonProperty
    public void setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
    }

    @JsonProperty
    public void setRoute_type(String route_type) {
        this.route_type = route_type;
    }

    @JsonProperty
    public void setRoute_color(String route_color) {
        this.route_color = route_color;
    }

    @JsonProperty
    public void setRoute_short_name(String route_short_name) {
        this.route_short_name = route_short_name;
    }

}

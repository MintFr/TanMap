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
class Shape {

    private String type;
    private float[][][] coordinates;

    @JsonProperty
    public void setCoordinates(float[][][] coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty
    public float[][][] getCoordinates() {
        return coordinates;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public void setType(String type) {
        this.type = type;
    }

}

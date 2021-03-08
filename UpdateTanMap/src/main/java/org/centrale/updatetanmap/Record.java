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
public class Record {

    private Fields fields;

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.updatetanmap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 33671
 */
public class TanResponse {
    
    private Record[] records;

    @JsonProperty("records")
    public Record[] getRecords() {
        return records;
    }

    @JsonProperty("records")
    public void setRecords(Record[] records) {
        this.records = records;
    }
    
   

}

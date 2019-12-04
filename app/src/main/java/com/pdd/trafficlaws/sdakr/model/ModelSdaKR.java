package com.pdd.trafficlaws.sdakr.model;

import java.io.Serializable;

public class ModelSdaKR implements Serializable {
    private String general_provisions;
    private String description;
    private long order;


    public ModelSdaKR() {
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getGeneral_provisions() {
        return general_provisions;
    }

    public void setGeneral_provisions(String general_provisions) {
        this.general_provisions = general_provisions;
    }
}

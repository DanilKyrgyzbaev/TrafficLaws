package com.pdd.trafficlaws.sdakr;

import java.io.Serializable;

public class ModelSdaKrThree implements Serializable {
    private String general_provisions;
    private String description;
    private long order;

    public ModelSdaKrThree() {
    }

    public String getGeneral_provisions() {
        return general_provisions;
    }

    public void setGeneral_provisions(String general_provisions) {
        this.general_provisions = general_provisions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}

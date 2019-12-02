package com.pdd.trafficlaws.osago;

import android.widget.TextView;

import java.io.Serializable;

public class AdditionModel implements Serializable {
    private String name;
    private String description;

    public AdditionModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.pdd.trafficlaws.fine;

import java.io.Serializable;

public class ModelFine implements Serializable {
    private String chast;
    private String fabula;
    private String statiya;
    private String violation;
    private String fines;
    private String individual_prices;
    private String entities_prices;
    private String individual;
    private String entities;
    private String category;
    private String note;
    private String absent;
    private String id;
    private long order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ModelFine() {
    }

    public String getFabula() {
        return fabula;
    }

    public void setFabula(String fabula) {
        this.fabula = fabula;
    }

    public String getStatiya() {
        return statiya;
    }

    public void setStatiya(String statiya) {
        this.statiya = statiya;
    }

    public String getChast() {
        return chast;
    }

    public void setChast(String chast) {
        this.chast = chast;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public String getFines() {
        return fines;
    }

    public void setFines(String fines) {
        this.fines = fines;
    }

    public String getIndividual_prices() {
        return individual_prices;
    }

    public void setIndividual_prices(String individual_prices) {
        this.individual_prices = individual_prices;
    }

    public String getEntities_prices() {
        return entities_prices;
    }

    public void setEntities_prices(String entities_prices) {
        this.entities_prices = entities_prices;
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual;
    }

    public String getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }
}

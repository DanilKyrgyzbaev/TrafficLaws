package com.pdd.trafficlaws.frequent;

public class FrequentModel {
    private String fabula;
    private String fines;
    private long order;
    private String prices;
    private String violation;

    public FrequentModel() {
    }

    public String getFabula() {
        return fabula;
    }

    public void setFabula(String fabula) {
        this.fabula = fabula;
    }

    public String getFines() {
        return fines;
    }

    public void setFines(String fines) {
        this.fines = fines;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }
}

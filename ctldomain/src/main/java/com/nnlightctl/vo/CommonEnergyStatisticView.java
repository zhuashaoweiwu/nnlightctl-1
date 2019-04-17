package com.nnlightctl.vo;

import java.math.BigDecimal;

public class CommonEnergyStatisticView {
    private String year;
    private String mouth;
    private String date;
    private Long total;
    private String energy;
    private BigDecimal totalEnergy;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public BigDecimal getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(BigDecimal totalEnergy) {
        this.totalEnergy = totalEnergy;
    }
}

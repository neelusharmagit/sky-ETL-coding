package uk.sky.domain;

import java.util.Objects;

public final class DriverData {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    private Double duration;

    public DriverData() {

    }

    public DriverData(String[] line) {
        this.name = line[0];
        this.duration = Double.parseDouble(line[1]);
    }


}

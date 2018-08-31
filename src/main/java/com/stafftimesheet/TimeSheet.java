package com.stafftimesheet;

public class TimeSheet {

    private Integer sunHours;
    private Integer monHours;
    private Integer tueHours;
    private Integer wedHours;
    private Integer thuHours;
    private Integer friHours;
    private Integer satHours;

    public TimeSheet(Integer sunHours, Integer monHours, Integer tueHours, Integer wedHours, Integer thuHours, Integer friHours, Integer satHours) {
        this.sunHours = sunHours;
        this.monHours = monHours;
        this.tueHours = tueHours;
        this.wedHours = wedHours;
        this.thuHours = thuHours;
        this.friHours = friHours;
        this.satHours = satHours;
    }

    public Integer getSunHours() {
        return sunHours;
    }

    public Integer getMonHours() {
        return monHours;
    }

    public Integer getTueHours() {
        return tueHours;
    }

    public Integer getWedHours() {
        return wedHours;
    }

    public Integer getThuHours() {
        return thuHours;
    }

    public Integer getFriHours() {
        return friHours;
    }

    public Integer getSatHours() {
        return satHours;
    }

    public Integer getTotalHours() {
        return sunHours + monHours + tueHours + wedHours + thuHours + friHours + satHours;
    }

    @Override
    public String toString() {
        return "TimeSheet{" +
                "sunHours=" + sunHours +
                ", monHours=" + monHours +
                ", tueHours=" + tueHours +
                ", wedHours=" + wedHours +
                ", thuHours=" + thuHours +
                ", friHours=" + friHours +
                ", satHours=" + satHours +
                ", totalHours=" + getTotalHours() +
                '}';
    }
}

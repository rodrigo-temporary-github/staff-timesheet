package com.stafftimesheet;

public class Staff {

    private String name;
    private Integer hourlyRate;
    private TimeSheet timesheet;

    public Staff(String name, Integer hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public Integer getWage() {
        return (timesheet.getSunHours() * (hourlyRate * 2)) +
                (timesheet.getMonHours() * hourlyRate) +
                (timesheet.getTueHours() * hourlyRate) +
                (timesheet.getWedHours() * hourlyRate) +
                (timesheet.getThuHours() * hourlyRate) +
                (timesheet.getFriHours() * hourlyRate) +
                (timesheet.getSatHours() * (hourlyRate + hourlyRate/2));
    }

    public void setTimesheet(Integer sunHours, Integer monHours, Integer tueHours, Integer wedHours, Integer thuHours, Integer friHours, Integer satHours) {
        this.timesheet = new TimeSheet(sunHours, monHours, tueHours, wedHours, thuHours, friHours, satHours);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", timesheet=" + timesheet.toString() +
                ", wage=" + getWage() +
                '}';
    }
}

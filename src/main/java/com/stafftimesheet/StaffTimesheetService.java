package com.stafftimesheet;

import java.util.ArrayList;
import java.util.List;

public class StaffTimesheetService {

    private List<Staff> staffMembers = new ArrayList<>();

    public void addStaff(String name, Integer hourlyRate) {
        staffMembers.add(new Staff(name, hourlyRate));
    }

    public void addTimesheet(String name, Integer sunHours, Integer monHours, Integer tueHours, Integer wedHours, Integer thuHours, Integer friHours, Integer satHours) {
        for (int i = 0; i < staffMembers.size(); i++) {
            if(staffMembers.get(i).getName().equals(name)) {
                staffMembers.get(i).setTimesheet(sunHours, monHours, tueHours, wedHours, thuHours, friHours, satHours);
            }
        }
    }

    public void retrieveIndividualTimesheet() {
        //TODO
    }

    public void retrieveAllTimesheets() {
        for(int i = 0; i < staffMembers.size(); i++) {
            System.out.println(staffMembers.get(i).toString());
        }
    }

    public void exit() {
        System.exit(0);
    }
}

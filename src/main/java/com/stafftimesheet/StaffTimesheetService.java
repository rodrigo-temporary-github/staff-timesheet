package com.stafftimesheet;

import java.util.ArrayList;
import java.util.List;

public class StaffTimesheetService {

    private List<Staff> staffMembers = new ArrayList<>();

    public void addStaff(String name, Integer hourlyRate) {
        if(hourlyRate > 50) {
            hourlyRate = 50;
        }
        staffMembers.add(new Staff(name, hourlyRate));
    }

    public void addTimesheet(String name, Integer sunHours, Integer monHours, Integer tueHours, Integer wedHours, Integer thuHours, Integer friHours, Integer satHours) {
        for (int i = 0; i < staffMembers.size(); i++) {
            if(staffMembers.get(i).getName().equals(name)) {
                staffMembers.get(i).setTimesheet(sunHours, monHours, tueHours, wedHours, thuHours, friHours, satHours);
            }
        }
    }

    public TimesheetSummary retrieveAllTimesheets() {
        if(staffMembers.size() == 0 || staffMembers.get(0).getTimesheet() == null) {
            return new EmptyTimesheetSummary();
        } else {
            return new StaffTimesheetSummary(staffMembers);
        }
    }

    public void exit() {
        System.exit(0);
    }
}

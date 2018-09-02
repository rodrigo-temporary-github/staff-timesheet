package com.stafftimesheet;

import java.util.List;

public class StaffTimesheetSummary implements TimesheetSummary {

    private final List<Staff> staffMembers;

    public StaffTimesheetSummary(List<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    @Override
    public String description() {
        String result = "";

        for(Staff staffMember: staffMembers) {
            result += staffMember.toString() + "\n";
        }

        return result.trim();
    }
}

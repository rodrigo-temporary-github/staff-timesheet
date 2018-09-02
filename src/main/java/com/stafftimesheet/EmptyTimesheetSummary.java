package com.stafftimesheet;

public class EmptyTimesheetSummary implements TimesheetSummary {

    @Override
    public String description() {
        return "There are no timesheets yet!";
    }

}

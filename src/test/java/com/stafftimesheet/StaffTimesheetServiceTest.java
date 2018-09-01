package com.stafftimesheet;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class StaffTimesheetServiceTest {

    @Test
    public void shouldReturnTimesheetForSingleStaffMember() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=40, timesheet=TimeSheet{sunHours=0, monHours=8, tueHours=8, wedHours=8, thuHours=8, friHours=8, satHours=0, totalHours=40}, wage=1600}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();
        staffTimesheetService.addStaff("Rodrigo", 40);
        staffTimesheetService.addTimesheet("Rodrigo",0, 8, 8, 8, 8, 8, 0);

        // Required to test output message
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        staffTimesheetService.retrieveAllTimesheets();

        assertEquals(outContent.toString().trim(), expectedResult);
    }

    @Test
    public void shouldReturnTimesheetForMultipleStaffMembers() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=40, timesheet=TimeSheet{sunHours=0, monHours=8, tueHours=8, wedHours=8, thuHours=8, friHours=8, satHours=0, totalHours=40}, wage=1600}\nStaff{name='Paul', hourlyRate=30, timesheet=TimeSheet{sunHours=5, monHours=7, tueHours=7, wedHours=7, thuHours=7, friHours=7, satHours=5, totalHours=45}, wage=1575}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();

        staffTimesheetService.addStaff("Rodrigo", 40);
        staffTimesheetService.addTimesheet("Rodrigo",0, 8, 8, 8, 8, 8, 0);

        staffTimesheetService.addStaff("Paul", 30);
        staffTimesheetService.addTimesheet("Paul",5, 7, 7, 7, 7, 7, 5);

        // Required to test output message
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        staffTimesheetService.retrieveAllTimesheets();

        assertEquals(outContent.toString().trim(), expectedResult);
    }
}
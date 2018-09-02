package com.stafftimesheet;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StaffTimesheetServiceTest {

    @Test
    public void shouldApplyHourlyRateCapTo50() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=50, timesheet=TimeSheet{sunHours=0, monHours=8, tueHours=8, wedHours=8, thuHours=8, friHours=8, satHours=0, totalHours=40}, wage=2000}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();
        staffTimesheetService.addStaff("Rodrigo", 55);
        staffTimesheetService.addTimesheet("Rodrigo",0, 8, 8, 8, 8, 8, 0);

        assertEquals(staffTimesheetService.retrieveAllTimesheets().description(), expectedResult);
    }

    @Test
    public void shouldApplyCorrectHourlyRateForSaturday() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=30, timesheet=TimeSheet{sunHours=0, monHours=0, tueHours=0, wedHours=0, thuHours=0, friHours=0, satHours=8, totalHours=8}, wage=360}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();
        staffTimesheetService.addStaff("Rodrigo", 30);
        staffTimesheetService.addTimesheet("Rodrigo",0, 0, 0, 0, 0, 0, 8);

        assertEquals(staffTimesheetService.retrieveAllTimesheets().description(), expectedResult);
    }

    @Test
    public void shouldApplyCorrectHourlyRateForSunday() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=30, timesheet=TimeSheet{sunHours=8, monHours=0, tueHours=0, wedHours=0, thuHours=0, friHours=0, satHours=0, totalHours=8}, wage=480}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();
        staffTimesheetService.addStaff("Rodrigo", 30);
        staffTimesheetService.addTimesheet("Rodrigo",8, 0, 0, 0, 0, 0, 0);

        assertEquals(staffTimesheetService.retrieveAllTimesheets().description(), expectedResult);
    }

    @Test
    public void shouldReturnTimesheetForSingleStaffMember() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=40, timesheet=TimeSheet{sunHours=0, monHours=8, tueHours=8, wedHours=8, thuHours=8, friHours=8, satHours=0, totalHours=40}, wage=1600}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();
        staffTimesheetService.addStaff("Rodrigo", 40);
        staffTimesheetService.addTimesheet("Rodrigo",0, 8, 8, 8, 8, 8, 0);

        assertEquals(staffTimesheetService.retrieveAllTimesheets().description(), expectedResult);
    }

    @Test
    public void shouldReturnTimesheetForMultipleStaffMembers() {
        String expectedResult = "Staff{name='Rodrigo', hourlyRate=40, timesheet=TimeSheet{sunHours=0, monHours=8, tueHours=8, wedHours=8, thuHours=8, friHours=8, satHours=0, totalHours=40}, wage=1600}\n" +
                "Staff{name='Paul', hourlyRate=30, timesheet=TimeSheet{sunHours=5, monHours=7, tueHours=7, wedHours=7, thuHours=7, friHours=7, satHours=5, totalHours=45}, wage=1575}";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();

        staffTimesheetService.addStaff("Rodrigo", 40);
        staffTimesheetService.addTimesheet("Rodrigo",0, 8, 8, 8, 8, 8, 0);

        staffTimesheetService.addStaff("Paul", 30);
        staffTimesheetService.addTimesheet("Paul",5, 7, 7, 7, 7, 7, 5);

        assertEquals(staffTimesheetService.retrieveAllTimesheets().description(), expectedResult);
    }

    @Test
    public void shouldNotReturnTimesheetsIfThereIsntAny() {
        String expectedResult = "There are no timesheets yet!";

        StaffTimesheetService staffTimesheetService = new StaffTimesheetService();

        assertEquals(staffTimesheetService.retrieveAllTimesheets().description(), expectedResult);
    }
}
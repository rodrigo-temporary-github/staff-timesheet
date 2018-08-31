package com.stafftimesheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private StaffTimesheetService service;

    public void init() {
        printInstructions();

        service = new StaffTimesheetService();
    }

    public void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String inputValue = br.readLine();

            if(inputValue.startsWith("add staff")) {
                service.addStaff(inputValue.split(" ")[2], Integer.parseInt(inputValue.split(" ")[3]));
            } else if(inputValue.startsWith("add timesheet")) {
                service.addTimesheet(
                        inputValue.split(" ")[2],
                        Integer.parseInt(inputValue.split(" ")[3]),
                        Integer.parseInt(inputValue.split(" ")[4]),
                        Integer.parseInt(inputValue.split(" ")[5]),
                        Integer.parseInt(inputValue.split(" ")[6]),
                        Integer.parseInt(inputValue.split(" ")[7]),
                        Integer.parseInt(inputValue.split(" ")[8]),
                        Integer.parseInt(inputValue.split(" ")[9])
                );
            } else if(inputValue.equalsIgnoreCase("retrieve all timesheets")) {
                service.retrieveAllTimesheets();
            } else if("exit".equalsIgnoreCase(inputValue)) {
                service.exit();
            } else {
                printInstructions();
            }
        }
    }

    private void printInstructions() {
        System.out.println("\nType `add staff` <STAFF NAME> <HOURLY RATE> to record a staff member and their hourly rate."); // e.g: add staff Rodrigo 40
        System.out.println("Type `add timesheet` <STAFF NAME> <SUN> <MON> <TUE> <WED> <THU> <FRI> <SAT> to record a staff member’s timesheet for the week."); // e.g: add timesheet Rodrigo 0 8 8 8 8 8 0
        System.out.println("Type `retrieve all timesheets` to retrieve the staff members total hours and wage for the week."); // e.g: retrieve all timesheets
        System.out.println("Type `exit` to quit the app.\n"); // e.g: exit
    }
}

package com.stafftimesheet;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class StaffTest {

    @Test
    public void shouldGetCorrectWage() {
        Integer expectedWage = 1200;

        Staff staff = new Staff("Rodrigo", 30);
        staff.setTimesheet(0, 8, 8, 8, 8, 8, 0);

        Integer actualWage = staff.getWage();

        assertEquals(actualWage, expectedWage);
    }
}

package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EventCalendarTest {

    private EventCalendar calendar;

    @BeforeMethod
    public void setUp() {
        calendar = new EventCalendar(2026);
    }

    @Test
    public void testAddAnonymousDayInfoSuccessfully() {
        EventCalendar.Day day = calendar.addDayInfo(LocalDate.of(2026, 1, 1), true, "New Year");

        Assert.assertNotNull(day);
        Assert.assertEquals(day.getDate(), LocalDate.of(2026, 1, 1));
        Assert.assertTrue(day.isHoliday());
        Assert.assertEquals(day.getNote(), "New Year");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddDayInfoThrowsExceptionOnWrongYear() {
        calendar.addDayInfo(LocalDate.of(2025, 5, 9), true, "Wrong Year Holiday");
    }

    @Test
    public void testGetDayFindsExistingDay() {
        calendar.addDayInfo(LocalDate.of(2026, 3, 8), true, "International Women's Day");

        Optional<EventCalendar.Day> retrievedDay = calendar.getDay(LocalDate.of(2026, 3, 8));

        Assert.assertTrue(retrievedDay.isPresent());
        Assert.assertEquals(retrievedDay.get().getNote(), "International Women's Day");
    }

    @Test
    public void testGetHolidaysFiltersCorrectly() {
        calendar.addDayInfo(LocalDate.of(2026, 1, 1), true, "New Year");
        calendar.addDayInfo(LocalDate.of(2026, 1, 2), false, "Regular Work Day");
        calendar.addDayInfo(LocalDate.of(2026, 1, 7), true, "Orthodox Christmas");

        List<EventCalendar.Day> holidays = calendar.getHolidays();

        Assert.assertEquals(holidays.size(), 2);
        Assert.assertTrue(holidays.stream().allMatch(EventCalendar.Day::isHoliday));
    }

    @Test
    public void testAnonymousClassStateUpdates() {
        EventCalendar.Day day = calendar.addDayInfo(LocalDate.of(2026, 9, 1), false, "Start of University");

        day.setHoliday(true);
        day.setNote("Unexpected Day Off");

        Assert.assertTrue(day.isHoliday());
        Assert.assertEquals(day.getNote(), "Unexpected Day Off");
    }
}
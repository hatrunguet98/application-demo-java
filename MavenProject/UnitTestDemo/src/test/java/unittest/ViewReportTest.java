package unittest;

import model.booking.Booking;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class ViewReportTest {
    Booking booking;
    ArrayList<Booking> bookings;

    @Before
    public void setUp() {
        bookings = new ArrayList<>();
        Date date = new Date();
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date date5=new Date(date.getTime() - (5 * DAY_IN_MS));
        booking = new Booking();
        booking.setIssueAudit(date5);
        bookings.add(booking);
        booking = new Booking();
        booking.setIssueAudit(date);
        bookings.add(booking);
    }

    @Test()
    public void testGetBookingDayAgo1() {
        ArrayList<Booking> bookingList = new view.host.ViewReport("12").listBookingDayAgo(bookings);
        assertNotNull("bookings is null"+booking.getIssueAudit(),bookingList);
    }
    @Test()
    public void testGetBookingDayAgo2() {
        ArrayList<Booking> bookingList = new view.host.ViewReport("12").listBookingDayAgo(bookings);
        assertEquals(1,bookingList.size());

    }
}

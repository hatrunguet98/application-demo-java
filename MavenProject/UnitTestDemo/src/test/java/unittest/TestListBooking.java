package unittest;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

import dao.BookingFile;
import model.booking.Booking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import view.host.ViewReport;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class TestListBooking {
    ArrayList<Booking> bookings;
    ArrayList<Booking> bookingList;
    @Before
    public void setUp(){
        bookings=new ArrayList<>();
    }
    @Test()
    public void testGetBookingDayAgo() {
        bookingList = new ViewReport("12").listBookingDayAgo(bookings);
        Assert.fail("booking is null");
    }
}

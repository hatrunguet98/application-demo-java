package service.select;

import dao.BookingFile;
import dao.SaleItemFile;
import model.booking.Booking;
import java.util.ArrayList;
import java.util.Comparator;

public class SelectBooking implements ISelect<Booking> {
    private ArrayList<Booking> listBookings;
    private ArrayList<Booking> listBookingsFile;

    @Override
    public ArrayList<Booking> getByHostId(String userId) {
        listBookingsFile = new BookingFile().get();
        listBookings = new ArrayList<>();
        for (int i = 0; i < listBookingsFile.size(); i++) {
            Booking booking = listBookingsFile.get(i);
            if (booking.getHostId().equalsIgnoreCase(userId)) {
                listBookings.add(booking);
            }
        }
        return listBookings;

    }

    @Override
    public Booking getById(String id) {
        listBookingsFile = new BookingFile().get();
        Booking booking = new Booking();
        for (int i = 0; i < listBookingsFile.size(); i++) {
            booking = listBookingsFile.get(i);
            if (booking.getHostId().equalsIgnoreCase(id)) {
                break;
            }
        }
        return booking;
    }

    @Override
    public void delete(String id) {
        listBookingsFile = new BookingFile().get();
        for (int i = 0; i < listBookingsFile.size(); i++) {
            if (listBookingsFile.get(i).getHostId().equalsIgnoreCase(id)) {
                listBookingsFile.remove(i);
                break;
            }
        }
        new SaleItemFile().delete(listBookingsFile);
    }

    @Override
    public void save(Booking booking) {
        listBookingsFile = new BookingFile().get();
        for (int i = 0; i < listBookingsFile.size(); i++) {
            if (listBookingsFile.get(i).getHostId().equalsIgnoreCase(booking.getId())) {
                listBookingsFile.remove(i);
                break;
            }
        }
        listBookingsFile.add(booking);
        new SaleItemFile().delete(listBookingsFile);
    }

    @Override
    public void sortByIssueDate(ArrayList<Booking> listBooking) {
        listBooking.sort(Comparator.comparing(Booking::getDateIssuedAudit));
    }
}

package service.select;

import dao.BookingFile;
import model.booking.Booking;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectBooking implements ISelect<Booking> {
    private ArrayList<Booking> listBookings;
    private ArrayList<Booking> listBookingsFile;

    @Override
    public Booking getById(int id, ArrayList<Booking> listT) {
        Booking booking = new Booking();
        for (int i = 0; i < listT.size(); i++) {
            if (listT.get(i).getId() == id) {
                booking = listT.get(i);
                break;
            }
        }
        return booking;
    }

    @Override
    public void delete(int id) {
        listBookingsFile = new BookingFile().get();
        for (int i = 0; i < listBookingsFile.size(); i++) {
            if (listBookingsFile.get(i).getId() == id) {
                listBookingsFile.remove(i);
                break;
            }
        }
        new BookingFile().update(listBookingsFile);
    }

    @Override
    public void save(Booking booking) {
        listBookingsFile = new BookingFile().get();
        listBookingsFile.add(booking);
        new BookingFile().update(listBookingsFile);
    }

    public void update(Booking booking) {
        listBookingsFile = new BookingFile().get();
        for (int i = 0; i < listBookingsFile.size(); i++) {
            if (listBookingsFile.get(i).getId() == booking.getId()) {
                listBookingsFile.remove(i);
                listBookingsFile.add(booking);
                break;
            }
        }
        new BookingFile().update(listBookingsFile);
    }

    @Override
    public ArrayList<Booking> sortByIssueDate(ArrayList<Booking> listT) {
        listT.sort(Comparator.comparing(Booking::getIssueAudit));
        return listT;
    }

    @Override
    public ArrayList<Booking> sortById(ArrayList<Booking> listT) {
        listT.sort(Comparator.comparing(Booking::getId));
        return listT;
    }

    public ArrayList<Booking> sortByTotal(ArrayList<Booking> listT) {
        listT.sort(Comparator.comparing(Booking::getTotalPrice));
        return listT;
    }
}

package main.model;

import java.util.List;

public class Booking {
    private int bookingId;
    private String vehicleId;
    private List<Integer> bookedSlots;

    public Booking(int bookingId, String vehicleId, List<Integer> bookedSlots) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.bookedSlots = bookedSlots;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<Integer> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<Integer> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }
}

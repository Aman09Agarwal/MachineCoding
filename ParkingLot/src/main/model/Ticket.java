package main.model;

import main.service.ParkingSlot;

public class Ticket {
    private String ticketNumber;
    private long entryTime;
    private long exitTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public Ticket() {
    }

    public Ticket(String ticketNumber, long entryTime, long exitTime, Vehicle vehicle, ParkingSlot parkingSlot) {
        this.ticketNumber = ticketNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(System.currentTimeMillis());
        ticket.setParkingSlot(parkingSlot);
        ticket.setVehicle(vehicle);
        ticket.setTicketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis());
        return ticket;
    }
}

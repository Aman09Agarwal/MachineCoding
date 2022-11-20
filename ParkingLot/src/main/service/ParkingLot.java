package main.service;

import main.enums.ParkingSlotType;
import main.model.Address;
import main.model.Ticket;
import main.model.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String name, Address address, List<ParkingFloor> parkingFloors) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }

    public static void setParkingLot(ParkingLot parkingLot) {
        ParkingLot.parkingLot = parkingLot;
    }

    public static ParkingLot getInstance(String name, Address address, List<ParkingFloor> parkingFloors) {
        if(parkingLot == null) {
            parkingLot = new ParkingLot(name, address, parkingFloors);
        }
        return parkingLot;
    }

    public void addFloor(int floorNumber, Map<ParkingSlotType, Map<String, ParkingSlot>> parkSlots) {
        ParkingFloor parkingFloor = new ParkingFloor(floorNumber, parkSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloor(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }

    private Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for(ParkingFloor parkingFloor : parkingFloors) {
            parkingSlot = parkingFloor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot != null) {
                break;
            }
        }
        return parkingSlot;
    }

    public Ticket assignTicket(Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) {
            System.out.println("No slot available");
            return null;
        }
        Ticket ticket = createTicket(vehicle, parkingSlot);
        return ticket;
    }

    public double scanAndPay(Ticket ticket) {
        long exitTime = System.currentTimeMillis();
        ticket.setExitTime(exitTime);
        ticket.getParkingSlot().removeVehicle();
        int duration = (int) (exitTime - ticket.getEntryTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return price;
    }

}

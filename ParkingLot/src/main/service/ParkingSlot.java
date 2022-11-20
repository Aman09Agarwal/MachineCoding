package main.service;

import main.enums.ParkingSlotType;
import main.model.Vehicle;

public class ParkingSlot {
    private String name;
    private boolean isAvailable;
    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle) {
        this.isAvailable = false;
        this.vehicle = vehicle;
    }

    protected void removeVehicle() {
        this.isAvailable = true;
        this.vehicle = null;
    }
}

package main.model;

import main.enums.VehicleType;

import java.util.Map;

public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;
    private String branchName;
    private double price;
    private Map<Slot, Boolean> slotAvailability;

    public Vehicle(String vehicleId, VehicleType vehicleType, String branchName, double price, Map<Slot, Boolean> slotAvailability) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.branchName = branchName;
        this.price = price;
        this.slotAvailability = slotAvailability;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Slot, Boolean> getSlotAvailability() {
        return slotAvailability;
    }

    public void setSlotAvailability(Map<Slot, Boolean> slotAvailability) {
        this.slotAvailability = slotAvailability;
    }
}

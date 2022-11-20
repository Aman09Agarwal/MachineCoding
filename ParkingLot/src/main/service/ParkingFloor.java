package main.service;

import main.enums.ParkingSlotType;
import main.enums.VehicleCategory;
import main.model.Vehicle;

import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(int floorNumber, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlotType(vehicleCategory);
        Map<String,ParkingSlot> relevantParkingSlots = parkingSlots.get(parkingSlotType);
        ParkingSlot parkingSlot = null;
        for(ParkingSlot slot : relevantParkingSlots.values()) {
            if(slot.isAvailable()){
                parkingSlot = slot;
                parkingSlot.addVehicle(vehicle);
                break;
            }
        }
        return parkingSlot;
    }

    private ParkingSlotType pickCorrectSlotType(VehicleCategory vehicleCategory) {
        switch(vehicleCategory) {
            case TWO_WHEELER:
                return ParkingSlotType.TWO_WHEELER;
            case HATCHBACK:
            case SEDAN:
                return ParkingSlotType.COMPACT;
            case SUV:
                return ParkingSlotType.MEDIUM;
            case BUS:
                return ParkingSlotType.LARGE;
            default:
                return null;
        }
    }
}

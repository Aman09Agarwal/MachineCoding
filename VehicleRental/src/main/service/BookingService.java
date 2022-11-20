package main.service;

import main.enums.VehicleType;
import main.model.Booking;
import main.model.Branch;
import main.model.Slot;
import main.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookingService {
    private volatile static BookingService bookingServiceObject;
    private Map<String, Booking> bookings = new HashMap<>();
    BranchService branchService = BranchService.getInstance();
    VehicleService vehicleService = VehicleService.getInstance();

    private BookingService() {
    }

    public static BookingService getInstance() {
        if (bookingServiceObject == null) {
            synchronized (BookingService.class) {
                if (bookingServiceObject == null) {
                    bookingServiceObject = new BookingService();
                }
            }
        }
        return bookingServiceObject;
    }

    public int bookAVehicle(String branchName, VehicleType vehicleType, long startTime, long endTime) {
        Optional<Branch> branch = branchService.getBranchByName(branchName);
        if (!branch.isPresent())
            return -1;

        if (!branch.get().getSupportedVehicleType().contains(vehicleType))
            return -1;

        for (Vehicle vehicle : vehicleService.getAvailableVehicles(branchName, startTime, endTime)) {
            if (vehicle.getVehicleType() == vehicleType) {
                Map<Slot, Boolean> slots = vehicle.getSlotAvailability();
                int totalTime = 0;
                for (Map.Entry entry : slots.entrySet()) {
                    Slot slot = (Slot) entry.getKey();
                    if (slot.getStartTime() >= startTime && slot.getEndTime() <= endTime) {
                        entry.setValue(false);
                        totalTime++;
                    }
                }
                vehicle.setSlotAvailability(slots);
                return totalTime * (int) vehicle.getPrice();
            }
        }

        return -1;
    }
}

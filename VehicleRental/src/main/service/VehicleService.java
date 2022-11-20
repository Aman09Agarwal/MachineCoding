package main.service;

import main.enums.VehicleType;
import main.model.Branch;
import main.model.Slot;
import main.model.Vehicle;

import java.util.*;

class SortByPrice implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle a, Vehicle b) {
        if (a.getPrice() <= b.getPrice())
            return -1;
        return 1;
    }
}

public class VehicleService {
    private volatile static VehicleService vehicleServiceObject;
    private Map<String, Vehicle> vehicleList = new HashMap<>();
    BranchService branchService = BranchService.getInstance();

    private VehicleService() {
    }

    public static VehicleService getInstance() {
        if (vehicleServiceObject == null) {
            synchronized (BranchService.class) {
                if (vehicleServiceObject == null) {
                    vehicleServiceObject = new VehicleService();
                }
            }
        }
        return vehicleServiceObject;
    }

    public boolean onboardVehicle(String branchName, VehicleType vehicleType, String vehicleId, double price) {
        if (vehicleList.containsKey(vehicleId))
            return false;

        Optional<Branch> branch = branchService.getBranchByName(branchName);
        if (!branch.isPresent())
            return false;

        if (!branch.get().getSupportedVehicleType().contains(vehicleType))
            return false;

        //  we can assign any number of slots to a newly added vehicle
        vehicleList.put(vehicleId, new Vehicle(vehicleId, vehicleType, branchName, price, getSlotsForNewlyAddedVehicle(12)));
        branchService.addNewVehicleToBranch(branchName, vehicleId);
        return true;
    }

    private Map<Slot, Boolean> getSlotsForNewlyAddedVehicle(int numberOfSlots) {
        Map<Slot, Boolean> slots = new HashMap<>();
        for (int i = 1; i <= numberOfSlots; i++)
            slots.put(new Slot(i, i - 1, i), true);
        return slots;
    }

    public List<Vehicle> getAvailableVehicles(String branchName, long startTime, long endTime) {
        Optional<Branch> branch = branchService.getBranchByName(branchName);
        List<String> vehicles;
        List<Vehicle> availableVehicles = new ArrayList<>();
        if (!branch.isPresent()) {
            System.out.println("No such branch available : " + branchName);
            return null;
        }
        vehicles = branch.get().getListOfVehicle();
        for (String vehicleId : vehicles) {
            Vehicle vehicle = vehicleList.get(vehicleId);
            boolean isAvailable = true;
            for (Map.Entry entry : vehicle.getSlotAvailability().entrySet()) {
                Slot slot = (Slot) entry.getKey();
                if (!(boolean) entry.getValue() && slot.getStartTime() >= startTime && slot.getEndTime() <= endTime) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable)
                availableVehicles.add(vehicle);
        }
        Collections.sort(availableVehicles, new SortByPrice());
        return availableVehicles;
    }

    public void displayAllAvailableVehicles(String branchName, long startTime, long endTime) {
        List<Vehicle> listOfAvailableVehicle = getAvailableVehicles(branchName, startTime, endTime);
        for (int i = 0; i < listOfAvailableVehicle.size(); i++) {
            if (i == listOfAvailableVehicle.size() - 1)
                System.out.print(listOfAvailableVehicle.get(i).getVehicleId());
            else
                System.out.print(listOfAvailableVehicle.get(i).getVehicleId() + ", ");
        }
        System.out.println();
    }
}

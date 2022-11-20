package main.service;

import main.enums.VehicleType;
import main.model.Branch;

import java.util.*;

public class BranchService {
    private volatile static BranchService branchServiceObject;
    private Map<String, Branch> branchList = new HashMap<>();

    private BranchService() {
    }

    public static BranchService getInstance() {
        if (branchServiceObject == null) {
            synchronized (BranchService.class) {
                if (branchServiceObject == null) {
                    branchServiceObject = new BranchService();
                }
            }
        }
        return branchServiceObject;
    }

    public boolean onboardBranch(String branchName, String[] vehicleTypes) {
        if (branchList.containsKey(branchName))
            return false;

        List<VehicleType> vehicleTypeEnums = new ArrayList<>();
        Arrays.stream(vehicleTypes).forEach(x -> vehicleTypeEnums.add(VehicleType.valueOf(x)));
        branchList.put(branchName, new Branch(branchName, vehicleTypeEnums));
        return true;
    }

    public Optional<Branch> getBranchByName(String branchName) {
        return Optional.ofNullable(branchList.get(branchName));
    }

    public void addNewVehicleToBranch(String branchName, String vehicleId) {
        Optional<Branch> branch = getBranchByName(branchName);
        if (branch.isPresent())
            branch.get().getListOfVehicle().add(vehicleId);
    }
}

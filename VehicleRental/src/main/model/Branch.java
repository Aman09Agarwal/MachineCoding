package main.model;

import main.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchName;
    private List<VehicleType> supportedVehicleType;
    private List<String> listOfVehicle;

    public Branch(String branchName, List<VehicleType> supportedVehicleType) {
        this.branchName = branchName;
        this.supportedVehicleType = supportedVehicleType;
        this.listOfVehicle = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<VehicleType> getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(List<VehicleType> supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public List<String> getListOfVehicle() {
        return listOfVehicle;
    }

    public void setListOfVehicle(List<String> listOfVehicle) {
        this.listOfVehicle = listOfVehicle;
    }
}

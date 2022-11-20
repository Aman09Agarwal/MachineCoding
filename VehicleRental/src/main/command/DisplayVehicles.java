package main.command;

import main.service.VehicleService;

public class DisplayVehicles implements CommandExecutorService {
    VehicleService vehicleService = VehicleService.getInstance();

    public void execute(String command) {
        String[] commandElements = command.split(" ");
        vehicleService.displayAllAvailableVehicles(commandElements[1], Long.parseLong(commandElements[2]), Long.parseLong(commandElements[3]));
    }
}

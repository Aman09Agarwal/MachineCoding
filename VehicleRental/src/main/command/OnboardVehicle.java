package main.command;

import main.enums.VehicleType;
import main.service.VehicleService;

public class OnboardVehicle implements CommandExecutorService {
    VehicleService vehicleService = VehicleService.getInstance();

    public void execute(String command) {
        String[] commandElements = command.split(" ");
        System.out.println(vehicleService.onboardVehicle(commandElements[1], VehicleType.valueOf(commandElements[2]), commandElements[3], Double.parseDouble(commandElements[4])));
    }
}

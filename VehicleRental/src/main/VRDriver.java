package main;

import main.command.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class VRDriver {
    public static void main(String[] args) {
        CommandExecutorService commandExecutorService;
        try {
            FileInputStream fis = new FileInputStream("/Users/aman/Desktop/mc/VehicleRental/src/main/input.txt");
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                switch (command.substring(0, command.indexOf(' '))) {
                    case "ADD_BRANCH":
                        commandExecutorService = new OnboardBranch();
                        commandExecutorService.execute(command);
                        break;
                    case "ADD_VEHICLE":
                        commandExecutorService = new OnboardVehicle();
                        commandExecutorService.execute(command);
                        break;
                    case "BOOK":
                        commandExecutorService = new BookAVehicle();
                        commandExecutorService.execute(command);
                        break;
                    case "DISPLAY_VEHICLES":
                        commandExecutorService = new DisplayVehicles();
                        commandExecutorService.execute(command);
                        break;
                    default:
                        System.out.println("Command not found");
                        break;
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

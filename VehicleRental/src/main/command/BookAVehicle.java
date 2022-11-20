package main.command;

import main.enums.VehicleType;
import main.service.BookingService;

public class BookAVehicle implements CommandExecutorService {
    BookingService bookingService = BookingService.getInstance();

    public void execute(String command) {
        String[] commandElements = command.split(" ");
        System.out.println(bookingService.bookAVehicle(commandElements[1], VehicleType.valueOf(commandElements[2]), Long.parseLong(commandElements[3]), Long.parseLong(commandElements[4])));
    }
}

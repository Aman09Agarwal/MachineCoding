import main.enums.ParkingSlotType;
import main.enums.VehicleCategory;
import main.model.Address;
import main.model.Ticket;
import main.model.Vehicle;
import main.service.ParkingFloor;
import main.service.ParkingLot;
import main.service.ParkingSlot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        String parkingLotName = "Forum Parking Lot";
        Address address = new Address(parkingLotName, "Bangalore", "India");

        Map<ParkingSlotType, Map<String, ParkingSlot>> allSlots = new HashMap<>();
        Map<String, ParkingSlot> compactSlot = new HashMap<>();
        compactSlot.put("S1", new ParkingSlot("S1", ParkingSlotType.COMPACT));
        compactSlot.put("S2", new ParkingSlot("S2", ParkingSlotType.COMPACT));
        compactSlot.put("S3", new ParkingSlot("S3", ParkingSlotType.COMPACT));
        allSlots.put(ParkingSlotType.COMPACT, compactSlot);
        Map<String, ParkingSlot> largeSlot = new HashMap<>();
        largeSlot.put("S1", new ParkingSlot("S1", ParkingSlotType.LARGE));
        largeSlot.put("S2", new ParkingSlot("S2", ParkingSlotType.LARGE));
        largeSlot.put("S3", new ParkingSlot("S3", ParkingSlotType.LARGE));
        allSlots.put(ParkingSlotType.LARGE, largeSlot);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        ParkingFloor parkingFloor1 = new ParkingFloor(1, allSlots);
        parkingFloors.add(parkingFloor1);

        ParkingLot parkingLot = ParkingLot.getInstance(parkingLotName, address, parkingFloors);

        Vehicle vehicle = new Vehicle("KA101", VehicleCategory.SEDAN);
        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println("Ticket number : " + ticket.getTicketNumber());

        Thread.sleep(10000);

        double price = parkingLot.scanAndPay(ticket);
        System.out.println("Total amount to be paid : " + price);
    }
}

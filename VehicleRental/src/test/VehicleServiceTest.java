package test;

import main.enums.VehicleType;
import main.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {

    VehicleService vehicleService;

    @BeforeEach
    void setUp() {
        vehicleService = VehicleService.getInstance();
    }

    @Test
    void onboardVehicle() {
        boolean ack = vehicleService.onboardVehicle("B1", VehicleType.CAR, "V1", 250d);
        assertEquals(false, ack);
    }

    @Test
    void getAvailableVehicles() {
        assertEquals(null, vehicleService.getAvailableVehicles("B1", 1L, 5L));
    }
}
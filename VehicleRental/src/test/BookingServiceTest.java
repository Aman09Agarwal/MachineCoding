package test;

import main.enums.VehicleType;
import main.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    BookingService bookingService;

    @BeforeEach
    void setUp() {
        bookingService = BookingService.getInstance();
    }

    @Test
    void bookAVehicle() {
        int price = bookingService.bookAVehicle("B1", VehicleType.CAR, 1L, 5L);
        assertEquals(-1, price);
    }
}
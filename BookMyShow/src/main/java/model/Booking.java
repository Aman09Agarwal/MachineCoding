package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    int bookingId;
    Show show;
    List<Seat> bookedSeats;
    Payment payment;
}

package model;

import enums.SeatCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seat {
    int seatId;
    int rowId;
    SeatCategory seatCategory;
}

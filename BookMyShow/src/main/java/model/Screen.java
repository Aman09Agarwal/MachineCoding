package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Screen {
    int screenId;
    List<Seat> seats;
}

package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Show {
    int showId;
    public Movie movie;
    Screen screen;
    int showStartTime;
    List<Integer> bookedSeatIds;
}

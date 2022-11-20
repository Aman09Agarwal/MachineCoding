package model;

import enums.City;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Theatre {
    int theatreId;
    String address;
    City city;
    List<Screen> screens;
    List<Show> shows;
}

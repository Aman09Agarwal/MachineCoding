package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    public int movieId;
    public String name;
    int duration;
}

package responseModel;

import groovy.transform.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode()
public class Coord {
    private double lon;
    private double lat;
}

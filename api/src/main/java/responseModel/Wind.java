package responseModel;

import groovy.transform.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode()
public class Wind {
    public double speed;
    public int deg;
    public double gust;
}

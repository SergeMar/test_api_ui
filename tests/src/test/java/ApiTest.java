import org.junit.jupiter.api.Test;
import responseModel.WeatherModel;

public class ApiTest {
    ApiBot api = new ApiBot();

    @Test
    public void weatherTest() {
        WeatherModel weatherInMinsk = api.getWeatherInMinsk();
        api.verifyCity(weatherInMinsk);
    }
}

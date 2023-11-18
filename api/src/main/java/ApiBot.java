import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import responseModel.WeatherModel;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiBot {

    public WeatherModel getWeatherInMinsk() {
        Response response = given()
                .param("lat",ApiParams.lat)
                .param("lon", ApiParams.lon)
                .param("appid", ApiParams.apiKey)
                .baseUri(ApiParams.apiUrl)
                .contentType(ContentType.JSON)
                .when()
                .get();

        return response.then().statusCode(HttpStatus.SC_OK)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("meta-data/weather.json"))
                .extract().as(WeatherModel.class);
    }

    public void verifyCity(WeatherModel weatherInCity) {
        assertThat(weatherInCity.getName()).isEqualTo(ApiParams.MINSK_CITY);
    }
}

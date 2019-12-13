import OpenWeatherAPIData.ResponseData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Program {

    public static void main(String[] args){

        System.out.println("Next five days Best outreach forcast for Minneapolis");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        Response response = request.get("http://api.openweathermap.org/data/2.5/forecast?q=minneapolis,us&units=imperial&APPID=09110e603c1d5c272f94f64305c09436");

        ResponseData apiData = response.getBody().as(ResponseData.class);

        apiData.printForecast(5);
    }
}

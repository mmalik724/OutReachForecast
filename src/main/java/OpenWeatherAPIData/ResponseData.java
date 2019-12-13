package OpenWeatherAPIData;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {
    public String cod;
    public int message;
    public int cnt;
    public List<list> list = new ArrayList<list>();
    public City city;

    public void printForecast(int numberOfDays)
    {
        int dayIndex = 0;
        for (int counter = 0; counter < numberOfDays ; counter++) {
            list.get(dayIndex).printForecast();
            dayIndex+=8;
        }
    }
}

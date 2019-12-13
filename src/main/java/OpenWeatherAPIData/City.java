package OpenWeatherAPIData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    public long id;
    public String name;
    //"coord":{ },
    public String country;
    public long population;
    public long timezone;
    public long sunrise;
    public long sunset;
}

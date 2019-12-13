package OpenWeatherAPIData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class list {
    public long dt;
    public HourlyDataSet main;
    public Weather[] weather;
    public Clouds clouds;
    public Wind wind;
    public Sys sys;
    public String dt_txt;

    private String getDate()
    {
        Date date = new Date( dt * 1000 );
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
    public void printForecast(){
        boolean contactByText = main.temp >= 75.0 && weather[0].main.equals("Sunny");
        boolean contactByEmail = main.temp_min > 55 && main.temp_max < 75;
        boolean contactByPhone = main.temp < 55 || weather[0].main.equals("Rain");
        System.out.println("For " + getDate());
        if(contactByText){
            System.out.println(String.format("Please contact by Text, as the temperature is %s and weather is %s ",
                    main.temp, weather[0].main));
        }else if(contactByEmail){
            System.out.println("Please contact by Email, as min and max temperaures are " + main.temp_min + ", " + main.temp_max);
        }else if(contactByPhone){
            System.out.println(String.format("Please contact by Phone, as temperature is %s and weather is %s ",
                    main.temp, weather[0].main));
        }else{
            System.out.println(String.format("No preferred contact option avilable. temperature is %s and weather is %s.",
                    main.temp, weather[0].main));
        }

    }

}

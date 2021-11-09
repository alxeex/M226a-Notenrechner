package ch.tbz;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class GetTime {

    private Map responseMap;

    public void getFromAPI(){
        try {
            URL url = new URL("http://worldtimeapi.org/api/timezone/Europe/Zurich");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            // gets the response as String

            // with stream buffer get response output
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            // reads line by line and adds it to string buffer
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            ObjectMapper mapper = new ObjectMapper();
            // parse String to Map
            responseMap = mapper.readValue(content.toString(), Map.class);


        }  catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void showAPIInfo() {
        try {
            System.out.println("Uhrzeit:\n" + responseMap.get("datetime") + "\nWoche:\n" + responseMap.get("week_number"));
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}

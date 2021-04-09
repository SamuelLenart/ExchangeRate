package sk.kosickaakademia.lenart.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiRequest {

    private static final String key = "7580cbb2ff99ae817c3cee37d843bc55";

    public Map getExchangeRate(Set<String> rate){
        if(rate==null || rate.size()==0)
            return null;
        return null;
    }

    private String getRatesFromAPIServer(){
        try {

            URL url = new URL("http://api.currencylayer.com/live?access_key="+key+"&format=1");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                return inline;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Map parseData(Set<String> rates){

        String inline=getRatesFromAPIServer();

        if(inline==null)
            return null;

        try {
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);

            JSONObject obj = (JSONObject) data_obj.get("rates");

            Map<String,Double> maps = new HashMap<>();

            for(String temp:rates){

                if(obj.containsKey(temp)){

                    double value= (double)obj.get(temp);
                    maps.put(temp,value);
                }
            }
            return maps;

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}

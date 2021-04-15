package sk.kosickaakademia.lenart.calc;

import sk.kosickaakademia.lenart.api.ApiRequest;
import sk.kosickaakademia.lenart.database.Database;

import java.util.*;

public class Calculator {

    private static final String[] rates = new String[]{"USD","CZK","HUF","PLN"};

    public void calculate(double eur){
        if(eur<0){
            System.out.println("Input number can't be a negative value!");
            return;
        }

        Set<String> set = new HashSet<>();
        Collections.addAll(set, rates);
        ApiRequest apiRequest = new ApiRequest();
        Map map = apiRequest.getExchangeRate(set);
        for(String temp:rates){
            if(map.containsKey(temp)){
                double value = (double) map.get(temp);
                double result = eur*value;
                print("EUR", temp, eur, result, value);
            }
        }
    }
    private void print(String from, String to, double eur, double result, double rate){
        System.out.println(eur+" "+from+" -> "+result+" "+to+" (exchange rate"+rate+" )");
    }

    public Map<String, Double> calculate(double base_currency_eur, String[] currency) {
        if(base_currency_eur<0){
            System.out.println("Input number can't be a negative value!");
            return null;
        }
        Database mongo=new Database();
        mongo.writeData(base_currency_eur,currency);
        Set<String> set=new HashSet<>();
        Collections.addAll(set, currency);
        ApiRequest apiRequest=new ApiRequest();
        Map map=apiRequest.getExchangeRate(set);
        Map<String,Double> values=new HashMap<>();
        Iterator<Map.Entry<String,Double>> itr=map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, Double> entry = itr.next();
            values.put(entry.getKey(),entry.getValue()*base_currency_eur);
        }

        return values;
    }
}

package sk.kosickaakademia.lenart.calc;

import sk.kosickaakademia.lenart.api.ApiRequest;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Calculator {

    private static final String[] rates = new String[]{"USD","CZK","HUF","PLN","BTC"};

    public void calculate(double eur){
        if(eur<0){
            System.out.println("What the fu-");
            return;
        }

        Set<String> set = Set.of(rates);
        ApiRequest apiRequest = new ApiRequest();
        Collections.addAll(set, rates);
        apiRequest.getExchangeRate(set);
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
}

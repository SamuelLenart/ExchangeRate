package sk.kosickaakademia.lenart;


import sk.kosickaakademia.lenart.calc.Calculator;

import java.util.HashSet;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Set<String> set = new HashSet<>();
        set.add("USD");
        set.add("PLN");
        set.add("CZK");
        set.add("BTC");

        Calculator calculator = new Calculator();
        calculator.calculate(42);
    }
}

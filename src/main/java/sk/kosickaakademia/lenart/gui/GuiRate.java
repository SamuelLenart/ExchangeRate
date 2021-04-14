package sk.kosickaakademia.lenart.gui;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import sk.kosickaakademia.lenart.calc.Calculator;

import java.util.Map;

public class GuiRate {
    private static final String[] currency= new String[]{"USD","CZK","HUF","PLN"};
    private Button btn_exchange;
    private TextField txt_eur;
    private ListView classic;
    public TextField txt_usd;
    public TextField txt_czk;
    public TextField txt_huf;
    public TextField txt_pln;

    public void exchange(ActionEvent actionEvent) {
        Calculator calc=new Calculator();
        String base_currency=txt_eur.getText();
        if (base_currency.isEmpty()){
            return;
        }
        double base_currency_eur=Double.parseDouble(base_currency);
        calc.calculate(base_currency_eur,currency);

    }
}

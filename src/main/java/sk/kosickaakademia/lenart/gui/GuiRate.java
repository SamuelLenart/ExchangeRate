package sk.kosickaakademia.lenart.gui;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import sk.kosickaakademia.lenart.calc.Calculator;

import java.text.DecimalFormat;
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
    public TextField txt_btc;

    public void exchange(ActionEvent actionEvent) {
        String value = txt_eur.getText();
        double valueEur=Double.parseDouble(value);
        Calculator calc=new Calculator();
        Map results = calc.calculate(valueEur,currency);
        txt_czk.setText(convertTo2Decimal((double)results.get("CZK")));
        txt_huf.setText(convertTo2Decimal((double)results.get("HUF")));
        txt_pln.setText(convertTo2Decimal((double)results.get("PLN")));
        txt_usd.setText(convertTo2Decimal((double)results.get("PLN")));
        txt_btc.setText(results.get("BTC").toString());
        double base_currency_eur=Double.parseDouble(value);
        calc.calculate(base_currency_eur,currency);
    }
    private String convertTo2Decimal(double value){
        DecimalFormat df = new DecimalFormat("#.00");
        String angleFormated = df.format(value);
        return angleFormated;
    }
}

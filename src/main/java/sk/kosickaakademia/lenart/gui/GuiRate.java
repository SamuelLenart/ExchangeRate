package sk.kosickaakademia.lenart.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import sk.kosickaakademia.lenart.calc.Calculator;

import java.text.DecimalFormat;
import java.util.Map;

public class GuiRate {
    Calculator calc=new Calculator();
    private static final String[] currency= new String[]{"USD","CZK","HUF","PLN","BTC"};
    @FXML
    private TextField txt_eur;
    private ListView classic;
    public TextField txt_usd;
    public TextField txt_czk;
    public TextField txt_huf;
    public TextField txt_pln;
    public TextField txt_btc;
    public Label label_error;

    public void exchange(ActionEvent event) {
        try {
            String value = txt_eur.getText();
            double valueEur = Double.parseDouble(value);
            if (valueEur <= 0) {
                txt_czk.clear();
                txt_huf.clear();
                txt_pln.clear();
                txt_usd.clear();
                txt_btc.clear();
                label_error.setVisible(true);
            } else {
                label_error.setVisible(false);
                Map results = calc.calculate(valueEur, currency);
                txt_czk.setText(convertTo2Decimal((double) results.get("CZK")));
                txt_huf.setText(convertTo2Decimal((double) results.get("HUF")));
                txt_pln.setText(convertTo2Decimal((double) results.get("PLN")));
                txt_usd.setText(convertTo2Decimal((double) results.get("USD")));
                txt_btc.setText(results.get("BTC").toString());
                double base_currency_eur = Double.parseDouble(value);
                calc.calculate(base_currency_eur, currency);
            }
        } catch (NumberFormatException e) {
            txt_czk.clear();
            txt_huf.clear();
            txt_pln.clear();
            txt_usd.clear();
            txt_btc.clear();
            label_error.setVisible(true);
        }
    }
    private String convertTo2Decimal(double value){
        DecimalFormat df = new DecimalFormat("#.00");
        String angleFormated = df.format(value);
        return angleFormated;
    }
}

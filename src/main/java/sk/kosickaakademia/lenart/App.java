package sk.kosickaakademia.lenart;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.kosickaakademia.lenart.calc.Calculator;
import sk.kosickaakademia.lenart.database.Database;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("GuiFx.fxml"));
        primaryStage.setTitle("CurrencyExchanger");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
        Database database=new Database();
        database.test();
    }
    }


package sk.kosickaakademia.lenart;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.kosickaakademia.lenart.database.Database;

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GuiFx.fxml"));
        primaryStage.setTitle("CurrencyExchanger3000");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        Database database=new Database();
    }
}

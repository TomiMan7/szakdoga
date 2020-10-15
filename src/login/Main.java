package login;

import Database.Employees;
import Database.Shop;
import Database.Wagemods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Please log in.");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();

        try
        {
            Employees.Connect();
            Shop.Connect();
            Wagemods.Connect();

        } catch (Exception e)
        {
            loginController.alert("Cant connect to database! Please check your connection");
        }

    }


    public void main(String[] args) {
        launch(args);
    }
}

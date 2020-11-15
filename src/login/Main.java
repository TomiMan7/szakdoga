package login;

import Database.Employees;
import Database.Shop;
import Database.Wagemods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Kérem jelentkezzen be!");
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
            LoginController.alert("Nem sikerült az adatbázishoz csatlakozni!" +
                    "Kérem ellenőrizze a kapcsolatát és az adatbázis elérhetőségét");
        }

    }


    public void main(String[] args) {
        launch(args);
    }
}

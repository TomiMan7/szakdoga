package login;

import Database.Employees;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController
{
    @FXML
    private javafx.scene.control.Button loginbutton;

    @FXML
    private javafx.scene.control.ComboBox combobox;

    @FXML
    private com.gluonhq.charm.glisten.control.TextField username;

    @FXML
    private javafx.scene.control.PasswordField password;

    public static void alert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Információ!!");
        alert.setHeight(300);
        alert.setWidth(200);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public void LoginAs()
    {
        ArrayList name = Employees.getPermissionsData("name", "name", username.getText());
        ArrayList pass = Employees.getPermissionsData("password", "password", password.getText());

        int loginas = 0; // csak inicializalas miatt 0
        if (combobox.getValue().toString().equals("Könyvelő"))
            loginas = 3; //a DB-ben a konyvelo permission helye
        else if (combobox.getValue().toString().equals("Értékesítő"))
            loginas = 2; //a DB-ben az elado permission helye

        if ( name.contains(username.getText()) && pass.contains(password.getText()) && name.get(loginas).equals(1))
        {
            if (combobox.getValue().toString().equals("Könyvelő")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/accountantpage/accountantpage.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.resizableProperty().setValue(false);
                    stage.setTitle("Könyvelő főoldal:");
                    stage.show();

                    Stage stage2 = (Stage) loginbutton.getScene().getWindow();
                    stage2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (combobox.getValue().toString().equals("Értékesítő")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/salesmanpage/salesmanpage.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.resizableProperty().setValue(false);
                    stage.setTitle("Eladói főoldal:");
                    stage.show();

                    Stage stage2 = (Stage) loginbutton.getScene().getWindow();
                    stage2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                alert("Kérem válasszon ki egy belépési kategóriát!");
            }
        }
        else
        {
            alert("Rossz felhasználónév/jelszó vagy hiányzó adatok!");
        }
    }


}

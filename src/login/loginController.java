package login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController
{
    @FXML
    private javafx.scene.control.Button loginbutton;

    @FXML
    private javafx.scene.control.ComboBox combobox;

    public static void alert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setHeight(300);
        alert.setWidth(200);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public void LoginAs()
    {
        if(combobox.getValue().toString().equals("Accountant"))
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/accountantpage/accountantpage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root1));
                stage.resizableProperty().setValue(false);
                stage.setTitle("Accountant Infopage");
                stage.show();

                Stage stage2 = (Stage) loginbutton.getScene().getWindow();
                stage2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(combobox.getValue().toString().equals("Salesman"))
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/salesmanpage/salesmanpage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root1));
                stage.resizableProperty().setValue(false);
                stage.setTitle("Shop");
                stage.show();

                Stage stage2 = (Stage) loginbutton.getScene().getWindow();
                stage2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        else if(combobox.getValue().toString().equals("Manager"))
//        {
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(".fxml"));
//                Parent root1 = (Parent) fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.setScene(new Scene(root1));
//                stage.resizableProperty().setValue(false);
//                stage.setTitle("Manager");
//                stage.show();
//
//                Stage stage2 = (Stage) loginbutton.getScene().getWindow();
//                stage2.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        else
        {
            alert("Please select a category to log in!");
        }
    }


}

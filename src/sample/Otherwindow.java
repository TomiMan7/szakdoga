package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Otherwindow
{
    @FXML
    private javafx.scene.control.Button button; //az a gomb ID-je amivel be akarom zarni
    public void press(ActionEvent event)
    {
        System.out.println("Hello");

        // get a handle to the stage
        Stage stage = (Stage) button.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
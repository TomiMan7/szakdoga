package accountantpage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class accountantpageController
{

    @FXML
    private javafx.scene.control.MenuItem dbUpdate;

    @FXML
    private javafx.scene.control.ListView nameList;

    public void dbInsertPage()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("accountantInsert.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Insert into database");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dbUpdatePage()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("accountantUpdate.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Accountant Infopage");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void workhoursScreen()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("workHours.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Confirm work hours");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leavesScreen()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("leaves.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Confirm work hours");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNameList()
    {
//        nameList.getItems().setAll("asd","wer","wewe");
    }

    public void getNameList()
    {
//        System.out.println(nameList.getSelectionModel().getSelectedItem().toString());
    }
}

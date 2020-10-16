package accountantpage;

import Database.Employees;
import Database.Wagemods;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class accountantpageController
{

    @FXML
    public Label nyugdijLevonas;
    @FXML
    public Label tbPercentage;
    @FXML
    public Label tbLevonas;
    @FXML
    public Label szjaPercentage;
    @FXML
    public Label szjaLevonas;
    @FXML
    public Label mpjPercentage;
    @FXML
    public Label mpjLevonas;
    @FXML
    public Label takarekPercentage;
    @FXML
    public Label takarekLevonas;
    @FXML
    public Label employeename;
    @FXML
    public Label nameLabel;
    @FXML
    public Label positionLabel;
    @FXML
    public Label phoneLabel;
    @FXML
    public Label emailLabel;
    @FXML
    public Label postLabel;
    @FXML
    public Label wageLabel;
    @FXML
    public Label workhoursLabel;
    @FXML
    public Label leavehoursLabel;
    @FXML
    private javafx.scene.control.MenuItem dbUpdate;
    @FXML
    private javafx.scene.control.ListView nameList;
    @FXML
    private javafx.scene.control.Label nyugdijPercentage;


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
        ArrayList array = Employees.getAllEmployeeData();
        ArrayList names = new ArrayList();
        for(int i = 1; i < array.size(); i = i+7)
            names.add(array.get(i));

        nameList.getItems().setAll(names);
    }

    public void getNameList()
    {
        ArrayList wagemods = Wagemods.getAll(nameList.getSelectionModel().getSelectedItem().toString());

        employeename.setText(nameList.getSelectionModel().getSelectedItem().toString());
        nyugdijPercentage.setText(wagemods.get(2).toString());
        tbPercentage.setText(wagemods.get(3).toString());
        szjaPercentage.setText(wagemods.get(4).toString());
        mpjPercentage.setText(wagemods.get(5).toString());
        takarekPercentage.setText(wagemods.get(6).toString());

        ArrayList details = Employees.getEmployeeData("name", nameList.getSelectionModel().getSelectedItem().toString());
        nameLabel.setText(details.get(1).toString());
        positionLabel.setText(details.get(4).toString());
        phoneLabel.setText(details.get(2).toString());
        emailLabel.setText(details.get(5).toString());
        wageLabel.setText(details.get(6).toString());

        currentDate();
    }

    public void currentDate()
    {
        ArrayList date = new ArrayList();
        LocalDate now = LocalDate.now();
        date.add(now.toString().split("-"));
        System.out.println(date.get(0).toString());
    }
}

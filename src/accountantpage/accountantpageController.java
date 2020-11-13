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
    public Label wageLabel;
    @FXML
    public Label workhoursLabel;
    @FXML
    public Label leavehoursLabel;
    public Label sickpayLabel;
    public Label netto;
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

        int id = Integer.parseInt(details.get(0).toString());

        nameLabel.setText(details.get(1).toString());
        positionLabel.setText(details.get(4).toString());
        phoneLabel.setText(details.get(2).toString());
        emailLabel.setText(details.get(3).toString());
        wageLabel.setText(details.get(5).toString());
        int baseWorkHours = Integer.parseInt( details.get(6).toString());

        String[] currentdates = currentDate();

        ArrayList workedHours = Employees.getHoursWorked(nameList.getSelectionModel().getSelectedItem().toString(),currentdates[0],currentdates[1] );

        int allWorkedHours = 0;
        for(int i = 0; i <= workedHours.size()-1; i++)
        {
            allWorkedHours += Integer.parseInt(workedHours.get(i).toString());
        }

        workhoursLabel.setText( String.valueOf(allWorkedHours));

        ArrayList leavedHours = Employees.getHoursLeft(id, currentdates[0], currentdates[1]);
        int totalLeftHours = 0;
        int skip = 0;
        int sickpay = 0;
        for(int i = 0; i <= leavedHours.size() - 3; i=i+3)
        {
            if(skip <= 2) //minden 3 a tappenzt jelzo bejegyzes ezert skippelunk
            {
                if( Integer.parseInt(leavedHours.get(i+2).toString()) == 0) {
                    totalLeftHours += Integer.parseInt(leavedHours.get(i + 1).toString()) - Integer.parseInt(leavedHours.get(i).toString());
                    skip++;
                }
                else
                {
                    skip++;
                    sickpay += Integer.parseInt(leavedHours.get(i + 1).toString()) - Integer.parseInt(leavedHours.get(i).toString());
                }
            }
            else
            {
                skip = 0;
            }
        }

        int wage =  Integer.parseInt(wageLabel.getText()) * Integer.parseInt( workhoursLabel.getText());
        wage += sickpay*baseWorkHours;

        nyugdijLevonas.setText( String.valueOf( wage / 100 * Integer.parseInt( nyugdijPercentage.getText() ) ));
        tbLevonas.setText(String.valueOf( wage / 100 * Integer.parseInt( tbPercentage.getText() ) ));
        szjaLevonas.setText(String.valueOf( wage / 100 * Integer.parseInt( szjaPercentage.getText() ) ));
        mpjLevonas.setText(String.valueOf( wage / 100 * Float.parseFloat( mpjPercentage.getText() ) ));
        takarekLevonas.setText(takarekPercentage.getText());//(String.valueOf( wage / 100 * Integer.parseInt( takarekPercentage.getText() ) ));

        float nettoWage =  Float.parseFloat(nyugdijLevonas.getText()) +  Float.parseFloat(tbLevonas.getText()) + Float.parseFloat(szjaLevonas.getText()) + Float.parseFloat(mpjLevonas.getText()) + Float.parseFloat(takarekLevonas.getText());
        netto.setText( String.valueOf(wage - nettoWage));
        leavehoursLabel.setText( String.valueOf(totalLeftHours));
        sickpayLabel.setText(String.valueOf(sickpay));
    }

    public String[] currentDate()
    {
        String[] date;
        String date2;
        LocalDate now = LocalDate.now();
        date2 = now.toString();
        date = date2.split("-",3);

//        System.out.println(date[0]);
//        System.out.println(date[1]);
//        System.out.println(date[2]);

        return date;
    }
}

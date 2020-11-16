package accountantpage;

import Database.Employees;
import Database.Wagemods;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import login.LoginController;

import java.util.ArrayList;

public class AccountantUpdateController
{
    public ComboBox empNameList;
    public Label first;
    public Label second;
    public Label third;
    public Label fourth;
    public Label fifth;
    public Label sixth;
    public Label firstText;
    public Label secondText;
    public Label thirdText;
    public Label fourthText;
    public Label fifthText;
    public Label sixthText;
    public TextField firstInput;
    public TextField secondInput;
    public TextField thirdInput;
    public TextField fourthInput;
    public TextField fifthInput;
    public TextField sixthInput;

    public void fillNames()
    {
        ArrayList names = Employees.getWhatEmployee("name");

        empNameList.getItems().clear();
        empNameList.getItems().addAll(names);
        empNameList.setPromptText("Dolgozók nevei:");
    }

    public void clearInput()
    {
        firstInput.setText("");
        secondInput.setText("");
        thirdInput.setText("");
        fourthInput.setText("");
        fifthInput.setText("");
        sixthInput.setText("");
    }

    public void setLabels(ArrayList list)
    {
        firstText.setText(list.get(1).toString());
        secondText.setText(list.get(2).toString());
        thirdText.setText(list.get(3).toString());
        fourthText.setText(list.get(4).toString());
        fifthText.setText(list.get(5).toString());
        sixthText.setText(list.get(6).toString());
    }

    public void searchForEmployee()
    {
        ArrayList employeeData = Employees.getEmployeeData("name",empNameList.getValue().toString());

        clearInput();

        first.setText("Név:");
        second.setText("Telefon:");
        third.setText("Email:");
        fourth.setText("Beosztás:");
        fifth.setText("Br. Bér:");
        sixth.setText("Munkaórák:");

        setLabels(employeeData);
    }

    public void searchForWagemods()
    {
        ArrayList wagemods = Wagemods.getAll(empNameList.getValue().toString());

        clearInput();

        first.setText("Név:");
        second.setText("Nyugdíj:");
        third.setText("TB:");
        fourth.setText("SZJA:");
        fifth.setText("MPJ:");
        sixth.setText("Nyugdíj takarék:");

        setLabels(wagemods);
    }

    public void firstLabel()
    {
        firstInput.setText(firstText.getText());
    }

    public void secondLabel()
    {
        secondInput.setText(secondText.getText());
    }

    public void thirdLabel()
    {
        thirdInput.setText(thirdText.getText());
    }

    public void fourthLabel()
    {
        fourthInput.setText(fourthText.getText());
    }

    public void FifthLabel()
    {
        fifthInput.setText(fifthText.getText());
    }

    public void sixthLabel()
    {
        sixthInput.setText(sixthText.getText());
    }

    public void deleteEmployee()
    {
//        if(second.getText().equals("Telefon:"))
            Employees.deleteFromDbEmployees("employees", "name", firstText.getText());

//        else if(second.getText().equals("Nyugdíj:"))
            Wagemods.deleteWage("name", firstText.getText());

//        else
//            LoginController.alert("Nem lehet törölni!");

        clearInput();
    }
    public void updateEmployee()
    {
        if(second.getText().equals("Telefon:"))
        {
            Employees.updateEmployee("name", firstInput.getText(), "name", firstText.getText());
            Employees.updateEmployee("phone", secondInput.getText(), "phone", secondText.getText());
            Employees.updateEmployee("email", thirdInput.getText(), "email", thirdText.getText());
            Employees.updateEmployee("post", fourthInput.getText(), "post", fourthText.getText());
            Employees.updateEmployee("wage", fifthInput.getText(), "wage", fifthText.getText());
            Employees.updateEmployee("whours", sixthInput.getText(), "whours", sixthText.getText());
            fillNames();
        }
        else if(second.getText().equals("Nyugdíj:"))
        {
            Wagemods.updateColumn("name", firstInput.getText(), "name", firstText.getText());
            Wagemods.updateColumn("nyugdij", secondInput.getText(), "name", firstText.getText());
            Wagemods.updateColumn("tb", thirdInput.getText(), "name", firstText.getText());
            Wagemods.updateColumn("szja", fourthInput.getText(), "name", firstText.getText());
            Wagemods.updateColumn("mpj", fifthInput.getText(), "name", firstText.getText());
            Wagemods.updateColumn("nyugdijtakarek", sixthInput.getText(), "name", firstText.getText());
            fillNames();
        }

        else
        {
            LoginController.alert("Nem megfelelő update!");
        }

        clearInput();
    }
}

package accountantpage;

import Database.Employees;
import Database.Wagemods;
import javafx.fxml.FXML;

public class AccountantInsertController
{
    @FXML
    private javafx.scene.control.ComboBox tableName;
    @FXML
    private com.gluonhq.charm.glisten.control.TextField firstInput;
    @FXML
    private com.gluonhq.charm.glisten.control.TextField secondInput;
    @FXML
    private com.gluonhq.charm.glisten.control.TextField thirdInput;
    @FXML
    private com.gluonhq.charm.glisten.control.TextField fourthInput;
    @FXML
    private com.gluonhq.charm.glisten.control.TextField fifthInput;
    @FXML
    private com.gluonhq.charm.glisten.control.TextField sixthInput;

    public void insert()
    {
        if(tableName.getValue().toString().equals("Dolgozók"))
        {
            Employees.insertEmployee(firstInput.getText(), secondInput.getText(), thirdInput.getText(), fourthInput.getText(), fifthInput.getText(), sixthInput.getText());
        }
        else if(tableName.getValue().toString().equals("Levonások"))
        {
            Wagemods.insert(firstInput.getText(), secondInput.getText(), thirdInput.getText(), fourthInput.getText(), fifthInput.getText(), sixthInput.getText());
        }
        clearFields();
    }

    public void clearFields()
    {
        firstInput.setFloatText("");
        firstInput.setText("");
        secondInput.setFloatText("");
        secondInput.setText("");
        thirdInput.setFloatText("");
        thirdInput.setText("");
        fourthInput.setFloatText("");
        fourthInput.setText("");
        fifthInput.setFloatText("");
        fifthInput.setText("");
        sixthInput.setFloatText("");
        sixthInput.setText("");
    }

    public void setTextFields()
    {
        if(tableName.getValue().toString().equals("Dolgozók"))
        {
            firstInput.setFloatText("Név:");
            secondInput.setFloatText("Telefon:");
            thirdInput.setFloatText("E-mail:");
            fourthInput.setFloatText("Beosztás:");
            fifthInput.setFloatText("Br. Bér:");
            sixthInput.setFloatText("Munkaórák:");
        }
        else
        {
            firstInput.setFloatText("Név:");
            secondInput.setFloatText("Nyugdíj (%):");
            thirdInput.setFloatText("Társadalombiztosítás (%):");
            fourthInput.setFloatText("Személyi jövedelem adó (%):");
            fifthInput.setFloatText("Munkaerőpiaci járulék (%):");
            sixthInput.setFloatText("Nyugdíj takarék:");
        }
    }

}

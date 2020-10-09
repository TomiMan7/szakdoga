package accountantpage;

import javafx.fxml.FXML;

public class accountantInsertController
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



    public void setTextFields()
    {
        if(tableName.getValue().toString().equals("Employees"))
        {
            firstInput.setFloatText("name:");
            secondInput.setFloatText("phone:");
            thirdInput.setFloatText("email:");
            fourthInput.setFloatText("post:");
            fifthInput.setFloatText("wage:");
            sixthInput.setFloatText("working hours:");
        }
        else
        {
            firstInput.setFloatText("name:");
            secondInput.setFloatText("pension(%):");
            thirdInput.setFloatText("social insurance(%)");
            fourthInput.setFloatText("personal income tax(%)");
            fifthInput.setFloatText("labor market contribution(%)");
            sixthInput.setFloatText("personal savings");
        }
    }

}

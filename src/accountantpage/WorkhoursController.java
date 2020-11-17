package accountantpage;

import Database.Employees;
import Database.Wagemods;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class WorkhoursController
{
    public ListView nameList;
    public TextField nameInput;
    public TextField hourInput;
    @FXML
    private javafx.scene.control.DatePicker date;

    public void setNameList()
    {
        ArrayList array = Employees.getAllEmployeeData();
        ArrayList names = new ArrayList();
        for(int i = 1; i < array.size(); i = i+7)
            names.add(array.get(i));
        nameList.getItems().setAll(names);
    }

    public void setNameInput()
    {
        try {
            nameInput.setText(nameList.getSelectionModel().getSelectedItem().toString());
        }catch (Exception e){
            Wagemods.alert("Válasszon ki dolgozót!");
        }
    }

    public String[] datumre()
    {
        return date.getValue().toString().split("-", 3);
    }

    public void insert()
    {
        try {
            String[] datum = datumre();
            Employees.insertWhours(nameInput.getText(), datum[0].toString(), datum[1], datum[2], hourInput.getText());
            clearInputs();
        }catch (Exception e){
            Wagemods.alert("Válassza ki a megfelelő adatot!");
        }
    }

    public void clearInputs()
    {
        nameInput.setText("");
        hourInput.setText("");
        date.getEditor().clear();
    }
}

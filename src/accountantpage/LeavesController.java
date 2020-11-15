package accountantpage;

import Database.Employees;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class LeavesController
{

    public DatePicker startdate;
    public DatePicker enddate;
    public CheckBox sickpay;
    public ListView nameList;

    public String[] datumStart()
    {
        return startdate.getValue().toString().split("-", 3);
    }

    public String[] datumStop()
    {
        return enddate.getValue().toString().split("-", 3);
    }

    public void setNameList()
    {
        ArrayList array = Employees.getAllEmployeeData();
        ArrayList names = new ArrayList();
        for(int i = 1; i < array.size(); i = i+7)
            names.add(array.get(i));
        nameList.getItems().setAll(names);
    }

    public void insert()
    {
        String[] datumstart = datumStart();
        String[] datumstop = datumStop();

        int tappenz = 0;

        if(sickpay.isSelected() )
            tappenz = 1;
        else
            tappenz = 0;

        ArrayList workerid = Employees.getEmployeeData("name", nameList.getSelectionModel().getSelectedItem().toString());

        Employees.insertLeaves(datumstart[0], datumstart[1], datumstart[2], datumstop[0], datumstop[1], datumstop[2], tappenz,  Integer.parseInt( workerid.get(0).toString() ));
    }

}

package accountantpage;

import javafx.fxml.FXML;

public class workhoursController
{
    @FXML
    private javafx.scene.control.DatePicker date;

    public String[] returnDate()
    {
        return date.getValue().toString().split("-", 99);
//        String[] dates = date.getValue().toString().split("-", 99);
//        for(String d : dates)
//        {
//            System.out.println(d);
//        }
    }
}

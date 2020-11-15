package salesmanpage;

import Database.Employees;
import Database.Shop;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CustomerUpdateController
{
    public ListView list;
    public Label nameOut;
    public Label phoneOut;
    public Label emailOut;
    public Label cityOut;
    public Label streetOut;
    public TextField nameIn;
    public TextField phoneIn;
    public TextField emailIn;
    public TextField cityIn;
    public TextField streetIn;
    public TextField housenumberIn;
    public Label housenumberOut;


    public void getNames()
    {
        ArrayList names = Shop.getAllCustomerData();

        list.getItems().clear();
        for(int i = 1; i < names.size() - 1; i=i+7){
            list.getItems().addAll(names.get(i).toString());
            if(i+7 > names.size()){
                break;
            }
        }
    }

    public void getCustomerData()
    {
        String name = list.getSelectionModel().getSelectedItem().toString();
        ArrayList data = Shop.getCustomerData("name", name);

        nameOut.setText(data.get(1).toString() );
        phoneOut.setText(data.get(2).toString());
        emailOut.setText(data.get(3).toString());
        cityOut.setText(data.get(4).toString());
        streetOut.setText(data.get(5).toString());
        housenumberOut.setText(data.get(6).toString());
    }

    public void clearLabels(){
        nameIn.setText("");
        nameOut.setText("");
        phoneIn.setText("");
        phoneOut.setText("");
        emailIn.setText("");
        emailOut.setText("");
        cityIn.setText("");
        cityOut.setText("");
        streetIn.setText("");
        streetOut.setText("");
        housenumberIn.setText("");
        housenumberOut.setText("");
    }

    public void update()
    {
        Shop.updateCustomer(nameIn.getText(), phoneIn.getText(), emailIn.getText(), cityIn.getText(), streetIn.getText(), housenumberIn.getText(), nameOut.getText(), phoneOut.getText(), emailOut.getText());
        clearLabels();
    }

    public void delete()
    {
        ArrayList customerData = Shop.getCustomerData("name", nameOut.getText());
        String id = customerData.get(0).toString();
        Shop.updateOrders("date", "CANCELED", "id", id);
       // Shop.deleteCustomer(nameOut.getText(), phoneOut.getText(), emailOut.getText());
        clearLabels();
    }

    public void setNameIn()
    {
        nameIn.setText(nameOut.getText());
    }

    public void setPhoneIn()
    {
        phoneIn.setText(phoneOut.getText());
    }

    public void setEmailIn()
    {
        emailIn.setText(emailOut.getText());
    }

    public void setCityIn()
    {
        cityIn.setText(cityOut.getText());
    }

    public void setStreetIn()
    {
        streetIn.setText(streetOut.getText());
    }

    public void setHousenumberIn()
    {
        housenumberIn.setText(housenumberOut.getText());
    }
}

package salesmanpage;

import Database.Shop;
import Database.Wagemods;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class CustomerInsertController
{
    public TextField name;
    public TextField phone;
    public TextField email;
    public TextField city;
    public TextField street;
    public TextField housenumber;

    public CheckBox paymentMethod;
    public TextField amount;

    public void insertCustomer()
    {
        try {
            String cash = "0";
            if (paymentMethod.isSelected())
                cash = "1";

            ArrayList newCustomer = new ArrayList();
            ArrayList customer = Shop.getACustomer(name.getText(), phone.getText(), email.getText(), city.getText(), street.getText(), housenumber.getText());

            if (customer.size() == 0) {
                Shop.insertCustomer(name.getText(), phone.getText(), email.getText(), city.getText(), street.getText(), housenumber.getText());
                newCustomer = Shop.getACustomer(name.getText(), phone.getText(), email.getText(), city.getText(), street.getText(), housenumber.getText());
                Shop.insertOrders(Integer.parseInt(newCustomer.get(0).toString()), Integer.parseInt(SalesmanpageController.main.get(0).toString()), cash, amount.getText(), String.valueOf(Integer.parseInt(SalesmanpageController.main.get(9).toString()) * Integer.parseInt(amount.getText())), java.time.LocalDate.now().toString());
            } else {
                Shop.insertOrders(Integer.parseInt(customer.get(0).toString()), Integer.parseInt(SalesmanpageController.main.get(0).toString()), cash, amount.getText(), String.valueOf(Integer.parseInt(SalesmanpageController.main.get(9).toString()) * Integer.parseInt(amount.getText())), java.time.LocalDate.now().toString());
            }

            clearInputs();
        }catch (Exception e)
        {
            Wagemods.alert("Töltsön ki minden mezőt!");
        }
    }

    public void clearInputs()
    {
        name.setText("");
        phone.setText("");
        email.setText("");
        city.setText("");
        street.setText("");
        housenumber.setText("");
        amount.setText("");
        paymentMethod.setSelected(false);
    }
}

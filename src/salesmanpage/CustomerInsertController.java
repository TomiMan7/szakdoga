package salesmanpage;

import Database.Shop;
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

    public static String vendorLabel;
    public static String nameLabel;
    public static String cpuLabel;
    public static String gpuLabel;
    public static String ramLabel;
    public static String storageLabel;
    public static String screenLabel;
    public static String amountLabel;
    public static String priceLabel;
    public CheckBox paymentMethod;

    //megnezni h ha mar van ilyen customer akkor annak leszdni az IDjet ha nincs akkor felvenni es annak az IDja
    public void insertCustomer()
    {
        SalesmanpageController.main.forEach(n -> System.out.println(n));
        int cash = 0;
        if(paymentMethod.isSelected())
            cash = 1;

//        ArrayList customerId = Shop.getCustomerData( "name", name.getText());

        System.out.println(cash);
//        System.out.println(customerId.get(1));
//        System.out.println(laptopId.get(1));


       //Shop.insertCustomer(name.getText(), phone.getText(), email.getText(), city.getText(), street.getText(), housenumber.getText());
       //kell customer id, laptop id, milyen fizetesi modszer
       //Shop.insertOrders(  customerId.get(1), laptopId, cash, "1",priceLabel,java.time.LocalDate.now());
    }
}

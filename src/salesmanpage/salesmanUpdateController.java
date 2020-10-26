package salesmanpage;

import Database.Shop;
import javafx.scene.control.*;

import java.util.ArrayList;

public class salesmanUpdateController
{
    public Label vendorOut;
    public Label nameOut;
    public Label specidOut;
    public Label amountOut;
    public Label availabilityOut;
    public TextField vendorIn;
    public TextField nameIn;
    public TextField specidIn;
    public TextField amountIn;
    public TextField availabilityIn;
    public ComboBox name;
    public ComboBox specid;
    public ComboBox amount;
    public ComboBox availability;
    public TextArea description;
    public ListView list;
    public Label cpuOut;
    public Label gpuOut;
    public Label ramOut;
    public Label storageOut;
    public Label screenOut;
    public TextField cpuIn;
    public TextField gpuIn;
    public TextField ramIn;
    public TextField storageIn;
    public TextField screenIn;
    public Label priceOut;
    public TextField priceIn;
    public ComboBox vendor;


    public void updateSearch()
    {
        ArrayList laptops = Shop.getAllLaptopsData();
        ArrayList specs = Shop.getAllSpecificationData();

        for(int i = 1; i < laptops.size(); i=i+7)
            vendor.getItems().addAll(laptops.get(i).toString());

        for(int i = 2; i < laptops.size(); i=i+7)
            name.getItems().addAll(laptops.get(i).toString());

        for(int i = 3; i < laptops.size(); i=i+7)
            specid.getItems().addAll(laptops.get(i).toString());

        for(int i = 4; i < laptops.size(); i=i+7)
            amount.getItems().addAll(laptops.get(i).toString());

        for(int i = 5; i < laptops.size(); i=i+7)
            availability.getItems().addAll(laptops.get(i).toString());
    }

    public void Search()
    {
        String vendorText = "";
        try {
            vendorText = vendor.getSelectionModel().getSelectedItem().toString();
        }catch (Exception e)
        {
            if(vendorText == null || vendorText.equals(""))
                vendorText = "kurva anyadat";
        }



        System.out.println(vendorText);

//        ArrayList laptops =  Shop.getaSpecification("cpu", "", "gpu", "", "ram", "gb", "storage", "ssd", "screen", "IPS");

//        for(int i = 0; i < laptops.size(); i++)
//            System.out.println(laptops.get(i).toString());
    }
}

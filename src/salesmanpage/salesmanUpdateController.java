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


    public void clearMenus()
    {
        vendor.getItems().clear();
        vendor.getSelectionModel().clearSelection();
        vendor.setPromptText("Gyártó");

        name.getItems().clear();
        name.getSelectionModel().clearSelection();
        name.setPromptText("Név");

        specid.getItems().clear();
        specid.getSelectionModel().clearSelection();
        specid.setPromptText("Spec.ID");

        amount.getItems().clear();
        amount.getSelectionModel().clearSelection();
        amount.setPromptText("Mennyiseg");

        availability.getItems().clear();
        availability.getSelectionModel().clearSelection();
        availability.setPromptText("Elérhetőség");
    }

    public void setMenus(ArrayList laptops)
    {
//        clearMenus();
        for(int i = 1; i < laptops.size(); i=i+7)
            vendor.getItems().addAll(laptops.get(i).toString());

        for(int i = 2; i < laptops.size(); i=i+7)
            name.getItems().addAll(laptops.get(i).toString());

        for(int i = 3; i < laptops.size(); i=i+7)
            specid.getItems().addAll(laptops.get(i).toString());

        for(int i = 4; i < laptops.size(); i=i+7)
            amount.getItems().addAll(laptops.get(i).toString());

        for(int i = 6; i < laptops.size(); i=i+7)
            availability.getItems().addAll(laptops.get(i).toString());
    }

    public void updateSearch()
    {
        clearMenus();
        ArrayList laptops = Shop.getAllLaptopsData();
        //ArrayList specs = Shop.getAllSpecificationData();
        setMenus(laptops);
    }

    public void vendor()
    {
        String vendorText = vendor.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("vendor", vendorText);
        clearMenus();
        setMenus(laptops);
        vendor.setPromptText(vendorText);
    }

    public void name()
    {
        String nameText = name.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("name", nameText);
        clearMenus();
        setMenus(laptops);
        name.setPromptText(nameText);
    }

    public void specid()
    {
        String specidText = specid.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("specid", specidText);
        clearMenus();
        setMenus(laptops);
        specid.setPromptText(specidText);
    }

    public void amount()
    {
        String amountText = amount.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("amount", amountText);
        clearMenus();
        setMenus(laptops);
        amount.setPromptText(amountText);
    }

    public void availability()
    {
        String availabilityText = availability.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("availability", availabilityText);
        clearMenus();
        setMenus(laptops);
        availability.setPromptText(availabilityText);
    }

    public void Search()
    {
        String vendorText = "";
        try {
            vendorText = vendor.getSelectionModel().getSelectedItem().toString();
        }catch (Exception e)
        {
            if(vendorText == null || vendorText.equals(""))
                vendorText = "";
        }



        System.out.println(vendorText);

//        ArrayList laptops =  Shop.getaSpecification("cpu", "", "gpu", "", "ram", "gb", "storage", "ssd", "screen", "IPS");

//        for(int i = 0; i < laptops.size(); i++)
//            System.out.println(laptops.get(i).toString());
    }
}

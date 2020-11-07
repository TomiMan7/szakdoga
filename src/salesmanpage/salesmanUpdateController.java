package salesmanpage;

import Database.Shop;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.lang.reflect.InvocationTargetException;
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


    public void clearMenus(){
        vendor.getItems().setAll("");
        try {
            vendor.getItems().remove(0);
        }catch (Exception e){}


        name.getItems().setAll("");
        try {
            name.getItems().remove(0);
        }catch (Exception e){}

        name.getSelectionModel().clearSelection();
        vendor.getSelectionModel().clearSelection();

        vendor.setPromptText("Gyártó");
        name.setPromptText("Név");
    }

    public void setMenus(ArrayList laptops)
    {
        clearMenus();

        for(int i = 1; i < laptops.size(); i=i+7)
            vendor.getItems().add(laptops.get(i).toString());

        for(int i = 2; i < laptops.size(); i=i+7)
            name.getItems().add(laptops.get(i).toString());
    }

    public void updateSearch(){
        ArrayList laptops = Shop.getAllLaptopsData();
        setMenus(laptops);
    }

    public void vendor(){
        String vendorText = vendor.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("vendor", vendorText);
        setMenus(laptops);
        vendor.setPromptText(vendorText);
    }

    public void name() throws InterruptedException{
        Thread.sleep(500);
        String nameText = name.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("name", nameText);
        setMenus(laptops);
        name.setPromptText(nameText);
    }

    public void Search(){
        ArrayList laptop = Shop.getLaptopsData("name", name.getItems().get(0).toString() );

        vendorOut.setText(laptop.get(1).toString());
        nameOut.setText(laptop.get(2).toString());
        specidOut.setText(laptop.get(3).toString());
        amountOut.setText(laptop.get(4).toString());
        description.setText(laptop.get(5).toString());
        availabilityOut.setText(laptop.get(6).toString());

        ArrayList spec = Shop.getSpecificationData("id", laptop.get(0).toString() );

        cpuOut.setText(spec.get(1).toString());
        gpuOut.setText(spec.get(2).toString());
        ramOut.setText(spec.get(3).toString());
        storageOut.setText(spec.get(4).toString());
        screenOut.setText(spec.get(5).toString());
        priceOut.setText(spec.get(6).toString());
    }

    public void setVendorOutText()
    {
        vendorIn.setText(vendorOut.getText());
    }

    public void setNameOutText()
    {
        nameIn.setText(nameOut.getText());
    }

    public void setSpecidOutText()
    {
        specidIn.setText(specidOut.getText());
    }

    public void setAmountOutText()
    {
        amountIn.setText(amountOut.getText());
    }

    public void setAvailabilityOutText()
    {
        availabilityIn.setText(availabilityOut.getText());
    }

    public void setCpuOutText()
    {
        cpuIn.setText(cpuOut.getText());
    }

    public void setGpuOutText()
    {
        gpuIn.setText(gpuOut.getText());
    }

    public void setRamOutText()
    {
        ramIn.setText(ramOut.getText());
    }

    public void setStorageOutText()
    {
        storageIn.setText(storageOut.getText());
    }

    public void setScreenOutText()
    {
        screenIn.setText(screenOut.getText());
    }

    public void setPriceOutText()
    {
        priceIn.setText(priceOut.getText());
    }
}
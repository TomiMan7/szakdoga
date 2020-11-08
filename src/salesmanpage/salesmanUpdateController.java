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


    public void clearMenus(){
        try {
            vendor.getItems().setAll("");
            vendor.getItems().remove(0);
        }catch (Exception e){}


        try {
            name.getItems().setAll("");
            name.getItems().remove(0);
        }catch (Exception e){}


//        name.getItems().clear();
//        vendor.getItems().clear();
        name.getSelectionModel().clearSelection();
        vendor.getSelectionModel().clearSelection();

        vendor.setPromptText("Gyártó");
        name.setPromptText("Név");
    }

    public void setMenus(ArrayList laptops)
    {
        clearMenus();

        for(int i = 1; i < laptops.size() - 1; i=i+7){
                vendor.getItems().add(laptops.get(i).toString());
            if(i+7 > laptops.size()){
                break;
            }
        }

        for(int i = 2; i <= laptops.size() - 1; i=i+7) {
            name.getItems().add(laptops.get(i).toString());
            if(i+7 > laptops.size()){
                break;
            }
        }
    }

    public void updateSearch(){
        ArrayList laptops = Shop.getAllLaptopsData();
//        clearMenus();
        setMenus(laptops);
    }

    public void vendor(){
        String vendorText = vendor.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("vendor", vendorText);
//        clearMenus();
        setMenus(laptops);
        vendor.setPromptText(vendorText);
    }

    public void name() throws InterruptedException{
        Thread.sleep(500);
        String nameText = name.getSelectionModel().getSelectedItem().toString();
        ArrayList laptops = Shop.getLaptopsData("name", nameText);
//        clearMenus();
        setMenus(laptops);
        name.setPromptText(nameText);
    }

    public void upload()
    {
        try {
            Shop.updateLaptops(vendorOut.getText(), nameOut.getText(), Integer.parseInt(amountOut.getText()), Integer.parseInt(availabilityOut.getText()), description.getText(), "name", nameIn.getText() );

        }catch (Exception e){e.printStackTrace();}

        ArrayList id = Shop.getLaptopsData("name", nameIn.getText());

        Shop.updateSpecification(cpuOut.getText(), gpuOut.getText(), ramOut.getText(), storageOut.getText(), screenOut.getText(), priceOut.getText(), "id", id.get(0).toString());

        updateSearch();

        vendorOut.setText("");
        nameOut.setText("");
        specidOut.setText("");
        amountOut.setText("");
        description.setText("");
        availabilityOut.setText("");

        vendorIn.setText("");
        nameIn.setText("");
        specidIn.setText("");
        amountIn.setText("");
        description.setText("");
        availabilityIn.setText("");

        cpuOut.setText("");
        ramOut.setText("");
        gpuOut.setText("");
        storageOut.setText("");
        screenOut.setText("");
        priceOut.setText("");

        cpuIn.setText("");
        ramIn.setText("");
        gpuIn.setText("");
        storageIn.setText("");
        screenIn.setText("");
        priceIn.setText("");
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
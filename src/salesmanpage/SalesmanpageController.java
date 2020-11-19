package salesmanpage;

import Database.Employees;
import Database.Shop;
import Database.Wagemods;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SalesmanpageController
{
    public ComboBox cpu;
    public ComboBox gpu;
    public ComboBox ram;
    public ComboBox storage;
    public ComboBox screen;
    public ComboBox vendor;
    public ComboBox name;
    public Label vendorLabel;
    public Label nameLabel;
    public Label cpuLabel;
    public Label gpuLabel;
    public Label ramLabel;
    public Label storageLabel;
    public Label screenLabel;
    public Label amountLabel;
    public Label priceLabel;
    public ComboBox price;
    public ListView list;

    private boolean updateOpen = false;
    private boolean insertOpen = false;

    public static ArrayList main = new ArrayList();

    public void dbUpdateScreen()
    {
        if(!updateOpen)
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("salesmanUpdate.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root1));
                stage.resizableProperty().setValue(false);
                stage.setTitle("Laptop frissítése");
                stage.setOnCloseRequest(event ->
                {
                    updateOpen = false;
                    stage.close();
                });
                stage.show();

                updateOpen = true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addNewLaptopScreen()
    {
        if(!insertOpen) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("salesmanInsert.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root1));
                stage.resizableProperty().setValue(false);
                stage.setTitle("Új laptop felvitele");
                stage.setOnCloseRequest(event ->
                {
                    insertOpen = false;
                    stage.close();
                });
                stage.show();

                insertOpen = true;
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addNewCustomerScreen()
    {
        try {
            String[] temp;
            String vendor = list.getSelectionModel().getSelectedItem().toString();
            temp = vendor.split(" ", 2);

            main = Shop.getALaptopAll(temp[0], temp[1]);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerInsert.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Vásárlói igény felvitele");

            stage.show();

        }catch (Exception e){
            Wagemods.alert("Válasszon ki egy laptopot!");
        }
    }

    public void updateCustomerScreen()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerUpdate.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Rendelés frissítése/törlése");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData()
    {
        main.clear();
        name.getItems().clear();
        vendor.getItems().clear();
        cpu.getItems().clear();
        gpu.getItems().clear();
        ram.getItems().clear();
        storage.getItems().clear();
        screen.getItems().clear();
        price.getItems().clear();

        ArrayList vendors = Shop.getLaptopsVendor();
        ArrayList names = Shop.getLaptopsName();
        ArrayList cpus = Shop.getLaptopsCpu();
        ArrayList gpus = Shop.getLaptopsGpu();
        ArrayList rams = Shop.getLaptopsRam();
        ArrayList storages = Shop.getLaptopsStorage();
        ArrayList screens = Shop.getLaptopsScreen();
        ArrayList prices = Shop.getLaptopsPrice();

        for(int i = 0; i <= vendors.size() - 1; i++)
        {
            vendor.getItems().add(vendors.get(i).toString());
        }
        for(int i = 0; i <= names.size() - 1; i++)
        {
            name.getItems().add(names.get(i).toString());
        }

        for(int i = 0; i <= cpus.size() - 1; i++)
        {
            cpu.getItems().add(cpus.get(i).toString());
        }

        for(int i = 0; i <= gpus.size() - 1; i++)
        {
            gpu.getItems().add(gpus.get(i).toString());
        }

        for(int i = 0; i <= rams.size() - 1; i++)
        {
            ram.getItems().add(rams.get(i).toString());
        }

        for(int i = 0; i <= storages.size() - 1; i++)
        {
            storage.getItems().add(storages.get(i).toString());
        }

        for(int i = 0; i <= screens.size() - 1; i++)
        {
            screen.getItems().add(screens.get(i).toString());
        }

        for(int i = 0; i <= prices.size() - 1; i++)
        {
            price.getItems().add(prices.get(i).toString());
        }
    }

    public void search ()
    {
        String cpudata = "";
        String gpudata = "";
        String ramdata = "";
        String storagedata = "";
        String screendata = "";
        String vendordata = "";
        String namedata = "";
        String pricedata = "";

        try {
            cpudata = cpu.getValue().toString();
        }catch (Exception e){ cpudata = "";}
        try {
            gpudata = gpu.getValue().toString();
        }catch (Exception e){ gpudata = "";}
        try {
            ramdata = ram.getValue().toString();
        }catch (Exception e){ ramdata = "";}
        try {
            storagedata = storage.getValue().toString();
        }catch (Exception e){storagedata = "";}
        try {
            screendata = screen.getValue().toString();
        }catch (Exception e){screendata = "";}
        try {
            vendordata = vendor.getValue().toString();
        }catch (Exception e){vendordata = "";}
        try {
            namedata = name.getValue().toString();
        }catch (Exception e){namedata = "";}
        try {
            pricedata = price.getValue().toString();
        }catch (Exception e){pricedata = "";}

            ArrayList laptops = Shop.getLaptopsForSell(cpudata, gpudata, ramdata, storagedata, screendata, vendordata, namedata, pricedata);

            list.getItems().clear();
            populateList(laptops);

    }

    public void populateList(ArrayList laptops)
    {
        for(int i = 1; i < laptops.size() - 1; i=i+14)
        {
            list.getItems().add(laptops.get(i).toString() + " " + laptops.get(i+1).toString());
            if(i+14 > laptops.size())
                return;
        }
    }

    public void getSelectedLaptop()
    {
        try {
            String[] temp;
            String vendor = list.getSelectionModel().getSelectedItem().toString();
            temp = vendor.split(" ", 2);

            main = Shop.getALaptopAll(temp[0], temp[1]);

            vendorLabel.setText(main.get(1).toString());
            nameLabel.setText(main.get(2).toString());
            amountLabel.setText(main.get(3).toString());
            cpuLabel.setText(main.get(4).toString());
            gpuLabel.setText(main.get(5).toString());
            ramLabel.setText(main.get(6).toString());
            storageLabel.setText(main.get(7).toString());
            screenLabel.setText(main.get(8).toString());
            priceLabel.setText(main.get(9).toString());
        }
        catch (Exception e){}
    }
}

package salesmanpage;

import Database.Shop;
import com.sun.javafx.scene.SceneHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class salesmanpageController
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

    private boolean updateOpen = false;
    private boolean insertOpen = false;

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
                stage.setTitle("Laptop frissítése/törlése");
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customerInsert.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.resizableProperty().setValue(false);
            stage.setTitle("Insert new Laptop");

            customerInsertController.vendorLabel = vendorLabel.getText();
            customerInsertController.nameLabel = nameLabel.getText();
            customerInsertController.cpuLabel = cpuLabel.getText();
            customerInsertController.gpuLabel = gpuLabel.getText();
            customerInsertController.ramLabel = ramLabel.getText();
            customerInsertController.storageLabel = storageLabel.getText();
            customerInsertController.screenLabel = screenLabel.getText();
            customerInsertController.amountLabel = amountLabel.getText();
            customerInsertController.priceLabel = priceLabel.getText();

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
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
            stage.setTitle("Vevő adatok frissítése/Rendelés törlése");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData()
    {
        name.getItems().clear();
        vendor.getItems().clear();
        cpu.getItems().clear();
        gpu.getItems().clear();
        ram.getItems().clear();
        storage.getItems().clear();
        screen.getItems().clear();

        ArrayList laptops = Shop.getAllLaptopsData();
        ArrayList cpus = Shop.getLaptopsCpu();
        ArrayList gpus = Shop.getLaptopsGpu();
        ArrayList rams = Shop.getLaptopsRam();
        ArrayList storages = Shop.getLaptopsStorage();
        ArrayList screens = Shop.getLaptopsScreen();
        ArrayList prices = Shop.getLaptopsPrice();

        for(int i = 2; i <= laptops.size() - 1; i=i+7) {
            name.getItems().add(laptops.get(i).toString());
            if(i+7 > laptops.size()){
                break;
            }
        }

        for(int i = 1; i <= laptops.size() - 1; i=i+7) {
            vendor.getItems().add(laptops.get(i).toString());
            if(i+7 > laptops.size()){
                break;
            }
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

    public void search()
    {
//        String cpudata = cpu.getValue().toString();//getSelectionModel().getSelectedItem().toString();
//        String gpudata = cpu.getSelectionModel().getSelectedItem().toString();


//        if (cpudata == null)
//            System.out.println("anyad");
    }
}

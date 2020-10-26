package salesmanpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class salesmanpageController
{
    public static ComboBox cpu;
    public static ComboBox gpu;
    public static ComboBox ram;
    public static ComboBox storage;
    public static ComboBox screen;
    public static ComboBox vendor;
    public static ComboBox name;
    public Label vendorLabel;
    public Label nameLabel;
    public Label cpuLabel;
    public Label gpuLabel;
    public Label ramLabel;
    public Label storageLabel;
    public Label screenLabel;
    public Label amountLabel;
    public Label priceLabel;

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
                stage.setTitle("Update/Delete Laptop");
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
                stage.setTitle("Insert new Laptop");
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
            stage.setTitle("Update or remove customer info/order");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package salesmanpage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class salesmanpageController
{
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

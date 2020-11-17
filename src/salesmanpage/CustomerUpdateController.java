package salesmanpage;

import Database.Employees;
import Database.Shop;
import Database.Wagemods;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class CustomerUpdateController
{


    public TextField customer;
    public TextField phone;
    public TextField email;
    public TextField city;
    public TextField street;
    public TextField hnumber;
    public ListView list;
    public Label vendor;
    public Label name;
    public Label cpu;
    public Label gpu;
    public Label ram;
    public Label storage;
    public Label screen;
    public Label price;
    public TextField amount;
    public Label orderID;
    public Label amountBefore;

    public void getOrders()
    {
        try {

            ArrayList customerData = Shop.getACustomer(customer.getText(), phone.getText(), email.getText(), city.getText(), street.getText(), hnumber.getText());
            String id = customerData.get(0).toString();
            ArrayList ordersData = Shop.getOrdersData("customerId", id);

            ArrayList laptops = getAllLaptops(ordersData);

            ArrayList orderIds = getOrderId(ordersData);

            ArrayList laptopVendorName = getLaptopVendorName(laptops);

            setOrders(orderIds, laptopVendorName);
        }
        catch (Exception e){
            clearLabels();
            Wagemods.alert("Nincs ilyen korábbi vásárló!");
        }
    }

    public void setOrders(ArrayList orderIds, ArrayList laptopVendorName)
    {
        clearLabels();
        int j = 0;
        for(int i = 0; i <= orderIds.size() - 1; i++)
        {
            list.getItems().addAll(orderIds.get(i) + " " + laptopVendorName.get(j) + " " + laptopVendorName.get( j + 1));
            j = j+2;
        }
    }

    public ArrayList getAllLaptops(ArrayList ordersData)
    {
        ArrayList laptops = new ArrayList();
        for(int i = 2; i < ordersData.size() - 1; i = i + 7)
        {
            laptops.addAll(Shop.getLaptopsData("id", ordersData.get(i).toString()));
            if(i + 7 > ordersData.size())
                return laptops;
        }
        return laptops;
    }

    public ArrayList getOrderId(ArrayList ordersData)
    {
        ArrayList orderIds = new ArrayList();

        for(int i = 0; i <= ordersData.size() - 1; i = i + 7)
        {
            orderIds.add(ordersData.get(i));
            if(i + 7 > ordersData.size() )
                return orderIds;
        }
        return orderIds;
    }

    public ArrayList getLaptopVendorName(ArrayList laptops)
    {
        ArrayList laptopVendorName = new ArrayList();
        for(int j = 1; j <= laptops.size() - 1; j = j + 7)
        {
            laptopVendorName.add(laptops.get(j));
            laptopVendorName.add(laptops.get(j+1));
            if(j + 7 > laptops.size() )
                return laptopVendorName;
        }
        return laptopVendorName;
    }

    public void getOrderDetails()
    {
        String selectedOrder = list.getSelectionModel().getSelectedItems().toString();
        selectedOrder = selectedOrder.substring(1, selectedOrder.length()-1); // leszedi a [ ] karakterekt az elejerol es a vegerol
        String[] temp = selectedOrder.split( " ", 3);

        orderID.setText(temp[0]);
        vendor.setText(temp[1]);
        name.setText(temp[2]);

        ArrayList order = Shop.getOrdersData("id", temp[0]);
        System.out.println("ORDER");
        order.forEach(n -> System.out.println(n));

        ArrayList laptop = Shop.getALaptopAll(temp[1], temp[2]); //4tol spec adat van benne
        cpu.setText(laptop.get(4).toString());
        gpu.setText(laptop.get(5).toString());
        ram.setText(laptop.get(6).toString());
        storage.setText(laptop.get(7).toString());
        screen.setText(laptop.get(8).toString());
        amount.setText(order.get(4).toString());
        amountBefore.setText(order.get(4).toString());
        price.setText(order.get(5).toString());
    }

    public void clearLabels(){
        name.setText("");
        vendor.setText("");
        phone.setText("");
        customer.setText("");
        email.setText("");
        cpu.setText("");
        city.setText("");
        gpu.setText("");
        street.setText("");
        ram.setText("");
        hnumber.setText("");
        storage.setText("");
        screen.setText("");
        price.setText("");
        amount.setText("");
        orderID.setText("");
        amountBefore.setText("");
        list.getItems().clear();
    }

    public void update()
    {
        float soloPrice = Float.parseFloat(price.getText()) / Float.parseFloat(amountBefore.getText());
        Shop.updateOrders("finalprice", String.valueOf(soloPrice * Integer.parseInt(amount.getText())), "id", orderID.getText());
        Shop.updateOrders("quantity", amount.getText(), "id", orderID.getText());
        clearLabels();
    }

    public void delete()
    {
        try {
            Shop.deleteOrder(orderID.getText());
            clearLabels();
        }catch (Exception e)
        {
            Wagemods.alert("Nincs rendelés kiválasztva!");
        }
    }

}

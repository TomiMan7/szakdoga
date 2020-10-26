package salesmanpage;

import Database.Shop;
import com.gluonhq.charm.glisten.control.TextArea;
import com.gluonhq.charm.glisten.control.TextField;

import java.util.ArrayList;

public class salesmanInsertController
{
    public TextField vendor;
    public TextField name;
    public TextField amount;
    public TextField availability;
    public TextArea description;
    public TextField cpu;
    public TextField gpu;
    public TextField ram;
    public TextField storage;
    public TextField screen;
    public TextField price;

    public void insertLaptop()
    {
        ArrayList id = Shop.selectMax("id");
        Shop.insertLaptops(vendor.getText(), name.getText(), Integer.parseInt(id.get(0).toString()) +1, Integer.parseInt(amount.getText()), description.getText(), Integer.parseInt(availability.getText()));
    }

    public void insertSpec()
    {
        Shop.insertSpecification(cpu.getText(), gpu.getText(), ram.getText(), storage.getText(), screen.getText(),price.getText());
    }

    public void clean()
    {
        vendor.setText("");
        name.setText("");
        amount.setText("");
        availability.setText("");
        description.setText("");
        cpu.setText("");
        gpu.setText("");
        ram.setText("");
        storage.setText("");
        screen.setText("");
        price.setText("");
    }

    public void insertInto()
    {
        insertLaptop();
        insertSpec();
        clean();
    }

}

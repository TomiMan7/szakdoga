package Database;

import java.sql.*;

public class Shop
{
    public static String connection = "";
    static ResultSet rs = null;
    static Connection conn = null;

    public static void Connect()
    {
        connection = "jdbc:mysql://127.0.0.1/shop?user=root&password= &useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try
        {
            conn = DriverManager.getConnection(connection);
        }
        catch (SQLException e)
        {
//            alert("Nem elerheto az adatbazis!\n\n" + e);
            System.out.println(e);
        }
    }

    public static void CloseConnection()
    {
        try
        {
            conn.createStatement();
            conn.close();
        }
        catch (SQLException e)
        {
//            alert("Nem sikerult a kapcsolatot zarni!\n" + e);
            System.out.println("nem lehet bezarni a kapcsolatot");
        }
    }

    //table customer
    public static void getCustomerData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from customer where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table customer")
            e.printStackTrace();
        }
    }

    public static void getAllCustomerData()
    {
        try {
            PreparedStatement st = conn.prepareStatement("select * from customer");
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table shop")
            e.printStackTrace();
        }
    }

    public static void updateCustomer(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update customer set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table customer")
            e.printStackTrace();
        }
    }

    public static void insertCustomer(String name, String phone, String email, String city, String street, String hnumer)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into customer (name, phone, email, city, street, hnumber)" +
                    "values (?,?,?,?,?,?)");
            st.setString(1,name);
            st.setString(2,phone);
            st.setString(3,email);
            st.setString(4,city);
            st.setString(5,street);
            st.setString(6,hnumer);
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table shop")
            e.printStackTrace();
        }
    }

    //table shop
    public static void getShopData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from shop where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table shop")
            e.printStackTrace();
        }
    }

    public static void getAllShopData()
    {
        try {
            PreparedStatement st = conn.prepareStatement("select * from shop");
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) +
                        " " + rs.getString(4));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table shop")
            e.printStackTrace();
        }
    }

    public static void updateShop(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update shop set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table shop")
            e.printStackTrace();
        }
    }

    public static void insertShop(String address, String email, String phone)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into shop (address,email,phone)" +
                    "values (?,?,?)");
            st.setString(1,address);
            st.setString(2,email);
            st.setString(3,phone);
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table shop")
            e.printStackTrace();
        }
    }


    //table laptops
    public static void getLaptopsData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from laptops where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table laptops")
            e.printStackTrace();
        }
    }

    public static void getAllLaptopsData()
    {
        try {
            PreparedStatement st = conn.prepareStatement("select * from laptops");
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table laptops")
            e.printStackTrace();
        }
    }

    public static void updateLaptops(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update laptops set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table laptops")
            e.printStackTrace();
        }
    }

    public static void insertLaptops(String vendor, String name, int specid, int amount, String description, int availability)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into laptops (vendor, name, specid, amount, description, availability)" +
                    "values (?,?,?,?,?,?)");
            st.setString(1,vendor);
            st.setString(2,name);
            st.setInt(3,specid);
            st.setInt(4,amount);
            st.setString(5,description);
            st.setInt(6,availability);
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table shop")
            e.printStackTrace();
        }
    }

    //table orders
    public static void getOrdersData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from orders where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table orders")
            e.printStackTrace();
        }
    }

    public static void getAllOrdersData()
    {
        try {
            PreparedStatement st = conn.prepareStatement("select * from orders");
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table orders")
            e.printStackTrace();
        }
    }

    public static void updateOrders(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update orders set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table orders")
            e.printStackTrace();
        }
    }

    public static void insertOrders(int customerid, int laptopid, String paymentmethod, String quantity, String finalprice, String date)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into orders (customerid, laptopid, paymentmethod, quantity, finalprice, date)" +
                    "values (?,?,?,?,?,?)");
            st.setInt(1,customerid);
            st.setInt(2,laptopid);
            st.setString(3,paymentmethod);
            st.setString(4,quantity);
            st.setString(5,finalprice);
            st.setString(6,date);
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table orders")
            e.printStackTrace();
        }
    }

    //table specification
    public static void getSpecificationData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from specification where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification")
            e.printStackTrace();
        }
    }

    public static void getAllSpecificationData()
    {
        try {
            PreparedStatement st = conn.prepareStatement("select * from specification");
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table specification")
            e.printStackTrace();
        }
    }

    public static void updateSpecification(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update specification set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table specification")
            e.printStackTrace();
        }
    }

    public static void insertSpecification(String cpu, String gpu, String ram, String storage, String screen, String price)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into specification (cpu, gpu, ram, storage, screen, price)" +
                    "values (?,?,?,?,?,?)");
            st.setString(1,cpu);
            st.setString(2,gpu);
            st.setString(3,ram);
            st.setString(4,storage);
            st.setString(5,screen);
            st.setString(6,price);
            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table specification")
            e.printStackTrace();
        }
    }

    public static void deleteFromDbShop(String table, String where, String what)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("delete from " + table +" where "+where+" = ?");
            st.setString(1,what);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant delete the given values from table shop")
            e.printStackTrace();
        }
    }
}

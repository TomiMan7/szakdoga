package Database;

import java.sql.*;
import java.util.ArrayList;

import static Database.Wagemods.alert;

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
    public static ArrayList getCustomerData(String where, String equals)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from customer where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));
//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
//                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table customer")
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getAllCustomerData()
    {
        ArrayList result = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement("select * from customer");
            rs = st.executeQuery();
            while (rs.next()) {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));

//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
//                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table shop")
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getACustomer(String name, String phone, String email, String city, String street, String hnumber)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from customer where name = ?" +
                    "and phone = ?" +
                    "and email = ?" +
                    "and city = ?" +
                    "and street = ?" +
                    "and hnumber = ?");

            st.setString(1,name);
            st.setString(2,phone);
            st.setString(3,email);
            st.setString(4,city);
            st.setString(5,street);
            st.setString(6,hnumber);

            rs = st.executeQuery();

            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table customer");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList updateCustomer(String name, String phone, String email, String city, String street, String hnoumber, String whereName, String wherePhone, String whereEmail)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("update customer set name = ?, phone = ?, email = ?, city = ?, street = ?, hnumber = ? where name = ? and phone = ? and email = ?");

            st.setString(1,name);
            st.setString(2,phone);
            st.setString(3,email);
            st.setString(4,city);
            st.setString(5,street);
            st.setString(6,hnoumber);
            st.setString(7,whereName);
            st.setString(8,wherePhone);
            st.setString(9,whereEmail);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table customer")
            e.printStackTrace();
        }
        return result;
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

    public static void deleteCustomer(String name, String email, String phone)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("delete from customer where name = ? and phone = ? and email = ?");
            st.setString(1,name);
            st.setString(2,email);
            st.setString(3,phone);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant delete the given values from table shop")
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

    public static ArrayList getLaptopsVendor()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select vendor from laptops group by vendor");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));
//
//                System.out.println(rs.getString(1));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table laptops")
            e.printStackTrace();
        }
        return result;
    }


    public static ArrayList getLaptopsName()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select name from laptops group by name");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table laptops")
            e.printStackTrace();
        }
        return result;
    }
    //table laptops
    public static ArrayList getLaptopsData(String where, String equals)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from laptops where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getInt(4));
                result.add(rs.getInt(5));
                result.add(rs.getString(6));
                result.add(rs.getInt(7));
//
//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table laptops")
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getAllLaptopsData()
    {
        ArrayList result = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement("select * from laptops group by vendor, name order by vendor, name");
            rs = st.executeQuery();
            while (rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getInt(4));
                result.add(rs.getInt(5));
                result.add(rs.getString(6));
                result.add(rs.getInt(7));
//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getInt(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
             alert("Cant get everything from table laptops");
            e.printStackTrace();
        }
        return result;
    }

    public static void updateLaptops(String newVendor, String newName,/* int newSpecdid, */int newAmount, int newAvailability, String newDescription, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update laptops set vendor = ?, name = ?, amount = ?, description = ?, availability = ? where "+where+" = ?");

            st.setString(1,newVendor);
            st.setString(2,newName);
//            st.setInt(3,newSpecdid);
            st.setInt(3,newAmount);
            st.setString(4,newDescription);
            st.setInt(5,newAvailability);
            st.setString(6,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
//            alert("Nem lehetett frissíteni!");
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
    public static ArrayList getOrdersData(String where, String equals)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from orders where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getInt(2));
                result.add(rs.getInt(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table orders");
            e.printStackTrace();
        }
        return result;
    }

    public static void deleteOrder(String id)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("delete from orders where id = ?");
            st.setString(1,id);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant delete the given values from table shop");
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
    public static ArrayList getSpecificationData(String where, String equals)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from specification where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));

//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
//                        +" "+rs.getString(7));
//                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getAllSpecificationData()
    {
        ArrayList result = new ArrayList();

        try {
            PreparedStatement st = conn.prepareStatement("select * from specification");
            rs = st.executeQuery();

            while (rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));
//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
//                        +" "+rs.getString(7));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getaSpecificationData(String where, String equals, String where2, String equals2, String where3, String equals3, String where4, String equals4, String where5, String equals5)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from specification where "+ where +" like ?" +
                                                                                     "and "+ where2 +" like ?"+
                                                                                     "and "+ where3 +" like ?"+
                                                                                     "and "+ where4 +" like ?"+
                                                                                     "and "+ where5 +" like ?");

            st.setString(1,equals);
            st.setString(2,equals2);
            st.setString(3,equals3);
            st.setString(4,equals4);
            st.setString(5,equals5);
            System.out.println(st);

            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));

//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
//                        +" "+rs.getString(7));
//                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification")
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getaSpecification(String where, String equals, String where2, String equals2, String where3, String equals3, String where4, String equals4, String where5, String equals5)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from specification where "+ where +" like(\"%"+equals+"%\") " +
                    " and "+ where2 +" like(\"%"+equals2+"%\") "+
                    " and "+ where3 +" like(\"%"+equals3+"%\") "+
                    " and "+ where4 +" like(\"%"+equals4+"%\") "+
                    " and "+ where5 +" like(\"%"+equals5+"%\") ");

            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
                result.add(rs.getString(7));

//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
//                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)
//                        +" "+rs.getString(7));
//                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification")
            e.printStackTrace();
        }
        return result;
    }

    public static void updateSpecification(String cpu, String gpu, String ram, String storage, String screen, String price, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update specification set cpu = ?, gpu = ?, ram = ?, storage = ?, screen = ?, price = ? where "+where+" = ?");

            st.setString(1,cpu);
            st.setString(2,gpu);
            st.setString(3,ram);
            st.setString(4,storage);
            st.setString(5,screen);
            st.setString(6,price);
            st.setString(7,equals);

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

    public static ArrayList selectMax(String what)
    {
        ArrayList result = new ArrayList();

        try {
            PreparedStatement st = conn.prepareStatement("select max("+what+") from specification");

            rs = st.executeQuery();

            while (rs.next())
            {
                result.add(rs.getInt(1));
//                System.out.println(rs.getInt(1));
                //TODO AFTER GUI
            }
        } catch (SQLException e) {
//             alert("Cant get everything from table specification")
            e.printStackTrace();
        }
    return result;
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

    //special
    public static ArrayList getALaptopAll(String vendor, String name)
    {
        ArrayList result = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM laptops left OUTER JOIN specification on laptops.specid = specification.id where vendor = ? and name = ?");
            st.setString(1, vendor);
            st.setString(2,name);

            rs = st.executeQuery();

            while (rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(5));
                result.add(rs.getString(9));
                result.add(rs.getString(10));
                result.add(rs.getString(11));
                result.add(rs.getString(12));
                result.add(rs.getString(13));
                result.add(rs.getString(14));

            }
        } catch (SQLException e) {
//             alert("Cant get everything from table laptops")
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsCpu()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select cpu from specification group by cpu order by cpu");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));

//                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsGpu()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select gpu from specification group by gpu order by gpu");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));

//                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsRam()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select ram from specification group by ram order by ram");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));

//                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsStorage()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select storage from specification group by storage order by storage");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));

//                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsScreen()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select screen from specification group by screen order by screen");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));

//                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsPrice()
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select price from specification group by price order by price");
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString(1));

//                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table specification");
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList getLaptopsForSell(String cpu, String gpu, String ram, String storage, String screen, String vendor, String name, String price)
    {
        ArrayList result = new ArrayList();
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from laptops inner join specification on laptops.specid = specification.id" +
                    " where cpu like (\"%"+cpu+"%\") " +
                    " and gpu like (\"%"+gpu+"%\") "+
                    " and ram like (\"%"+ram+"%\") "+
                    " and storage like (\"%"+storage+"%\") "+
                    " and screen like (\"%"+screen+"%\") "+
                    " and vendor like (\"%"+vendor+"%\") "+
                    " and name like (\"%"+name+"%\") "+
                    " and price like (\"%"+price+"%\") order by vendor, name");

//            st.setString(1,cpu);
//            st.setString(2,gpu);
//            st.setString(3,storage);
//            st.setString(4,screen);
//            st.setString(5,vendor);
//            st.setString(6,name);
//            st.setString(7,price);
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getInt(4));
                result.add(rs.getInt(5));
                result.add(rs.getString(6));
                result.add(rs.getInt(7));
                result.add(rs.getInt(8));
                result.add(rs.getString(9));
                result.add(rs.getString(10));
                result.add(rs.getString(11));
                result.add(rs.getString(12));
                result.add(rs.getString(13));
                result.add(rs.getString(14));
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table laptops");
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args)
    {
        Connect();
//        getaSpecificationData("cpu", "ryzen 7 4700", "gpu", "amd ry7500", "ram", "16gb",
//                "storage", "2tb ssd", "screen", "17 IPS");

//        getaSpecification("cpu", "", "gpu", "", "ram", "gb",
//                "storage", "ssd", "screen", "IPS");

//        selectMax("id");

//        getAllLaptopsData();
//        getAllSpecificationData();
//        getLaptopsData("vendor","Acer");
//        getSpecificationData("id","2");

//        Shop.updateLaptops("Acer","Aspire F5 575", 666, 1, "It's good", "name", "Aspire F5 575");
//        Shop.updateSpecification("Ryzen 7 4700H", "AMD RX7500", "16GB", "2TB SSD", "17\"IPS", "500", "id", "1");

//        updateCustomer("Customer1", "+3622222222", "customeremail@customer.hu", "piac", "street", "7", "Customer1", "+362222222", "customeremail@customer.hu");
//        getLaptopsVendor();
//        getLaptopsCpu();
//        getLaptopsForSell("7200", "", "", "HDD", "", "", "", "");
//        getALaptopAll("Acer", "Aspire F5-575G");
//        getACustomer("Customer1", "+3622222222", "customeremail@customer.hu", "piac", "street", "7");
        CloseConnection();

    }
}

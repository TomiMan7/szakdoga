package Database;

import java.sql.*;
import java.util.ArrayList;

public class Employees
{
    private static String connection = "";
    private static ResultSet rs = null;
    private static Connection conn = null;

    public static void Connect()
    {
        connection = "jdbc:mysql://127.0.0.1/employees?user=root&password= &useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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


    //employees table
    public static void getAllEmployeeData()
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from employees");
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table employees")
            e.printStackTrace();
        }
    }

    public static void getEmployeeData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from employees where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table employees")
            e.printStackTrace();
        }
    }

    public static void updateEmployee(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update employees set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table employees")
            e.printStackTrace();
        }
    }

    public static void insertEmployee(String name, String phone, String email, String post, String wage, String whours)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into employees (name,phone,email,post,wage,whours)" +
                    "values (?,?,?,?,?,?)");
            st.setString(1,name);
            st.setString(2,phone);
            st.setString(3,email);
            st.setString(4,post);
            st.setString(5,wage);
            st.setString(6,whours);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table employees")
            e.printStackTrace();
        }
    }

    public static void deleteFromDbEmployees(String table, String where, String what)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("delete from " + table +" where "+where+" = ?");
            st.setString(1,what);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant delete the given values from table employees")
            e.printStackTrace();
        }
    }


    //leaves Table
    public static void getAllLeavesData()
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from leaves");
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)
                        +" "+rs.getInt(8)+ " " +rs.getInt(9));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
            //             alert("Cant get everything from table leaves")
            e.printStackTrace();
        }
    }

    public static void getLeavesData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from leaves where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)
                        +" "+rs.getInt(8)+ " " +rs.getInt(9));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table leaves")
            e.printStackTrace();
        }
    }

    public static void updateLeaves(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update leaves set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table employees")
            e.printStackTrace();
        }
    }

    public static void insertLeaves(String startyear, String startmonth, String startday, String endyear, String endmonth,
                                    String endday, int sickpay, int workerid)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into leaves (startyear, startmonth, startday," +
                    "endyear, endmonth, endday, sickpay, workerid)" +
                    "values (?,?,?,?,?,?,?,?)");
            st.setString(1,startyear);
            st.setString(2,startmonth);
            st.setString(3,startday);
            st.setString(4,endyear);
            st.setString(5,endmonth);
            st.setString(6,endday);
            st.setInt(7,sickpay);
            st.setInt(8,workerid);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table employees")
            e.printStackTrace();
        }
    }

    //whours Table
    public static void getAllWhoursData()
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from permissions");
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+
                        " "+rs.getInt(4)+" "+rs.getInt(5));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table permissions")
            e.printStackTrace();
        }
    }

    public static void getWhoursData(String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from whours where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table whours")
            e.printStackTrace();
        }
    }

    public static void updateWhours(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update whours set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table whours")
            e.printStackTrace();
        }
    }

    public static void insertWhours(String name, String year, String month, String day, String hour)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into whours (name,year,month,day,hour)" +
                    "values (?,?,?,?,?)");
            st.setString(1,name);
            st.setString(2,year);
            st.setString(3,month);
            st.setString(4,day);
            st.setString(5,hour);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table whours")
            e.printStackTrace();
        }
    }

    //table permissions
    public static ArrayList getPermissionsData(String selectWhat, String where, String equals)
    {

        ArrayList result = new ArrayList();

        try
        {
            PreparedStatement st = conn.prepareStatement("select * from permissions where "+ where +" = ?");
            st.setString(1,equals);
            rs = st.executeQuery();
            while(rs.next())
            {
                result.add(rs.getInt(1));
                result.add(rs.getString(2));
                result.add(rs.getInt(3));
                result.add(rs.getInt(4));
                result.add(rs.getInt(5));
                result.add(rs.getString(6));
//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+
//                        " "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getString(6) );
                //TODO AFTER GUI

//                result.forEach(n -> System.out.println(n));

            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table permissions")
            e.printStackTrace();
        }
        return result;
    }

    public static void updatePermissions(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update permissions set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table permissions")
            e.printStackTrace();
        }
    }

    public static void getAllPermissionsData()
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from whours");
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table whours")
            e.printStackTrace();
        }
    }

    public static void insertPermissions(String name, int salesman, int accountant, int manager)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into permissions (name, salesman, accountant, manager)" +
                    "values (?,?,?,?)");
            st.setString(1,name);
            st.setInt(2,salesman);
            st.setInt(3,accountant);
            st.setInt(4,manager);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table permissions")
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employees.Connect();
        Employees.getPermissionsData("name", "name","Dolgozo");
        Employees.CloseConnection();
    }
}

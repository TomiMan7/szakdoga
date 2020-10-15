package Database;

import java.sql.*;

public class Wagemods
{
    public static String connection = "";
    static ResultSet rs = null;
    static Connection conn = null;

//    private static boolean loggedIn = false;

//    public static boolean CheckLoggedInStatus()
//    {
//        return loggedIn;
//    }

//    public static void alert(String message)
//    {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Stuff");
//        alert.setHeight(500);
//        alert.setWidth(200);
//        alert.setContentText(message);
//
//        alert.showAndWait();
//    }

    public static void Connect()
    {
        connection = "jdbc:mysql://127.0.0.1/wagemods?user=root&password= &useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//        jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

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

    public static void getAll()
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("select * from wagemods");
//            PreparedStatement st=conn.prepareStatement("select * from wagemods where name like ?");
//            st.setString(1,"Dolgozo");
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
//             alert("Cant get everything from table wagemods")
            e.printStackTrace();
        }
    }

    public static void getColumnforEmployee(String column, String name)
    {
        try
        {
//            PreparedStatement st = conn.prepareStatement("select ? from wagemods where name = ?");
            PreparedStatement st = conn.prepareStatement("select "+column+" from wagemods where name = ?");
            st.setString(1,name);
//            st.setString(2,name);
            rs = st.executeQuery();

            while (rs.next())
            {
                System.out.println(rs.getString(1));
                //TODO AFTER GUI
            }
        }
        catch (SQLException e)
        {
            //lert("Cant get the given column from table wagemods")
            e.printStackTrace();
        }
    }

    public static void updateColumn(String what, String toWhat, String where, String equals)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("update wagemods set "+what+" = ? where "+where+" = ?");
            st.setString(1,toWhat);
            st.setString(2,equals);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant get the given column from table wagemods")
            e.printStackTrace();
        }
    }

    public static void insert(String name, String nyugdij, String tb, String szja, String mpj, String nyugdijtakarek)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("insert into wagemods (name,nyugdij,tb,szja,mpj,nyugdijtakarek)" +
                    "values (?,?,?,?,?,?)");
            st.setString(1,name);
            st.setString(2,nyugdij);
            st.setString(3,tb);
            st.setString(4,szja);
            st.setString(5,mpj);
            st.setString(6,nyugdijtakarek);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant insert the given values to table wagemods")
            e.printStackTrace();
        }
    }

    public static void deleteWage(String where, String what)
    {
        try
        {
            PreparedStatement st = conn.prepareStatement("delete from wagemods where "+where+" = ?");
            st.setString(1,what);

            st.executeUpdate();
        }
        catch (SQLException e)
        {
            //alert("Cant delete the given values from table wagemods")
            e.printStackTrace();
        }
    }
}

/**
 * Created by nathankaufman on 9/13/19.
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    private static String uri = null;
    private static String driver = null;
    private static String user = null;
    private static String password = null;
    private Connection conn = null;

    //sets static varibles
    public Database(String username, String password){
        uri = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        driver = "com.mysql.cj.jdbc.Driver";
        user = username;
        this.password =  password;
        conn = null;
    }

    public Database(){
        String Query = "USE Schedule";
        connect();
        setDatabase(Query);
    }

    protected boolean connect(){
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            conn= DriverManager.getConnection(uri, user ,password);
        }
        catch( SQLException sqle) {
//            DLException dlException = new DLException(sqle);
            sqle.printStackTrace();
            return false;
        }
        return true;
    }

    protected boolean close(){
        try{
            conn.close();
        }
        catch (SQLException sqle){
//            DLException dlException = new DLException(sqle);
            return false;
        }
        return true;
    }

    public ArrayList<ArrayList<String>> getData(String query, int numParam, boolean columns){
        try {
            Statement statement = conn.createStatement();

            ArrayList<ArrayList<String>> results = new ArrayList<>();
            ResultSet rs = statement.executeQuery(query);

            if(columns){
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                ArrayList<String> names = new ArrayList<>();

                for(int f = 1; f<=resultSetMetaData.getColumnCount(); f++){
                    names.add(resultSetMetaData.getColumnName(f));
                }
                results.add(names);
            }

            while (rs.next()){
                ArrayList<String> row = new ArrayList<>();

                for(int i = 1; i<=numParam; i++){
                    row.add(rs.getString(i));
                }
                results.add(row);
            }

            return results;

        } catch (SQLException e){
            String n = String.valueOf(numParam);
            e.printStackTrace();
//            DLException dlException = new DLException(e, query, n);
            return null;
        } catch (NullPointerException e){
            ArrayList<ArrayList<String>> empty = new ArrayList<>();
            return empty;
        }
    }

    public void setDatabase(String Query){
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertItem(String name, LocalDate due, String type, String description, String status){
        String Query = "INSERT INTO Item(ItemName, ItemDue, ItemDescription, ItemType, ItemStatus ), VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(Query);
            statement.setString(1, name);
            Date date = Date.valueOf(due);
            statement.setDate(2, date);
            statement.setString(3, description);
            statement.setString(4, type);
            statement.setString(5, status);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

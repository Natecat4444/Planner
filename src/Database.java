/**
 * Created by nathankaufman on 9/13/19.
 */
import java.sql.*;
import java.util.ArrayList;

public class Database<E> {
    private static String uri = null;
    private static String driver = null;
    private static String user = null;
    private static String password = null;
    private Connection conn = null;

    public Database(String username, String password){
        uri = "jdbc:mysql://localhost/Schedule?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        driver = "com.mysql.cj.jdbc.Driver";
        user = username;
        this.password =  password;
        conn = null;
    }

    public Database(){
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

}

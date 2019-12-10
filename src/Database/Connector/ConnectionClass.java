package Database.Connector;
import java.sql.*;
public class ConnectionClass {
    public Connection con;
    public Connection getConnection(){
        String dbname = "youtube_database";
        String userName = "root";
        String password = "vietlong@123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/youtube_database","root","vietlong@123");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

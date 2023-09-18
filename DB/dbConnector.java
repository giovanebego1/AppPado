import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




public class dbConnector {
    public static void main(String[] args){
        String db = "jdbc:sqlite:/C:\\CodeTools\\sqlite\\tools\\sqlite-tools-win32-x86-3430000\\jornada.db";
        try {
        Connection connection = DriverManager.getConnection(db);
        
        String sql = "select * from residents";
        Statement statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(sql);
        while(result.next()) {
        	String id = result.getString("resident_id");
        	String email = result.getString("resident_email");
        	String phone = result.getString("resident_phone");
        	
        	
        	System.out.println(id + "|" + email + "|" + phone);
        }
        
         
        }catch (SQLException e) {
        	System.out.println("Error connecting to db");
        	e.printStackTrace();
        }
}}

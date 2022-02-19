package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//singleton
public class DatabaseCon {

    private static DatabaseCon instance;
    private Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/grill_orders";
    private final String username = "root";
    private final String password = "rootroot";

    private DatabaseCon (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        } catch(SQLException k){
            k.printStackTrace();
        }
    }

    public static DatabaseCon getInstance(){
        if(instance == null){
            instance = new DatabaseCon();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }
}

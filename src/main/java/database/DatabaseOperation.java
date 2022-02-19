package database;

import java.sql.*;
import java.time.LocalDateTime;

public class DatabaseOperation {
    public static void insertInfoToDB(int shopId, int breadType, int meatType, int garnishType, LocalDateTime time){
        Connection connection = DatabaseCon.getInstance().getConn();
        String sql = "INSERT INTO sales(shop_id,bread_type_id,meat_type_id,salad_type_id,date_created) VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,shopId);
            ps.setInt(2,breadType);
            ps.setInt(3,meatType);
            ps.setInt(4,garnishType);
            Timestamp timestamp = Timestamp.valueOf(time);
            ps.setTimestamp(5,timestamp);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void printNumberOfOrders(){
        Connection connection = DatabaseCon.getInstance().getConn();
        String sql = "select count(*) from sales where shop_id = 3";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Amount of orders made "+rs.getInt("count(*)"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

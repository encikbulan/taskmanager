package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import model.User;

public class UserDao {
	public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?,?,?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskmanager?useSSL=false", "root", "");

            
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return result;
    }
	
	public static List<User> getAllUser(){  
        List<User> list=new ArrayList<User>();  
          
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	User e=new User();  
                e.setId(rs.getInt(1));  
                e.setFirstName(rs.getString(2));  
                e.setLastName(rs.getString(3));
                e.setUsername(rs.getString(4));  
                e.setPassword(rs.getString(5));
                e.setAddress(rs.getString(6));
                e.setContact(rs.getString(7));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
	
	public static int update(User e){  
        int status=0;  
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user set first_name=?,last_name=?,username=?,password=?,address=?,contact=? where id=?");  
            ps.setString(1,e.getFirstName());  
            ps.setString(2,e.getLastName());
            ps.setString(3,e.getPassword()); 
            ps.setString(4,e.getPassword());  
            ps.setString(5,e.getAddress());
            ps.setString(6,e.getContact());
            ps.setInt(7,e.getId());

            status=ps.executeUpdate();  
            System.out.println(ps);
            System.out.println(status);
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
	public static User getUserById(int id){  
        User e=new User();  
          
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setFirstName(rs.getString(2));  
                e.setLastName(rs.getString(3));
                e.setUsername(rs.getString(4));
                e.setPassword(rs.getString(5));
                e.setAddress(rs.getString(6));
                e.setContact(rs.getString(7));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

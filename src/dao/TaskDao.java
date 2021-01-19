package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

import model.Task;

public class TaskDao {
	//define database connection
	
	public static java.sql.Connection getConnection(){  
        java.sql.Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taskmanager?useSSL=false", "root", "");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
	
	public static int save(Task t){  
        int status=0;  
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into task(name,description) values (?,?)");  
            ps.setString(1,t.getName());  
            ps.setString(2,t.getDescription());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
	
	public static int update(Task e){  
        int status=0;  
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update task set name=?,description=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getDescription());
            ps.setInt(3,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	public static int delete(int id){  
        int status=0;  
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from task where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
	
	public static Task getTaskById(int id){  
        Task e=new Task();  
          
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from task where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setDescription(rs.getString(3));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
		
	public static List<Task> getAllTask(){  
        List<Task> list=new ArrayList<Task>();  
          
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from task");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Task e=new Task();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setDescription(rs.getString(3));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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

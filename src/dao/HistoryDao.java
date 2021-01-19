package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.History;
import model.Task;

public class HistoryDao {

	public static java.sql.Connection getConnection(){  
        java.sql.Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taskmanager?useSSL=false", "root", "");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
	
	public static List<History> getAllHistory(){  
        List<History> list=new ArrayList<History>();  
          
        try{  
            java.sql.Connection con=TaskDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from taskhistory");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	History e=new History();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setDescription(rs.getString(3));
                e.setDate(rs.getString(4));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
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
                System.out.println("Masuk1");
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
        
        try {
        	java.sql.Connection con=TaskDao.getConnection();  
        	PreparedStatement pss=con.prepareStatement("insert into taskhistory(name,description,date) values (?,?,?)");  
            pss.setString(1,e.getName());  
            pss.setString(2,e.getDescription());
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            pss.setTimestamp(3, date);
            System.out.println(pss);
            pss.executeUpdate();
            con.close();  
        
        }catch(Exception ex){ex.printStackTrace();}  
        return e;  
    }
	
}

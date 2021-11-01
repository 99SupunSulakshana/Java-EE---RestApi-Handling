package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.User;


public class UserRepository {
	
	Connection con = null;
	
	public UserRepository()
	{
		String url = "Jdbc:mysql://localhost:3306/abchospital/api?serverTimeZone=UTC";
		String username ="root";
		String password ="";
		try {
			
		  Class.forName("com.mysql.jdbc.Driver");
		  con = DriverManager.getConnection(url,username,password);
		  
		  
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		String sql = "select * from user";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				User u = new User();
				
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				
				users.add(u);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return users;
	}
	
	
	
	
	public User getUser(int id)
	{
		String sql = "select * from user where id ="+id;
		User u = new User();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return u;
	
	}

	public void create(User u1) {
		
		String sql="insert into user values(?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  u1.getId());
			st.setString(2, u1.getEmail());
			st.setString(3,u1.getPassword());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(User u1) {
		
		String sql="update user set email=?, password=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, u1.getEmail());
			st.setString(2, u1.getPassword());
			st.setInt(3,  u1.getId());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from user where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	

}

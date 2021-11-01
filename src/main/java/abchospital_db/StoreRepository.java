package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Store;

public class StoreRepository {
	

Connection con = null;
	
	public StoreRepository()
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
	
	public List<Store> getStores()
	{
		List<Store> stores = new ArrayList<>();
		String sql = "select * from store";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Store s = new Store();
				
				s.setId(rs.getInt(1));
				s.setItemName(rs.getString(2));
				s.setAmount(rs.getInt(3));
				s.setDescription(rs.getString(4));
				
				stores.add(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return stores;
	}
	
	
	
	
	public Store getStore(int id)
	{
		String sql = "select * from store where id ="+id;
		Store u = new Store();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				u.setId(rs.getInt(1));
				u.setItemName(rs.getString(2));
				u.setAmount(rs.getInt(3));
				u.setDescription(rs.getString(4));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return u;
	
	}

	public void create(Store s1) {
		
		String sql="insert into store values(?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  s1.getId());
			st.setString(2, s1.getItemName());
			st.setInt(3,s1.getAmount());
			st.setString(4, s1.getDescription());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Store s1) {
		
		String sql="update store set itemName=?, amount=?, descrip=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, s1.getItemName());
			st.setInt(2, s1.getAmount());
			st.setString(3,  s1.getDescription());
			st.setInt(4, s1.getId());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from store where id=?";
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

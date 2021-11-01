package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Ward;



public class WardRepository {
	
	Connection con = null;
	
	public WardRepository()
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
	
	public List<Ward> getWards()
	{
		List<Ward> wards = new ArrayList<>();
		String sql = "select * from ward";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Ward w = new Ward();
				
				w.setId(rs.getInt(1));
				w.setName(rs.getString(2));
				w.setBeds(rs.getInt(3));
				w.setRooms(rs.getInt(4));
				w.setHead(rs.getString(5));
				w.setSittingArea(rs.getString(6));
				w.setSection(rs.getString(7));
				
				wards.add(w);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return wards;
	}
	
	
	
	
	public Ward getWard(int id)
	{
		String sql = "select * from ward where id ="+id;
		Ward w = new Ward();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				w.setId(rs.getInt(1));
				w.setName(rs.getString(2));
				w.setBeds(rs.getInt(3));
				w.setRooms(rs.getInt(4));
				w.setHead(rs.getString(5));
				w.setSittingArea(rs.getString(6));
				w.setSection(rs.getString(7));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return w;
	
	}

	public void create(Ward w1) {
		
		String sql="insert into ward values(?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,  w1.getId());
			st.setString(2, w1.getName());
			st.setInt(3, w1.getBeds());
			st.setInt(4, w1.getRooms());
			st.setString(5, w1.getHead());
			st.setString(6, w1.getSittingArea());
			st.setString(7, w1.getSection());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Ward  w1) {
		
		String sql="update ward name=?, bed=?, rooms=?, head=?, area=?, section=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, w1.getName());
			st.setInt(2, w1.getBeds());
			st.setInt(3, w1.getRooms());
			st.setString(4, w1.getHead());
			st.setString(5, w1.getSittingArea());
			st.setString(6, w1.getSection());
			st.setInt(7,  w1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from ward where id=?";
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

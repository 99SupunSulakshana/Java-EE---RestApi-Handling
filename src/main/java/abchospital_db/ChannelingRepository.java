package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Channel;

public class ChannelingRepository {
	
	
Connection con = null;
	
	public ChannelingRepository()
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
	
	public List<Channel> getChannels()
	{
		List<Channel> channels = new ArrayList<>();
		String sql = "select * from channel";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Channel c = new Channel();
				
				c.setId(rs.getInt(1));
				c.setDatetime(rs.getString(2));
				c.setDoctor(rs.getString(3));
				c.setSection(rs.getString(4));
				
				channels.add(c);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return channels;
	}
	
	
	
	
	public Channel getChannel (int id)
	{
		String sql = "select * from channel where id ="+id;
		Channel c = new Channel();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				c.setId(rs.getInt(1));
				c.setDatetime(rs.getString(2));
				c.setDoctor(rs.getString(3));
				c.setSection(rs.getString(4));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return c;
	
	}

	public void create(Channel c1) {
		
		String sql="insert into channel values(?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,  c1.getId());
			st.setString(2, c1.getDatetime());
			st.setString(3, c1.getDoctor());
			st.setString(4, c1.getSection());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Channel c1) {
		
		String sql="update channel set datetime=?, doctor=?, section=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, c1.getDatetime());
			st.setString(2, c1.getDoctor());
			st.setString(3, c1.getSection());
			st.setInt(4,  c1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from channel where id=?";
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

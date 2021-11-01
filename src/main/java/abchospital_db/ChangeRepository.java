package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Change;



public class ChangeRepository {
	
Connection con = null;
	
	public ChangeRepository()
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
	
	public List<Change> getChanges()
	{
		List<Change> changes = new ArrayList<>();
		String sql = "select * from change";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Change c = new Change();
				
				c.setId(rs.getInt(1));
				c.setpName(rs.getString(2));
				c.setBranch(rs.getString(3));
				c.setpName(rs.getString(4));
				c.setCondition(rs.getString(5));
				c.setFinalTreat(rs.getString(6));
				
				changes.add(c);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return changes;
	}
	
	
	
	
	public Change getChange(int id)
	{
		String sql = "select * from change where id ="+id;
		Change c = new Change();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				c.setId(rs.getInt(1));
				c.setpName(rs.getString(2));
				c.setBranch(rs.getString(3));
				c.setpName(rs.getString(4));
				c.setCondition(rs.getString(5));
				c.setFinalTreat(rs.getString(6));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return c;
	
	}

	public void create(Change c1) {
		
		String sql="insert into change values(?,?,?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  c1.getId());
			st.setString(2, c1.getpName());
			st.setString(3, c1.getBranch());
			st.setString(4, c1.getpName());
			st.setString(5, c1.getCondition());
			st.setString(6, c1.getFinalTreat());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Change c1) {
		
		String sql="update change set name=?, branch=?, pName=?, conditionP=?, finalTreat=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, c1.getpName());
			st.setString(2, c1.getBranch());
			st.setString(3, c1.getpName());
			st.setString(4, c1.getCondition());
			st.setString(5, c1.getFinalTreat());
			st.setInt(6,  c1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from change where id=?";
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

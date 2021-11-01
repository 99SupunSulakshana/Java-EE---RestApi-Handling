package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.MediPackage;



public class MedicalpkgRepository {
Connection con = null;
	
	public MedicalpkgRepository()
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
	
	public List<MediPackage> getMediPackages()
	{
		List<MediPackage> MediPackages = new ArrayList<>();
		String sql = "select * from medicalpkg";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				MediPackage m = new MediPackage();
				
				m.setId(rs.getInt(1));
				m.setPkgName(rs.getString(2));
				m.setDesc(rs.getString(3));
				m.setPrice(rs.getDouble(4));
			
				MediPackages.add(m);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return MediPackages;
	}
	
	
	
	
	public MediPackage getMediPackage(int id)
	{
		String sql = "select * from medicalpkg where id ="+id;
		MediPackage m = new MediPackage();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				m.setId(rs.getInt(1));
				m.setPkgName(rs.getString(2));
				m.setDesc(rs.getString(3));
				m.setPrice(rs.getDouble(4));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return m;
	
	}

	public void create(MediPackage m1) {
		
		String sql="insert into user values(?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  m1.getId());
			st.setString(2, m1.getPkgName());
			st.setString(3, m1.getDesc());
			st.setDouble(4, m1.getPrice());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(MediPackage m1) {
		
		String sql="update medicalpkg set name=?, descs=?, price=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, m1.getPkgName());
			st.setString(2, m1.getDesc());
			st.setDouble(3, m1.getPrice());
			st.setInt(4,  m1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
 

	public void delete(int id) {
		
		String sql="delete from medicalpkg where id=?";
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

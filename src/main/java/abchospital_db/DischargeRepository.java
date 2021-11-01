package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Discharge;

public class DischargeRepository {
	

	Connection con = null;
	
	public DischargeRepository()
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
	
	public List<Discharge> getDischarges()
	{
		List<Discharge> discharges = new ArrayList<>();
		String sql = "select * from discharge";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
			    Discharge d = new Discharge();
				
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setNic(rs.getString(3));
				d.setGender(rs.getString(4));
				d.setMobile(rs.getInt(5));
				d.setBdy(rs.getString(6));
				d.setAge(rs.getInt(7));
				d.setAddress(rs.getString(8));
				d.setPatientGradian(rs.getString(9));
				d.setDischargeDate(rs.getString(10));
				d.setCondition(rs.getString(11));
				d.setWardName(rs.getString(12));
				d.setDoctor(rs.getString(13));
				
				discharges.add(d);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return discharges;
		
	}
	
	
	public Discharge getDischarge(int id)
	{
		String sql = "select * from discharge where id ="+id;
		Discharge d = new Discharge();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setNic(rs.getString(3));
				d.setGender(rs.getString(4));
				d.setMobile(rs.getInt(5));
				d.setBdy(rs.getString(6));
				d.setAge(rs.getInt(7));
				d.setAddress(rs.getString(8));
				d.setPatientGradian(rs.getString(9));
				d.setDischargeDate(rs.getString(10));
				d.setCondition(rs.getString(11));
				d.setWardName(rs.getString(12));
				d.setDoctor(rs.getString(13));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return d;
	
	}

	public void create(Discharge d1) {
		
		String sql="insert into discharge values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,  d1.getId());
			st.setString(2, d1.getFullName());
			st.setString(3, d1.getNic());
			st.setString(4, d1.getGender());
			st.setInt(5, d1.getMobile());
			st.setString(6, d1.getBdy());
			st.setInt(7, d1.getAge());
			st.setString(8, d1.getAddress());
			st.setString(9, d1.getPatientGradian());
			st.setString(10, d1.getDischargeDate());
			st.setString(11, d1.getCondition());
			st.setString(12, d1.getWardName());
			st.setString(13, d1.getDoctor());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Discharge d1) {
		
		String sql="update discharge set fullname=?, nic=?, gender=?, mobile=?, bdy=?, age=?, address=?, gardian=?, dischargeDate=?, conditionP=?, ward=?, doctor=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
		
			
			st.setString(1, d1.getFullName());
			st.setString(2, d1.getNic());
			st.setString(3, d1.getGender());
			st.setInt(4, d1.getMobile());
			st.setString(5, d1.getBdy());
			st.setInt(6, d1.getAge());
			st.setString(7, d1.getAddress());
			st.setString(8, d1.getPatientGradian());
			st.setString(9, d1.getDischargeDate());
			st.setString(10, d1.getCondition());
			st.setString(11, d1.getWardName());
			st.setString(12, d1.getDoctor());
			st.setInt(13,  d1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from discharge where id=?";
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

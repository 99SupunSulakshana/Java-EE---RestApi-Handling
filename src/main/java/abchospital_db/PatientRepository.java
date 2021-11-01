package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Patient;



public class PatientRepository {
	
Connection con = null;
	
	public PatientRepository()
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
	
	public List<Patient> getPatients()
	{
		List<Patient> patients = new ArrayList<>();
		String sql = "select * from patient";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Patient p = new Patient();
				
				p.setId(rs.getInt(1));
				p.setFullName(rs.getString(2));
				p.setNic(rs.getString(3));
				p.setGender(rs.getString(4));
				p.setMobile(rs.getInt(5));
				p.setBdy(rs.getString(6));
				p.setAge(rs.getInt(7));
				p.setAddress(rs.getString(8));
				p.setAttendCheck(rs.getString(9));
				p.setPatientGradian(rs.getString(10));
				p.setEnterDate(rs.getString(11));
				p.setWardName(rs.getString(12));
				p.setDoctor(rs.getString(13));
				
				patients.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return patients;
	}
	
	
	
	
	public Patient getPatient(int id)
	{
		String sql = "select * from patient where id ="+id;
		Patient p = new Patient();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				p.setId(rs.getInt(1));
				p.setFullName(rs.getString(2));
				p.setNic(rs.getString(3));
				p.setGender(rs.getString(4));
				p.setMobile(rs.getInt(5));
				p.setBdy(rs.getString(6));
				p.setAge(rs.getInt(7));
				p.setAddress(rs.getString(8));
				p.setAttendCheck(rs.getString(9));
				p.setPatientGradian(rs.getString(10));
				p.setEnterDate(rs.getString(11));
				p.setWardName(rs.getString(12));
				p.setDoctor(rs.getString(13));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return p;
	
	}

	public void create(Patient p1) {
		
		String sql="insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  p1.getId());
			st.setString(2, p1.getFullName());
			st.setString(3, p1.getNic());
			st.setString(4, p1.getGender());
			st.setInt(5, p1.getMobile());
			st.setString(6, p1.getBdy());
			st.setInt(7, p1.getAge());
			st.setString(8, p1.getAddress());
			st.setString(9, p1.getAttendCheck());
			st.setString(10, p1.getPatientGradian());
			st.setString(11, p1.getEnterDate());
			st.setString(12, p1.getWardName());
			st.setString(13, p1.getDoctor());
		
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Patient p1) {
		
		String sql="update patient fullname=?, nic=?, gender=?, mobile=?, bdy=?, age=?, address=?, attendcheck=?, gardian=?, enterdate=?, wardname=?, doctor=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, p1.getFullName());
			st.setString(2, p1.getNic());
			st.setString(3, p1.getGender());
			st.setInt(4, p1.getMobile());
			st.setString(5, p1.getBdy());
			st.setInt(6, p1.getAge());
			st.setString(7, p1.getAddress());
			st.setString(8, p1.getAttendCheck());
			st.setString(9, p1.getPatientGradian());
			st.setString(10, p1.getEnterDate());
			st.setString(11, p1.getWardName());
			st.setString(12, p1.getDoctor());
			st.setInt(13,  p1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}


	public void delete(int id) {
		
		String sql="delete from patient where id=?";
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

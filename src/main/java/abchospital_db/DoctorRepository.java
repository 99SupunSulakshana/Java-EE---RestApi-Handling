package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Doctor;



public class DoctorRepository {
		
		Connection con = null;
		
		public DoctorRepository()
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
		
		public List<Doctor> getDoctors()
		{
			List<Doctor> Doctors = new ArrayList<>();
			String sql = "select * from doctor";
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					Doctor d = new Doctor();
					
					d.setId(rs.getInt(1));
					d.setNic(rs.getString(2));
					d.setFullname(rs.getString(3));
					d.setAddress(rs.getString(4));
					d.setCitizen(rs.getString(5));
					d.setEmail(rs.getString(6));
					d.setAge(rs.getInt(7));
					d.setGraduatedY(rs.getInt(8));
					d.setGraduatedCampus(rs.getString(9));
					d.setCetifyY(rs.getInt(10));
					d.setSection(rs.getString(11));
					d.setCategory(rs.getString(12));
					d.setWard(rs.getString(13));
					
					
					Doctors.add(d);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
			return Doctors;
		}
		
		
		
		
		public Doctor getDoctor(int id)
		{
			String sql = "select * from doctor where id ="+id;
			Doctor d = new Doctor();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next())
				{
					
					d.setId(rs.getInt(1));
					d.setNic(rs.getString(2));
					d.setFullname(rs.getString(3));
					d.setAddress(rs.getString(4));
					d.setCitizen(rs.getString(5));
					d.setEmail(rs.getString(6));
					d.setAge(rs.getInt(7));
					d.setGraduatedY(rs.getInt(8));
					d.setGraduatedCampus(rs.getString(9));
					d.setCetifyY(rs.getInt(10));
					d.setSection(rs.getString(11));
					d.setCategory(rs.getString(12));
					d.setWard(rs.getString(13));
					
				}
			}
			catch(Exception e)
			{
				
				System.out.println(e);
				
			}
		
			return d;
		
		}

		public void create(Doctor d1) {
			
			String sql="insert into doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, d1.getId());
				st.setString(2, d1.getNic());
				st.setString(3, d1.getFullname());
				st.setString(4, d1.getAddress());
				st.setString(5, d1.getCitizen());
				st.setString(6, d1.getEmail());
				st.setInt(7, d1.getAge());
				st.setInt(8, d1.getGraduatedY());
				st.setString(9, d1.getGraduatedCampus());
				st.setInt(10, d1.getCetifyY());
				st.setString(11, d1.getSection());
				st.setString(12, d1.getCategory());
				st.setString(13, d1.getWard());
				st.executeUpdate();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
		
		public void update(Doctor d1) {
			
			String sql="update doctor SET nic=?, fullname=?, address=?, citizen=?, email=?, age=?, graduatyedY=?, graduatedCampus=?, cetifiY=?, secsion=?, category=?, ward=? where id=?";
			try {
				
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, d1.getNic());
				st.setString(2, d1.getFullname());
				st.setString(3, d1.getAddress());
				st.setString(4, d1.getCitizen());
				st.setString(5, d1.getEmail());
				st.setInt(6, d1.getAge());
				st.setInt(7, d1.getGraduatedY());
				st.setString(8, d1.getGraduatedCampus());
				st.setInt(9, d1.getCetifyY());
				st.setString(10, d1.getSection());
				st.setString(11, d1.getCategory());
				st.setString(12, d1.getWard());
				st.setInt(13, d1.getId());
				st.executeUpdate();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}



		public void delete(int id) {
			
			String sql="delete from doctor where id=?";
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

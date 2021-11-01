package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Appoinment;

public class AppoinmentRepository {

		Connection con = null;
		
		public AppoinmentRepository()
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
		
		public List<Appoinment> getAppoinments()
		{
			List<Appoinment> appoinments = new ArrayList<>();
			String sql = "select * from appoinment";
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					Appoinment a = new Appoinment();
					
					a.setId(rs.getInt(1));
					a.setFullName(rs.getString(2));
					a.setGender(rs.getString(3));
					a.setPhone(rs.getInt(4));
					a.setBdy(rs.getString(5));
					a.setAddress(rs.getString(6));
					a.setEmail(rs.getString(7));
					a.setAdmitCheck(rs.getString(8));
					a.setCondition(rs.getString(9));
					a.setDoctor(rs.getString(10));
					
					appoinments.add(a);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
			return appoinments;
		}
		
		
		
		
		public Appoinment getAppoinment(int id)
		{
			String sql = "select * from appoinment where id ="+id;
			Appoinment a = new Appoinment();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next())
				{
					
					a.setId(rs.getInt(1));
					a.setFullName(rs.getString(2));
					a.setGender(rs.getString(3));
					a.setPhone(rs.getInt(4));
					a.setBdy(rs.getString(5));
					a.setAddress(rs.getString(6));
					a.setEmail(rs.getString(7));
					a.setAdmitCheck(rs.getString(8));
					a.setCondition(rs.getString(9));
					a.setDoctor(rs.getString(10));
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
			return a;
		
		}

		public void create(Appoinment a1) {
			
			String sql="insert into appoinment values(?,?,?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1,  a1.getId());
				st.setString(2, a1.getFullName());
				st.setString(3, a1.getGender());
				st.setInt(4, a1.getPhone());
				st.setString(5, a1.getBdy());
				st.setString(6, a1.getAddress());
				st.setString(7, a1.getEmail());
				st.setString(8, a1.getAdmitCheck());
				st.setString(9, a1.getCondition());
				st.setString(10, a1.getDoctor());
				
				
				st.executeUpdate();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
		
		public void update(Appoinment a1) {
			
			String sql="update appoinment fullname=?, gender=?, phone=?, bdy=?, address=?, email=?, admitCheck=?, pcondition=?, doctor=? where id=?";
			try {
				
				PreparedStatement st = con.prepareStatement(sql);
				
				
				st.setString(1, a1.getFullName());
				st.setString(2, a1.getGender());
				st.setInt(3, a1.getPhone());
				st.setString(4, a1.getBdy());
				st.setString(5, a1.getAddress());
				st.setString(6, a1.getEmail());
				st.setString(7, a1.getAdmitCheck());
				st.setString(8, a1.getCondition());
				st.setString(9, a1.getDoctor());
				st.setInt(10,  a1.getId());
				
				st.executeUpdate();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}



		public void delete(int id) {
			
			String sql="delete from appoinment where id=?";
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

package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abchospital_models.Medicine;

public class MedicineDetailsRepository {
	
Connection con = null;
	
	public MedicineDetailsRepository()
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
	
	public List<Medicine> getMedicines()
	{
		List<Medicine> medicines = new ArrayList<>();
		String sql = "select * from medicine";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Medicine m = new Medicine();
				
				m.setId(rs.getInt(1));
				m.setMediName(rs.getString(2));
				m.setMediCategory(rs.getString(3));
				m.setMediDelivryDate(rs.getString(4));
				m.setAmount(rs.getInt(5));
				m.setMediCompany(rs.getString(6));
				m.setMediManufact(rs.getString(7));
				m.setMediExpire(rs.getString(8));
				m.setMediNext(rs.getString(9));
				
				medicines.add(m);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return medicines;
	}
	
	
	
	
	public Medicine getMedicine(int id)
	{
		String sql = "select * from medicine where id ="+id;
		Medicine m = new Medicine();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				m.setId(rs.getInt(1));
				m.setMediName(rs.getString(2));
				m.setMediCategory(rs.getString(3));
				m.setMediDelivryDate(rs.getString(4));
				m.setAmount(rs.getInt(5));
				m.setMediCompany(rs.getString(6));
				m.setMediManufact(rs.getString(7));
				m.setMediExpire(rs.getString(8));
				m.setMediNext(rs.getString(9));
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return m;
	
	}

	public void create(Medicine m1) {
		
		String sql="insert into medicine values(?,?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,  m1.getId());
			st.setString(2, m1.getMediName());
			st.setString(3, m1.getMediCategory());
			st.setString(4, m1.getMediDelivryDate());
			st.setInt(5, m1.getAmount());
			st.setString(6, m1.getMediCompany());
			st.setString(7, m1.getMediManufact());
			st.setString(8, m1.getMediExpire());
			st.setString(9, m1.getMediNext());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	public void update(Medicine m1) {
		
		String sql="update medicine set name=?, category=?, delevrydate=?, amount=?, company=?, manufactureDate=?,expireDate=?, next=? where id=?";
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, m1.getMediName());
			st.setString(2, m1.getMediCategory());
			st.setString(3, m1.getMediDelivryDate());
			st.setInt(4, m1.getAmount());
			st.setString(5, m1.getMediCompany());
			st.setString(6, m1.getMediManufact());
			st.setString(7, m1.getMediExpire());
			st.setString(8, m1.getMediNext());
			st.setInt(9,  m1.getId());
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}



	public void delete(int id) {
		
		String sql="delete from medicine where id=?";
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

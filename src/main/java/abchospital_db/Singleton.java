package abchospital_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Singleton {
	
		private static Singleton obj = null;

		private static final String urldb = "jdbc:mysql://localhost:3306/abchospital/api";
		private static final String usernamedb = "root";
		private static final String passworddb = "";

		public Connection conn = null;
		public PreparedStatement pStatment;
		public ResultSet resultSet = null;

		
		private Singleton() throws SQLException, ClassNotFoundException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
				
			} catch (SQLException ex) {
				System.out.println(ex);
				System.out.println("Database Connection Error !.");
			}
		}

		
		public static Singleton getInstance() throws ClassNotFoundException, SQLException {
			if (obj == null) {
				obj = new Singleton();
			}
			return obj;
		}

		public ResultSet read(String selectQuery) {
			try {
				pStatment = (PreparedStatement) conn.prepareStatement(selectQuery);
				resultSet = pStatment.executeQuery();
			} catch (SQLException ex) {
				System.out.println(ex);
				resultSet = null;
			}
			return resultSet;
		}

		public ResultSet search(String selectQuery) {
			try {
				pStatment = (PreparedStatement) conn.prepareStatement(selectQuery);
				resultSet = pStatment.executeQuery();
			} catch (SQLException ex) {
				System.out.println(ex);
				resultSet = null;
			}
			return resultSet;
		}

		public boolean add(String insertQuery) {
			boolean x = false;
			try {
				
				conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
				pStatment = (PreparedStatement) conn.prepareStatement(insertQuery);
				x = true;
			} catch (SQLException ex) {
				System.out.println(ex);
				x = false;
			}
			return x;
		}

		public boolean update(String updateQuery) {
			boolean x = false;
			try {
				pStatment = (PreparedStatement) conn.prepareStatement(updateQuery);
				x = true;
			} catch (SQLException ex) {
				System.out.println(ex);
				x = false;
			}
			return x;
		}

		public boolean delete(String deleteQuery) {
			boolean x = false;
			try {
				pStatment = (PreparedStatement) conn.prepareStatement(deleteQuery);
				x = true;
			} catch (SQLException ex) {
				System.out.println(ex);
				x = false;
			}
			return x;
		}

		public boolean executeQuery() throws SQLException {
			boolean x = false;
			try {
				if (pStatment.executeUpdate() == 1) {
					x = true;

				} else {
					x = false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pStatment.close();
				conn.close();
			}

			return x;
		}

		public boolean isConnected() throws SQLException, ClassNotFoundException {
			boolean is;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(urldb, usernamedb, passworddb);
				is = true;
			} catch (SQLException ex) {
				System.out.println(ex);
				is = false;
			}

			return is;
		}

}

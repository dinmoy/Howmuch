package JavaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonFrame {
	static Connection con;
	static Statement stmt;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/shopingdb", "root", "1234");
			stmt = con.createStatement();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static ResultSet getResulSet(String sql, Objesct...paramter) {
		try {
			var pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i < paramter.length; i++) {
				pstmt.setObject(i + 1, paramter[i]);
			}
			
			return pstmt.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	static ResultSet updateSQL(String sql, Object... paramter) {
		try {
			var pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			for(int i = 0; i < paramter.length; i++) {
				pstmt.setObject(i + 1, paramter[i]);
			}
			
			pstmt.executeUpdate();
			
			return pstmt.getGeneratedKeys();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

package JavaProject;

import java.sql.DriverManager;

public class Database {
	public static void main(String[] args) throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/shopingdb", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = true");
		
		try {
			stmt.execute("DROP DATABASE `shopingdb`");
			System.out.println(";;shopingdb 제거");
		}
		
		catch(Exception e) {
			System.out.println("shopingdb 존재하지 않음");
		}
		
		stmt.execute("CREATE SCHEMA `shopingdb` DEFAULT CHARACTER SET utf8;");
		System.out.println("shopingdb DB 생성");
		
		stmt.execute("CREATE TABLE `shopingdb`.`user` ("
				+ "u_no INT PRIMARY KEY AUTO_INCREMENT,"
				+ "u_name VARCHAR(10),"
				+ "u_id VARCHAR(10),"
				+ "u_pw VARCHAR(15),"
				+ "u_pwCheck VARCHAR(15),"
				+ "u_email VARCHAR(30))");
		
		System.out.println("user DB 생성");
		
	}
}

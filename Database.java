package JavaProject;

import java.sql.DriverManager;

public class Database {
	
	//https://sharpcoder.tistory.com/44
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static void main(String[] args) throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://localhost/shopingdb", "Hyojin", "heejung8761!");
		var stmt = con.createStatement();
		
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
		
		stmt.execute("CREATE TABLE `shopingdb`.`info` ("
				+ "i_no INT PRIMARY KEY AUTO_INCREMENT,"
				+ "i_id VARCHAR(10),"
				+ "i_date VARCHAR(30),"
				+ "i_way VARCHAR(15),"
				+ "i_category VARCHAR(15),"
				+ "i_uselist VARCHAR(15),"
				+ "i_price INT,"
				+ "u_no INT,"
				+ "CONSTRAINT FK_0_i_no FOREIGN KEY (u_no) REFERENCES user (u_no) ON DELETE CASCADE ON UPDATE CASCADE)");
		System.out.println("info DB 생성");
	}

	public static String[][] getCustumers() {
		// TODO Auto-generated method stub
		return null;
	}
}

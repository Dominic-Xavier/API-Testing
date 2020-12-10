package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class Jdbc {
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	@Test
	public void setup() throws ClassNotFoundException, SQLException {
		String query = "select * from login";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		System.out.println("  ID : Name : Password : Mobile Number");
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString("Username");
			String Pass = rs.getString("Password");
			String MobNum = rs.getString("Mobile_Number");
			
			System.out.println(id+":"+name+":"+Pass+":"+MobNum);
		}
	}
}

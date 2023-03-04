package jdbc_fullpower;
import java.sql.*;
public class connector{
	public static Connection connect() {
		Connection conn=null;
		String url="jdbc:mariadb://localhost:3306/hdfc";
		String user="raj";
		String pwd="raj";
		try {
			conn=DriverManager.getConnection(url, user, pwd);
			
		} catch(ClassCastException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
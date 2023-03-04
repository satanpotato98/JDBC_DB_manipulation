package emp_func;
import java.sql.*;
import jdbc_fullpower.connector;
import get_set.emp;
import java.util.ArrayList;
import java.util.List;
public class run 
{
	//insert , delete, update, select, custom.
		Connection con=connector.connect();
		public int insert(emp e) {
			int count=0;
			String query="insert into employee(eid,name,salary,dept) values(?,?,?,?)";
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(query);
				psmt.setInt(1, e.getEid());
				psmt.setString(2, e.getName());
				psmt.setDouble(3, e.getSalary());
				psmt.setString(4, e.getDept());
				count=psmt.executeUpdate();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return count;
		}
		public int delete(emp e) {
			int count=0;
			String query="delete from employee where eid = ?";
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(query);
				psmt.setInt(1, e.getEid());
				count=psmt.executeUpdate();
			}
			catch (SQLException e1) {
			e1.printStackTrace();
			}
			return count;
		}
		public int update(emp e) {
			int count=0;
			String query="update employee set name=?,salary=?,dept=? where eid=?";
			PreparedStatement psmt;
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1, e.getName());
				psmt.setDouble(2, e.getSalary());
				psmt.setString(3, e.getDept());
				psmt.setInt(4, e.getEid());
				count=psmt.executeUpdate();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			return count;
		}
		public emp display_by_id(int id) {
			String query="select * from employee where eid=?";
			emp e =new emp();
			PreparedStatement psmt;
			try {
				psmt=con.prepareStatement(query);
				psmt.setInt(1, id);
				ResultSet rs= psmt.executeQuery();
				if(rs.next()) {
					e.setEid(rs.getInt("eid"));
					e.setName(rs.getString("name"));
					e.setSalary(rs.getDouble("salary"));
					e.setDept(rs.getString("dept"));
				}
				else {
					System.out.println("doesnt exist");
				}
			}catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			return e;
		}
		public List display_table() {
			String query="select * from employee;";
			List<emp> e=new ArrayList<emp>();
			PreparedStatement psmt;
			try {
				psmt=con.prepareStatement(query);
				ResultSet rs= psmt.executeQuery();
				while(rs.next()) {
					emp empl= new emp(rs.getInt("eid"),rs.getString("name"),rs.getDouble("salary"),rs.getString("dept"));
					e.add(empl);
				}
			}
			catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			return e;
		}
}


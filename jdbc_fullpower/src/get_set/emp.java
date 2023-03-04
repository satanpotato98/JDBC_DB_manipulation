package get_set;

public class emp {
	int eid;
	String name, dept;
	double salary;
	public emp(int eid, String name, double salary, String dept) {
		super();
		this.eid=eid;
		this.name=name;
		this.salary=salary;
		this.dept=dept;
	}
	public emp() {}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "emp [eid=" + eid + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
}

package jdbc_fullpower;
import emp_func.run;
import get_set.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
	static	Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
	run query=new run();
	int choice,count,id;
	boolean flag=true;
	while(flag) {
		System.out.println("------------------------------");
		System.out.println("1. Add employee");
		System.out.println("2. delete employee");
		System.out.println("3. update employee By Id");
		System.out.println("4. Display  employee By Id");
		System.out.println("5. Display all employee");
		System.out.println("0. Exit/Logout");
		System.out.println("------------------------------>");
		choice=scanner.nextInt();
		switch(choice) {
		case 1:
			count=0;
			emp e_insert=inputs();
			count=query.insert(e_insert);
			System.out.println(count + " record is inserted");
			break;
		case 2:
			count=0;
			emp edelete = new emp();
			System.out.println("enter id: ");
			id=scanner.nextInt();
			edelete.setEid(id);
			count=query.delete(edelete);
			System.out.println(count + " record is deleted");
			break;
		case 3:
			count=0;
			emp eupdate=inputs();
			count=query.update(eupdate);
			System.out.println(count + " record is updated");
			break;
		case 4:
			System.out.println("enter id: ");
			id=scanner.nextInt();
			emp disemp=query.display_by_id(id);
			System.out.println(disemp.toString());
			break;
			
		case 5:
			List<emp> e= query.display_table();
			for (emp dept2 : e) {
				System.out.println(dept2);
			}
				
			break;
			
		case 0:
			System.out.println("BYE");
			flag=false;
			break;
			
			
		}
	}
}
public static emp  inputs() {
	
	System.out.println("Enter eid");
	int eid = scanner.nextInt();
	System.out.println("Enter Name");
	String name = scanner.next();
	System.out.println("Enter salary");
	Double salary = scanner.nextDouble();
	System.out.println("enter dept");
	String dept=scanner.next();
	
	emp empl = new emp(eid,name,salary,dept);	
		
	return empl;
	
	
}
}

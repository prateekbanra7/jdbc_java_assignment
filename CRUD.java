/*
Question1
Give the menu to the user as the operation listed below on student table
1. Create 2. Read 3. Update 4. Delete
*/
package in.ineuron.dynamicinput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Student {
	private int sid;
	private String sname;
	private int sage;
	private String saddr;

	Student(int sid, String sname, int sage, String saddr) {
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.saddr = saddr;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddr=" + saddr + "]";
	}

}

public class CRUD {

	public static void main(String[] args) {

		List<Student> c=new ArrayList<Student>();
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1.CREATE");
			System.out.println("2.READ");
			System.out.println("3.DELETE");
			System.out.println("4.UPDATE");
			System.out.print("Enter your choice :");
			ch=s1.nextInt();
			
			switch(ch) {
			case 1:
				System.out.print("Enter sId   :");
				int sid=s1.nextInt();
				System.out.print("Enter sName :");
				String sname=s2.nextLine();
				System.out.print("Enter sAge  :");
				int sage=s1.nextInt();
				System.out.print("Enter sAddr :");
				String saddr=s2.nextLine();
				
				c.add(new Student(sid,sname,sage,saddr));
				
				break;
				
			case 2:
				System.out.println("-------------------");
				Iterator<Student> i = c.iterator();
				while(i.hasNext()) {
					Student s = i.next();
					System.out.println(s);
				}
				System.out.println("-------------------");
				break;
				
			case 3:
				boolean found = false;
				System.out.print("Enter sId to Delete :");
			    sid=s1.nextInt();
			    System.out.println("-------------------");
				i = c.iterator();
				while(i.hasNext()) {
					Student s = i.next();
					if(s.getSid()==sid) {
						i.remove();
						found=true;
					}
					
				}
				if(!found) {
					System.out.println("Record not found");
				}
				else {
					System.out.println("Record deleted Successfully...");
				}
					
				System.out.println("-------------------");
				break;
				
			case 4:
				found = false;
				System.out.print("Enter sId to Update :");
			    sid=s1.nextInt();
			    System.out.println("-------------------");
				ListIterator<Student> st=c.listIterator();
				while(st.hasNext()) {
					Student s = st.next();
					if(s.getSid()==sid) {
						
						System.out.print("Enter new ID :");
						sid=s1.nextInt();
						
						System.out.print("Enter new Name :");
						sname=s2.nextLine();
						
						System.out.print("Enter new Age :");
						sage=s1.nextInt();
						
						System.out.print("Enter new Address :");
						saddr=s2.nextLine();
						st.set(new Student(sid, sname, sage, saddr));
						found=true;
					}
					
				}
				if(!found) {
					System.out.println("Record not found");
				}
				else {
					System.out.println("Record Updated Successfully...");
				}
					
				System.out.println("-------------------");
				break;
			}
		} while (ch != 0);
	}
}

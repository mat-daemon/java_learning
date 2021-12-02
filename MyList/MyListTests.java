package MyList;

import java.util.Iterator;
import java.util.Scanner;

public class MyListTests {
	
	String[] names = {"Liam",
            "Olivia",
            "Noah",
            "Emma",
            "Oliver",
            "Ava",
            "William",
            "Sophia",
            "Elijah",
            "Isabella",
            "James",
            "Charlotte",
            "Benjamin",
            "Amelia",
            "Lucas",
            "Mia",
            "Mason",
            "Harper",
            "Ethan",
            "Evelyn"};
	int namesRange = names.length-1;
	int maxIndexNumber = 999;
	
	public MyList<Student> gimmieMyList(){
		return gimmieMyList(15);
	}
	public MyList<Student> gimmieMyList(int numberOfStudents){
		MyList<Student> M = new MyList<Student>();
		while(numberOfStudents>0) {
			Student zak = this.gimmieStudent();
			numberOfStudents--;
			M.add(zak);
		}
		return M;
	}
	public Student gimmieStudent() {
		return new Student(this.names[(int)(Math.random()*namesRange)+1], (int)(Math.random()*maxIndexNumber)+1);
	}
	
	public static void main(String args[]) {
		MyListTests test = new MyListTests();
		MyList<Student> M = test.gimmieMyList();
		System.out.println("Menu:"+"\n"+"exit: 0"+"\n"+"size: 1"+"\n"+"add(index): 2"+"\n"+"add: 3"+"\n"+"clear: 4"+"\n"+"indexOf: 5"+"\n"+"contains: 6"+"\n"+"get: 7"+"\n"+"set: 8"+"\n"+"remove: 9");
		Scanner myScanner = new Scanner(System.in);
		int option = myScanner.nextInt();
		while(option != 0) {
			switch(option) {
				case 1:
					System.out.println(M.print());
					System.out.println(M.size());
					break;
				case 2:
					Student zak = test.gimmieStudent();
					System.out.print("Enter the index: ");
					int index = myScanner.nextInt();
					System.out.println("Old MyList: "+M.print());
					M.add(index, zak);
					System.out.println("New MyList: "+M.print());
					break;
				case 3:
					Student zak2 = test.gimmieStudent();
					System.out.println("Old MyList: "+M.print());
					M.add(zak2);
					System.out.println("New MyList: "+M.print());
					break;
				case 4:
					M.clear();
					System.out.println(M.print());
					break;
				case 5:
					System.out.println("Enter name: "); 
			        String nameS = myScanner.next(); 
			   
			        System.out.println("Enter index number: "); 
			        int indexN = myScanner.nextInt();
					Student s = new Student(nameS, indexN);
					
					System.out.println("Array index: "+M.indexOf(s));
					break;
				case 6:
					System.out.println("Enter name: "); 
			        String nameS2 = myScanner.next(); 
			        System.out.println("Enter index number: "); 
			        int indexN2 = myScanner.nextInt();
					Student s2 = new Student(nameS2, indexN2);
					System.out.println(M.contains(s2)? "True" : "False");
					break;
				case 7:
					System.out.print("Enter index: ");
					int getindex = myScanner.nextInt();
					Student s3 = M.get(getindex);
					System.out.println(s3.toString());
					break;
				case 8:
					Student zak3 = test.gimmieStudent();
					System.out.print("Enter the index: ");
					int index2 = myScanner.nextInt();
					System.out.println("Old MyList: "+M.print());
					M.set(index2, zak3);
					System.out.println("New MyList: "+M.print());
					break;
				case 9:
					System.out.print("Enter the index: ");
					int index3 = myScanner.nextInt();
					System.out.println("Old MyList: "+M.print());
					M.remove(index3);
					System.out.println("New MyList: "+M.print());
					break;
					
				default:
					System.out.println("Wrong data: range from 0 to 9");
			}
			option = myScanner.nextInt();
		}
		myScanner.close();
	}

}


class Student{
	private String name;
	private int indexNumber;
	
	public Student(String name, int number) {
		this.name = name;
		this.indexNumber = number;
	}
	@Override
	public String toString() {
		return "[ "+this.name+","+this.indexNumber+" ]"; 
	}
	
	@Override
	public boolean equals(Object o) {
	    Student s = (Student) o;
	    return (this.name.equals(s.name) && this.indexNumber == s.indexNumber);
	}
	
}

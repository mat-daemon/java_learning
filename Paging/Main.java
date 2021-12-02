package Paging;

public class Main {
	
	public static void main(String[] args) {
		int memorySize = 100000;                 
		int PFMax = 100;
		int zone = 50;
		Process[] p1 = ProcessesGenerator.run(10000);
		Process[] p2 = p1.clone();
		Process[] p3 = p1.clone();
		Process[] p4 = p1.clone();
		
		
		System.out.println("Liczba b³êdów strony: ");
		System.out.print("Przydzia³ proporcjonalny: ");
		System.out.println(Proportional.run(p1, memorySize));
		System.out.print("Przydzia³ równy: ");
		System.out.println(Equal.run(p2, memorySize));
		System.out.print("Sterowanie czêstoœci¹ b³êdów strony: ");
		System.out.println(PFFrequency.run(p3, memorySize, PFMax));
		System.out.print("Model strefowy: ");
		System.out.println(LocalityModel.run(p4, memorySize, zone));
		
	}
}

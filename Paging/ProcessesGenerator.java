package Paging;

public class ProcessesGenerator {
	public static Process[] run(int n) {
		Process[] arr = new Process[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = new Process();
			
		}
		return arr;
	}
}

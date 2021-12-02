package Paging;

public class Equal {
	public static int run(Process[] P, int memorySize) {
		int pf = 0;
		int pages = memorySize/P.length;
		
		for(int i=0; i<P.length; i++) {
			pf += LRU.run(P[i].pages, pages);
		}
		
		return pf;
	}
}

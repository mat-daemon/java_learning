package Paging;

public class Proportional {
	public static int run(Process[] P, int memorySize) {
		int pf = 0;
		int totalProcessesSize = 0;
		
		for(int i=0; i<P.length; i++) totalProcessesSize += P[i].size;
		
		for(int i=0; i<P.length; i++) {
			int pages = ((P[i].size*memorySize/totalProcessesSize));
			pf += LRU.run(P[i].pages, pages);
		}
		
		return pf;
	}
}

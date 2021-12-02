package Paging;

import java.util.HashSet;

public class LocalityModel {
	
	public static int run(Process[] P, int memorySize, int zone) {
		int pf = 0;
		int pagesGiven = 0;
		int[] pagesGivenTab = new int[P.length];
		
		for(int i= 0; i<P.length; i++) {
			int pages = workingSet(P[i], zone);
			pagesGivenTab[i] = pages;
			pagesGiven += pages;
		}
		
		for(int i=0; i<P.length; i++) {
			int pagesForProcess = (int)((double)((double)pagesGivenTab[i]/(double)pagesGiven)*(double)memorySize);
			pf += LRU.run(P[i].pages, pagesForProcess);
		}
		
		return pf;
	}
	
	private static int workingSet(Process P, int zone) {
		int size = 0;
		if(P.pages.length <= zone) zone = P.pages.length;
		
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i=0; i<zone; i++) {
			h.add(P.pages[i]);
		}
		size = h.size();
			
		
		return size;
	}
	
}

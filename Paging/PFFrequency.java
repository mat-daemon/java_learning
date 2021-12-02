package Paging;

public class PFFrequency {
	
	public static int run(Process[] P, int memorySize, int PFMax) {
		int PF = 0;
		int fsize = memorySize/P.length;
		for(int i=0; i<P.length; i++) P[i].frames = fsize;
		
		int size = P.length;
		int freeFrames = memorySize - (fsize*P.length);
		
		while(size != 0) {
			
			int min = Integer.MAX_VALUE;
			int max = -1;
			int minI = 0;
			int maxI = 0;
			
			for(int i=0; i<P.length; i++) {
				
                if (P[i] != null && P[i].ptr < P[i].pages.length) {
                    if (size == 1) {
                        P[i].frames += freeFrames;
                        freeFrames = 0;
                    }
                    
                    
                    int pfsingle = P[i].LRU();
                    int pf = P[i].faults;
                    
                    if (pf > max) {
                        max = pf;
                        maxI = i;
                    }
                    if (pf < min) {
                        min = pf;
                        minI = i;
                    }
                    P[i].ptr++;
                    PF += pfsingle;
                } else if (P[i] != null) {

                    if (P[maxI] != null && maxI != i) {
                        P[maxI].frames = P[maxI].frames + P[i].frames;
                    } 
                    else {
                        freeFrames += P[i].frames;
                    }
                    P[i] = null;
                    size--;
                }

            }
            
            if (P[minI] != null && P[maxI] != null && P[minI].frames != 1 && max>PFMax ) {
                if (P[minI].frames > 3) {
                    P[minI].frames = P[minI].frames - 1;
                    P[maxI].frames = P[maxI].frames + 1 + freeFrames;
                    freeFrames = 0;
				
                }
			
            }
		
		
		}
		return PF;
	}
}

package Paging;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Process {
	int size;
	int[] pages;
	int ptr = 0;  												// for PFFrequency
	LinkedList<Integer> stack = new LinkedList<Integer>();		// for PFFrequency
	int frames;													// for PFFrequency
	int faults = 0;												// for PFFrequency
	int MAX_PAGES = 200;
	
	
	public Process() {
		
		int numberOfPages = (int)(Math.random()*(MAX_PAGES)) + 30; 
		pages = new int[numberOfPages];
		pages[0] = (int)(Math.random()*numberOfPages);
		
		Random rand = new Random();
		for(int i=1; i<numberOfPages; i++) {
			int odw = pages[i-1]-20+rand.nextInt(1+20*2);
			pages[i] = Math.max(0, Math.min(numberOfPages-1, odw));
		}
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i=0; i<pages.length; i++) {
			h.add(pages[i]);
		}
		size = h.size();
	}
	
	public int LRU() {
		int pFaults = 0;
		
		int p = pages[ptr];
		ptr++;
		
		if(!stack.contains(p)) {
			pFaults++;
			
			if(stack.size() < frames) stack.push(p);
			else {
				stack.removeLast();
				stack.push(p);
			}
		}
		else{
			stack.remove((Integer)p);
			stack.push(p);
		}	
		
		faults += pFaults;
		return pFaults;
	}
}

package Paging;

import java.util.LinkedList;


public class LRU {
	public static int run(int[] arr, int pagesInMemory) {
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int pFaults = 0;
		
		
		for(int i=0; i<arr.length; i++) {
			
			if(!stack.contains(arr[i])) {
				pFaults++;
				
				if(stack.size() < pagesInMemory) stack.push(arr[i]);

				else {
					stack.removeLast();
					stack.push(arr[i]);
				}
			}
			else{
				stack.remove((Integer)arr[i]);
				stack.push(arr[i]);
			}
		}
		return pFaults;
	}

}

package Algorithms;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class BucketSort {
	
	public static void sort(List<Integer> list) {			//metoda dla list
		Integer[] a = list.toArray(new Integer[list.size()]);
		BucketSort.sort(a);
		
		ListIterator<Integer> it = list.listIterator();								
        for (int j=0; j<a.length; j++) {
            it.next();
            it.set(a[j]);
        }
	}
	
	public static void sort(Integer[] tab) {				//metoda dla tablic
		bsort(tab);
	}
	 
	private static void bsort(Integer[] tab) {
		int size = tab.length;
		int bsize = (int)Math.sqrt(size);
		int maxvalue = Integer.MIN_VALUE;
		
		for(int i=0; i<size; i++) {
			if(tab[i] > maxvalue) maxvalue = tab[i];
		}
		maxvalue++;
		
		PriorityQueue<Integer>[] buckets = new PriorityQueue[bsize];
		
		for(int i=0; i<bsize; i++) {
			buckets[i] = new PriorityQueue<Integer>();
		}
		
		for(int i=0; i<size; i++) {
			buckets[(int)((tab[i]/maxvalue)*bsize)].add(tab[i]);
		}
		
		int i=0;
		for(int j=0; j<bsize; j++) {
			while(buckets[j].size() > 0) {
				tab[i] = buckets[j].poll();
				i++;
			}
		}
		
	}
}

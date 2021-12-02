package Algorithms;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		
		int size = 1000;
		int range = 1000;
		
		Integer[] t1 = new Integer[size];
		Integer[] t2 = new Integer[size];
		Integer[] t3 = new Integer[size];
		
		for(int i=0; i<size; i++) {
			t1[i] = (int)(Math.random()*(range));
		}
		
		System.arraycopy(t1, 0, t2, 0, t1.length);
		System.arraycopy(t1, 0, t3, 0, t1.length);
		
		List<Integer> l1 = Arrays.asList(t1);
		List<Integer> l2 = Arrays.asList(t1);
		List<Integer> l3 = Arrays.asList(t1);
		
		
		System.out.println("Random values, Arrays");
		
		long start = System.nanoTime(); 
		QuickSort.sort(t1);
		long elapsedTime1 = System.nanoTime() - start;
		System.out.println("Elapsed time QuickSort(median of medians): " + elapsedTime1);
		
		start = System.nanoTime(); 
		BucketSort.sort(t2);
		long elapsedTime2 = System.nanoTime() - start;
		System.out.println("Elapsed time BucketSort: " + elapsedTime2);
		
		start = System.nanoTime(); 
		Arrays.sort(t3);
		long elapsedTime3 = System.nanoTime() - start;
		System.out.println("Elapsed time Arrays.sort: " + elapsedTime3);
		
		
			
		
		System.out.println("\nRandom values, lists");
		
		start = System.nanoTime(); 
		QuickSort.sort(l1);
		long elapsedTime4 = System.nanoTime() - start;
		System.out.println("Elapsed time QuickSort(median of medians): " + elapsedTime4);
		
		start = System.nanoTime(); 
		BucketSort.sort(l2);
		long elapsedTime5 = System.nanoTime() - start;
		System.out.println("Elapsed time BucketSort: " + elapsedTime5);
		
		start = System.nanoTime(); 
		Collections.sort(l3);
		long elapsedTime6 = System.nanoTime() - start;
		System.out.println("Elapsed time Collections.sort: " + elapsedTime6);
		
	}

}

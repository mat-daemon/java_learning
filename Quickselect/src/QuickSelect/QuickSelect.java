package QuickSelect;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.IllegalArgumentException;

public class QuickSelect<T extends Comparable<T>> {
	
	int n = 0;
	private int partition(ArrayList<T> A, int l, int r) {             //similar to partition in QuickSort
		T x = A.get(r);
		int i = l;
		
		for(int j=l; j<r; j++) {
			if(A.get(j).compareTo(x) < 0) {
				T tmp = A.get(i);
				A.set(i, A.get(j));
				A.set(j, tmp);
				i++;
			}
			n++;
		}
		T tmp = A.get(i);
		A.set(i, x);
		A.set(r, tmp);
		n++;
		return i;
	}
	
	private T selectKthElement(ArrayList<T> A, int l, int r, int k) {
		
		if(l == r) return A.get(l);
	
		int pivot = this.partition(A, l, r);
		if(pivot == k-1) return A.get(pivot);
		
		if(k-1 < pivot) 	return this.selectKthElement(A, l, pivot-1, k);
		else 	return this.selectKthElement(A, pivot+1, r, k);
	}
	
	public T select(ArrayList<T> A, int k) throws IllegalArgumentException{
		if(k <=0 || k>A.size()) throw new IllegalArgumentException("k out of bounds");
		
		int l = 0;
		int r = A.size() - 1;
		return this.selectKthElement(A, l, r, k);
	}
	
}

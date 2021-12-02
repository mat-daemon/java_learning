package Algorithms;
import java.util.List;
import java.util.ListIterator;

public class QuickSort {
	
	public static <T extends Comparable<T>> void sort(List<T> list) {			//metoda dla list
		Object[] a = list.toArray();
		QuickSort.sort(a);
		
		ListIterator<T> it = list.listIterator();								
        for (int j=0; j<a.length; j++) {
            it.next();
            it.set((T)a[j]);
        }
	}
	
	public static <T extends Comparable<T>> void sort(T[] tab) {				//metoda dla tablic
		qsort(tab, 0, tab.length-1);
	}
	 
	
	
	private static void sort(Object[] tab) {									
		qsort(tab, 0, tab.length-1);
	}
	
	
	
	private static void qsort(Object[] tab, int s, int e) {
		if((e-s)>0) {
			Object med = median(tab, s, e, (e-s+1)/2);
			int pivot = partition(tab, s, e, med);
			qsort(tab, s, pivot-1);
			qsort(tab, pivot+1, e);
		}
	}
	
	private static <T extends Comparable<T>> int partition(Object[] tab, int s, int e, Object med) {
		int i;
	    for (i=s; i<e; i++)
	        if (tab[i].equals(med))
	           break;
	    QuickSort.swap(tab, i, e);
	    
	    i=s;
	    for (int j = s; j <= e - 1; j++)
	    {
	        if (((T)tab[j]).compareTo((T)med) < 0)
	        {
	        	QuickSort.swap(tab, i, j);
	            i++;
	        }
	    }
	    QuickSort.swap(tab, i, e);
	    return i;
		
	}
	
	private static void swap(Object[] tab, int i, int j) {
		Object tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}
	
	private static Object median(Object[] tab, int s, int e, int k) {
		
	        int n = e-s+1; 
	 
	        int i;
	        Object[] median = new Object[(n+4)/5]; 
	        
	        for (i=0; i<n/5; i++) median[i] = median5(tab, s+i*5, 5);
	        
	        if (i*5 < n) 
	        {
	            median[i] = median5(tab, s+i*5, n%5);
	            i++;
	        }
	 
	        Object medOfMed = (i == 1)? median[i-1] : median(median, 0, i-1, i/2);
	 
	    
	        int pos = partition(tab, s, e, medOfMed);
	        
	        return tab[pos];
	        /*if (pos-s == k-1)
	            return tab[pos];
	        if (pos-s > k-1)  
	            return median(tab, s, pos-1, k);
	 
	        return median(tab, pos+1, e, k-pos+s-1);*/
	    
	 
	    
		
	}
	
	private static <T extends Comparable<T>> Object median5(Object arr[], int s, int n)			//sortowanie 5 (lub mniej) - elementowych podzbiorow
	{																							//insertion sortem i wybor mediany 
		int i,j;
	    for (i=s+1; i < s+n; i++)
	    {
	        Object key = arr[i];
	        j = i - 1;
	 
	        while (j >= s && ((T)arr[j]).compareTo((T)key)>0)
	        {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	    return arr[n/2];
	}
	
}

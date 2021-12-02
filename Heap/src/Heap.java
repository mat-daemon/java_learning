
public class Heap {

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public void sink(int[] heap,int idx, int n){
		int idxOfBigger=2*idx+1;
		if(idxOfBigger<n){
			if(idxOfBigger+1<n && heap[idxOfBigger] < heap[idxOfBigger+1])
				idxOfBigger++;
			if(heap[idx] < heap[idxOfBigger]){
				swap(heap,idx,idxOfBigger);
				sink(heap,idxOfBigger,n);
			}
		}
	}
	
	void heapAdjustment(int[] heap,int n) {
		
		for(int i=(n-1)/2;i>=0;i--)
		sink(heap, i, n);
	}
		
	public static void main(String[] args) {
		Heap h = new Heap();
		int[] arr = {5, 3, 2, 7, 4, 7, 6};
		h.heapAdjustment(arr, arr.length);
		for(int i=0; i<arr.length; i++)
			System.out.println(" " + arr[i]);

	}

}




/*
 	if(e != null){
 		System.out.println(e.value + " ");
 		if(e->next != null) showOddRec(e->next->next);
 	}
 */ 
/*
  	addRec(int el, int x){
  		if(head == null){
  			Element e = new Element();
  			e.value = x;
  			e.next = null;
  			head = e;
  		}
  		else if(el->next == null){
  			Element e = new Element();
  			e.value = x;
  			e.next = null;
  			el->next = e;
  		}
  		else{
  			addRec(el->next, x);
  		}
  		return head;
  	}
 */
 


package MyList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class MyList<T> implements Iterable<T> { // Implementacja Iterable<T>
	
	private Object[] elementData;
	private int size;          					//size of an elementData array
	private int changes = 0;					//for fail-fast behavior
	
	public MyList() {
		this(10);
	}
	public MyList(int capacity) {
		if(capacity <=0) {
			throw new IllegalArgumentException("Incorrect capacity");
		}
		this.elementData = new Object[capacity];
		this.size = 0;
	}
	public MyList(Collection<? extends T> c) {
		this.elementData = c.toArray();
		this.size = elementData.length;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() { // Anonimowa klasa
			private boolean canRemoveBeCalled=false;
			private int currentIndex=0;
			private int lastReturned = - 1;
			private int changesLimit = MyList.this.changes;
			
			@Override
			public boolean hasNext() {
				
				return currentIndex < size; 
			}
			@Override
			public T next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				else {
					checkChanges();
					lastReturned = currentIndex;
					currentIndex++;
					canRemoveBeCalled = true;
					return (T) elementData[lastReturned];
				}
			}
			@Override
			public void remove(){
				if(canRemoveBeCalled) {
					checkChanges();
					MyList.this.remove(lastReturned);
					currentIndex = lastReturned;
					lastReturned = -1;
					canRemoveBeCalled = false;
				} else throw new IllegalStateException();
				
			}
			public void checkChanges() {
				if(MyList.this.changes != changesLimit) {
					throw new ConcurrentModificationException();
				}
			}
			
			
		};
	}
	
	public int size() {
		return this.size;
	}
	
	public void rangeCheck(int index) {
		if(index<0 || index>=size) throw new IndexOutOfBoundsException();
	}
	
	public void ensureCapacity(int minCapacity) {
		int capacity = elementData.length;
		if(minCapacity <= capacity) return;
		while(minCapacity > capacity) {										
			capacity = (3*capacity)/2+1;
		}
		elementData = Arrays.copyOf(elementData, capacity);
		changes++;
	}
	
	public void add(int index, T element) {
		rangeCheck(index);
		ensureCapacity(size+1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = element;
		size++;
		changes++;
	}
	
	public void add(T e) {
		ensureCapacity(size+1);
		elementData[size++] = e;
		changes++;
	}
	
	public void clear() {
		for(int i =0; i<size; i++) elementData[i] = null;
		elementData = new Object[10];
		size = 0;
		changes++;
	}
	
	public int indexOf(T o) {
		for(int i=0; i<size; i++) {
			if(o.equals(elementData[i])) return i;
		}
		return -1;
	}
	public boolean contains(T o) {
		return indexOf(o) >= 0;
	}
	
	public T get(int index) {
		rangeCheck(index);
		return (T)elementData[index];
	}
	
	public T set(int index, T element) {
		rangeCheck(index);
		T obj = (T)elementData[index];
		elementData[index] = element;
		return obj;
	}
	
	public T remove(int index) {
		rangeCheck(index);
		int numberToMove = MyList.this.size - index - 1;
		T obj = (T)elementData[index];
		System.arraycopy(elementData, index+1, elementData, index, numberToMove);
		elementData[--size] = null;
		changes++;
		return obj;
	}
	
	public String print() {												//metoda dodatkowa, ale wykorzystuje iterator
		Iterator<T> itr = iterator();
		String printout = "[ ";
		while(itr.hasNext()) {
			printout += itr.next().toString();
		}
		printout += " ]";
		return printout;
		
	}
	
}
package aisd.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ExtendedOneWayLinkedListWithHead <T> extends AbstractList<T> implements Iterable<T> {
	private OneWayLinkedListWithHead<T> innerList = new OneWayLinkedListWithHead<>(); // kompozycja
	
	@Override
	public ListIterator<T> listIterator() {
		return new ListIterator<T>() {
			int cursor = -1;
			boolean canBeRemovedOrSet = false;
			Iterator<T> it = iterator();
			T lastReturned = null;
			int lastReturnedIndex = -1;
			T actEl = null;
			
			@Override
			public T next(){
				if(it.hasNext()) {
					cursor++;
					canBeRemovedOrSet = true;
					actEl = it.next();
					lastReturned = actEl;
					lastReturnedIndex = cursor;
					return lastReturned;
				}
				else throw new NoSuchElementException();
			}
			
			@Override
			public boolean hasNext() {
				return it.hasNext();
			}
			
			@Override
			public boolean hasPrevious() {
				return cursor>=0;
			}
			
			@Override
			public T previous() {
				if(this.hasPrevious()) {
					canBeRemovedOrSet = true;
					lastReturned = actEl;
					lastReturnedIndex = cursor;
					actEl = setIterator(cursor--);
					return lastReturned;
				}
				else throw new NoSuchElementException();
			}
			
			@Override
			public void add(T e) {
				ExtendedOneWayLinkedListWithHead.this.add(++cursor, e);
				canBeRemovedOrSet = false;
				actEl = e;
				setIterator(cursor+1);
				
			}
			
			@Override
			public int nextIndex() {
				return cursor+1;
			}
			
			@Override
			public int previousIndex() {
				return cursor;
			}
			
			@Override
			public void remove() {
				if(canBeRemovedOrSet) {
					canBeRemovedOrSet = false;
					ExtendedOneWayLinkedListWithHead.this.remove(lastReturnedIndex);
					cursor = lastReturnedIndex-1;
					lastReturned = null;
					actEl = setIterator(cursor+1);
				}
				else throw new IllegalStateException();
			}
			
			@Override
			public void set(T e) {
				if(canBeRemovedOrSet) {
					canBeRemovedOrSet = false;
					ExtendedOneWayLinkedListWithHead.this.set(lastReturnedIndex, e);
					lastReturned = null;
					actEl = e;
				}
				else throw new IllegalStateException();
			}
			
			private T setIterator(int index) {
				it = iterator();
				T e = null;
				for(int i=0; i<index; i++) {
					e = it.next();
				}
				return e;
			}
			
			
		};
	}
	

	@Override
	 public boolean add(T value) {
		return innerList.add(value);
	 }

	@Override
	public boolean add(int index, T value) {
		return innerList.add(index, value);
	}
	
	@Override
	public void clear() {
		innerList.clear();
	}
	
	@Override
	public boolean contains(T value) {
		return innerList.contains(value);
	}
	@Override
	public T get(int index) {
		return innerList.get(index);
	}
	
	@Override
	public T set(int index, T value) {
		return innerList.set(index, value);
	}
	
	@Override
	public int indexOf(T value) {
		return innerList.indexOf(value);
	}
	
	@Override
	public boolean isEmpty() {
		return innerList.isEmpty();
	}
	
	@Override
	public Iterator<T>	iterator(){
		return innerList.iterator();
	}
	
	@Override
	public T remove(int index) {
		return innerList.remove(index);
	}
	
	@Override
	public boolean	remove(T value) {
		return innerList.remove(value);
	}
	
	@Override
	public int size() {
		return innerList.size();
	}
	
}

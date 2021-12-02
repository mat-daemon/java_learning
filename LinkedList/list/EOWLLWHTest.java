package aisd.list;

//jUnit 5.3

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EOWLLWHTest {
	private ExtendedOneWayLinkedListWithHead<Integer> l;

	@BeforeEach
	void setUp() {
		l = new ExtendedOneWayLinkedListWithHead<>();
		l.add(1);
		l.add(2);
		l.add(3);
	}



	@Test
	void testRemoveMiddle() {
		ListIterator<Integer> it = l.listIterator();
		int x;
		
		it.next();											//usuwanie elementu, sprawdzenie metod previous i next
		it.next();											//po usunięciu elementu
		it.remove();
		x = it.previous();
		assertEquals(1, x);
		x = it.next();
		assertEquals(1, x);
		x = it.next();
		assertEquals(3, x);
		
	}
	@Test
	void testRemoveEdge() {
		ListIterator<Integer> it = l.listIterator();
		int x;
		
		it.next();											//usuwanie elementu, sprawdzenie metod previous i next
		it.next();											//po usunięciu elementu przypadek brzegowy
		it.next();											
		it.remove();
		x = it.previous();
		assertEquals(2, x);
		x = it.next();
		assertThrows(NoSuchElementException.class, it::next);
	}
	
	@Test
	void testAdd() {
		ListIterator<Integer> it = l.listIterator();
		int x;
		
		it.next();											
		it.next();
		it.add(4);
		assertIterableEquals(Arrays.asList(1,2,4,3), l);
		x = it.next();
		assertEquals(3, x);									//sprawdzanie spojnosci metod previous i next
		x = it.previous();									//po dodaniu elementu
		assertEquals(3, x);
		x = it.previous();
		assertEquals(4, x);
		x = it.previous();
		assertEquals(2, x);
	}
	
	@Test
	void testIndices() {
		ListIterator<Integer> it = l.listIterator();
		ArrayList<Integer> indices = new ArrayList<>();
		
		indices.add(it.nextIndex());
		it.next();
		indices.add(it.nextIndex());
		it.next();
		indices.add(it.nextIndex());
		it.add(4);
		indices.add(it.nextIndex());
		assertIterableEquals(Arrays.asList(0,1,2,3), indices);
		
	}
	
	@Test
	void testIterator() {
		ListIterator<Integer> it = l.listIterator();
		ArrayList<Integer> t = new ArrayList<>();
		
		while(it.hasNext()) {
			t.add(it.next());
			t.add(it.previous());
			it.next();
		}
		Integer[] test = {1,1,2,2,3,3};
		Integer[] result = new Integer[t.size()]; 
	    result = t.toArray(result);
		Assert.assertArrayEquals( test,  result);
	}
	
	@Test
	void testCrossingOver() {
		ListIterator<Integer> it = l.listIterator();
		ArrayList<Integer> t = new ArrayList<>();
		
		while(it.hasNext()) {
			t.add(it.next());
		}
		while(it.hasPrevious()) {
			t.add(it.previous());
		}
		Integer[] test = {1,2,3,3,2,1};
		Integer[] result = new Integer[t.size()]; 
	    result = t.toArray(result);
		Assert.assertArrayEquals( test,  result);
	}
	
	@Test
	void testSet() {
		ListIterator<Integer> it = l.listIterator();
		int x;
		it.next();
		it.next();
		it.set(4);
		x = it.previous();
		assertEquals(4, x);
		x = it.next();
		assertEquals(4, x);
		x = it.next();
		assertEquals(3, x);
	}
	
}
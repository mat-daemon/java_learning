package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Algorithms.QuickSort;

import java.util.Arrays;
import java.util.List;

class QuickSortTest {
	
	public Integer[] tab;
	public List<Integer> l;
	
	@BeforeEach
	void setUp() throws Exception {
		tab = new Integer[6];
		tab[0] = 5;
		tab[1] = 7;
		tab[2] = 3;
		tab[3] = 9;
		tab[4] = 8;
		tab[5] = 2;
		
		l = Arrays.asList(tab);
		
	}


	@Test
	void testArraySorting() {
		QuickSort.sort(tab);
		assertEquals(5, tab[2]);
		assertEquals(2, tab[0]);
		assertEquals(9, tab[5]);
		
	}
	
	@Test
	void testListSorting() {
		QuickSort.sort(l);
		assertEquals(5, l.get(2));
		assertEquals(2, l.get(0));
		assertEquals(9, l.get(5));
	}

}

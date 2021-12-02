package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import QuickSelect.QuickSelect;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSelectTest {
	ArrayList<Integer> A;
	QuickSelect<Integer> QS;
	
	@BeforeEach
	void setUp() throws Exception {
		int[] arr = {5,3,9,6,1,2,8,4,5};
		A = new ArrayList<Integer>(Arrays.asList(6,5,2,1,9,5,3,6,4534,56));
		QS = new QuickSelect<Integer>();
	}


	@Test
	void testQS1() {
		assertEquals(3, QS.select(A, 3));
	}
	@Test
	void testQS2() {
		assertEquals(6, QS.select(A, 7));
	}
	@Test
	void testQS3() {
		assertEquals(9, QS.select(A, 8));
	}
	@Test
	void testQS4() {
		assertEquals(56, QS.select(A, 9));
	}
	@Test
	void testQS5() {
		assertEquals(1, QS.select(A, 1));	
	}
	@Test
	void testQS6() {
		assertEquals(4534, QS.select(A, 10));	
	}
	@Test
	void testExceptions1() {
		assertThrows(IllegalArgumentException.class, ()->QS.select(A,11));	
	}
	@Test
	void testExceptions2() {
		assertThrows(IllegalArgumentException.class, ()->QS.select(A,0));	
	}

}

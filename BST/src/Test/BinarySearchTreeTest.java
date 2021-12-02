package Test;
import BinarySearchTree.*;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
	BinarySearchTree<Integer> t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new BinarySearchTree<Integer>();
	}

	@Test
	void testInsert() {
		
		assertEquals(false, t.insert(2));
		assertEquals(true, t.insert(2));
		assertEquals(false, t.insert(5));
		assertEquals(true, t.insert(5));
		assertEquals(true, t.insert(2));
	}
	
	@Test
	void testDelete() {
		
		assertEquals(false, t.insert(2));
		assertEquals(true, t.insert(2));
		t.delete(2);
		assertEquals(false, t.insert(2));
		
	}
	
	@Test
	void testUpper() {
		
		t.insert(10);
		t.insert(6);
		t.insert(5);											//					10
		t.insert(9);											//                 / \
		t.insert(16);											//                6   16
		t.insert(13);											//               /\   /\
		t.insert(18);											//              5  9  13 18
		
		assertEquals(5, t.upper(3));
		assertEquals(5, t.upper(5));
		assertEquals(16, t.upper(16));
		assertEquals(9, t.upper(9));
		assertEquals(9, t.upper(7));
		assertEquals(18, t.upper(17));
		assertThrows(NoSuchElementException.class, ()->t.upper(19));
	}
	
	@Test
	void testLower() {
		
		t.insert(10);
		t.insert(6);
		t.insert(5);											
		t.insert(9);											
		t.insert(16);											
		t.insert(13);											
		t.insert(18);											
		
		assertEquals(5, t.lower(5));
		assertEquals(16, t.lower(16));
		assertEquals(9, t.lower(9));
		assertEquals(6, t.lower(7));
		assertEquals(16, t.lower(17));
		assertThrows(NoSuchElementException.class, ()->t.lower(4));
	}
	
	@Test
	void testpreOrder() {
		t.insert(10);
		t.insert(6);
		t.insert(5);											
		t.insert(9);											
		t.insert(16);											
		t.insert(13);											
		t.insert(18);	
		t.TreeWalk(1);
		System.out.println("");
	}
	
	@Test
	void testinOrder() {
		t.insert(10);
		t.insert(6);
		t.insert(5);											
		t.insert(9);											
		t.insert(16);											
		t.insert(13);											
		t.insert(18);	
		t.TreeWalk(2);
		System.out.println("");
	}
	@Test
	void testpostOrder() {
		t.insert(10);
		t.insert(6);
		t.insert(5);											
		t.insert(9);											
		t.insert(16);											
		t.insert(13);											
		t.insert(18);	
		t.TreeWalk(3);
		System.out.println("");
	}
	
	

}

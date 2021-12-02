package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import MyStack.*;

class JUnitTest_VTStack {

	VTStack<Integer> s;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s = new VTStack<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void test_peek() {
		for(int i=1; i<=10; i++) s.push(i);
		try{
			s.down();
		}catch(BottomOfStackException e) {}
		int x = s.peek();
		assertEquals(9, x);
	}
	@Test
	void test_toTop() {
		for(int i=1; i<=10; i++) s.push(i);
		try{
			s.down();
		}catch(BottomOfStackException e) {}
		s.toTop();
		int x = s.peek();
		assertEquals(10, x);
		
	}
	@Test
	void test_down() {
		for(int i=1; i<=10; i++) s.push(i);
		try{
			s.down();
		}catch(BottomOfStackException e) {}
		int x = (int)s.peek();
		assertEquals(9, x);
		
	}
	
	@Test
	void test_push() {
		int x = s.push(1);
		assertEquals(1, x);
	}
	@Test
	void test_pop() {
		s.push(1);
		int x = s.pop();
		assertEquals(1, x);
	}

}

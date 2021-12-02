package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MyStack.*;

class JUnitTest_MyStack {
	
	MyStack<Integer> s;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s = new MyStack<Integer>(10);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void test_isEmpty() {
		assertEquals(true, s.isEmpty());
		try{
			s.push(1);
		}catch(FullStackException e) {}
		assertEquals(false, s.isEmpty());
	}
	@Test
	void test_isFull() {
		assertEquals(false, s.isFull());
		for(int i=1; i<=10; i++) {
			try{
				s.push(1);
			}catch(FullStackException e) {}
		}
		assertEquals(true, s.isFull());
	}
	@Test
	void test_pop() {
		int x=0;
		try{
			s.push(1);
		}catch(FullStackException e) {}
		try{
			x = (int)s.pop();
		}catch(EmptyStackException e) {}
		assertEquals(1, x);
	}
	
	@Test
	void test_size() {
		for(int i=1; i<=7; i++) {
			try{
				s.push(i);
			}catch(FullStackException e) {}
		}
		assertEquals(7, s.size());
	}
	@Test
	void test_top() {
		int x = 0;
		for(int i=1; i<=7; i++) {
			try{
				s.push(i);
			}catch(FullStackException e) {}
		}
		try{
			x = (int)s.top();
		}catch(EmptyStackException e) {}
		assertEquals(7, x);
	}

}

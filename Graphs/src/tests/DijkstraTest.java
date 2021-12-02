package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Dijkstra;
import graph.*;

class DijkstraTest {

	G g;
	
	@BeforeEach
	void setUp() throws Exception {
		g = new G<Integer>(8);					//GRAF Z WYK£ADU
		g.addEdge(0,1,4);
		g.addEdge(0,3,2);
		g.addEdge(0,4,3);
		g.addEdge(1,0,4);
		g.addEdge(1,2,2);
		g.addEdge(1,4,3);
		g.addEdge(1,5,8);
		g.addEdge(1,7,4);
		g.addEdge(2,1,2);
		g.addEdge(2,5,9);
		g.addEdge(3,0,2);
		g.addEdge(3,6,5);
		g.addEdge(4,0,3);
		g.addEdge(4,1,3);
		g.addEdge(4,6,5);
		g.addEdge(4,7,1);
		g.addEdge(5,1,8);
		g.addEdge(5,2,9);
		g.addEdge(5,7,7);
		g.addEdge(6,3,5);
		g.addEdge(6,4,5);
		g.addEdge(6,7,6);
		g.addEdge(7,1,4);
		g.addEdge(7,4,1);
		g.addEdge(7,5,7);
		g.addEdge(7,6,6);
	}
	@Test
	void test() {
		Dijkstra d = new Dijkstra(g);
		assertEquals(8, d.shortestPath(3, 2));
		assertEquals(13, d.shortestPath(3, 5));
		
	}

}

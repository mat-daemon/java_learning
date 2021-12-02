package algorithms;

import java.util.PriorityQueue;
import java.util.ArrayList;
import graph.*;

public class Dijkstra<T> {
	private PriorityQueue<Vertex<T>> p = new PriorityQueue<Vertex<T>>();
	private ArrayList<Vertex<T>> vertices;
	
	public Dijkstra(G<T> g) {
		vertices = g.getVertices();
	}
	
	public int shortestPath(int v1, int v2) {
		for(Vertex<T> v : vertices) {
			v.setDistance(Integer.MAX_VALUE);
			v.setVisited(false);
		}
		
		vertices.get(v1).setVisited(true);
		vertices.get(v1).setDistance(0);
			
		for(Edge e : vertices.get(v1).edges) {
			vertices.get(e.getV2()).setDistance(e.getWeight());
			p.add(vertices.get(e.getV2()));
		}
			
		while(!p.isEmpty()) {
			Vertex<T> v = p.poll();
			v.setVisited(true);
			
			for(Edge e : v.edges) {
				Vertex<T> vt = vertices.get(e.getV2());
				if(!vt.visited()) {
					p.remove(vt);
					if(vt.getDistance() > v.getDistance() + e.getWeight()) vt.setDistance(v.getDistance() + e.getWeight());
					p.add(vt);
				}
			}
		}
		return vertices.get(v2).getDistance();
	}
	
}

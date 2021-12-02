package graph;

import java.util.LinkedList;

public class Vertex<T> implements Comparable<Vertex<T>>{
	private int v;
	private T data;
	public LinkedList<Edge> edges;
	private int distance;
	private boolean visited;
	
	public Vertex(int v, T data) {
		this.v = v;
		this.data = data;
		edges = new LinkedList<Edge>();
	}
	
	public void setDistance(int d) {
		this.distance = d;
	}
	
	public void setVisited(boolean p) {
		visited = p;
	}
	
	public int getV() {
		return this.v;
	}
	
	public T getData() {
		return this.data;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public boolean visited() {
		return this.visited;
	}
	
	@Override
	public int compareTo(Vertex<T> v) {
		if(this.getDistance() < v.getDistance()) return -1;
		if(this.getDistance() == v.getDistance()) return 0;
		return 1;
	}
}

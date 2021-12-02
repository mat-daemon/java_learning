package graph;

import java.util.ArrayList;

public class G<T> {
	
	private ArrayList<Vertex<T>> vertices;
	private int s;
	
	public G(int size) {
		
		vertices = new ArrayList<Vertex<T>>(size);
		for(int i=0; i<size; i++) this.addVertex(null);
		this.s = size;
	}
	
	public void addVertex(T data) {
		
		Vertex<T> v = new Vertex<T>(vertices.size(), data);
		vertices.add(v);
		s++;
	}
	
	public void addEdge(int v1, int v2, int w) {
		if(v1>=vertices.size() || v2>=vertices.size()) return;
		
		for(Edge e : vertices.get(v1).edges) {
			if(e.getV2() == v2) {
				e.setWeight(w);
				return;
			}
		}
			
		Vertex<T> v = vertices.get(v1);
		Edge e = new Edge(v1, v2, w);
		v.edges.add(e);
	}
	
	public int getSize() {
		return this.s;
	}
	
	public ArrayList<Edge> getEdges() {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		boolean flag;
		
		for(Vertex<T> v : vertices) {
			for(Edge e1 : v.edges) {
				flag = false;
				
				for(Edge e2 : edges) {
					if(e2.merge(e1)) flag = true;
				}
				
				if(!flag) edges.add(e1);
			}
		}
		return edges;
	}
	
	public ArrayList<Vertex<T>> getVertices(){
		return this.vertices;
	}
	
	
}

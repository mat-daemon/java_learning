package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import graph.*;

public class Kruskal {
	private int[] p;
	private int[] rank;
	private int v;
	private G g;
	private ArrayList<Edge> A;
	
	public Kruskal(G g) {
		p = new int[g.getSize()];
		rank = new int[g.getSize()];
		v = g.getSize();
		A = new ArrayList<Edge>();
		this.g = g;
	}
	
	public ArrayList<Edge> run(){
		ArrayList<Edge> edges = g.getEdges();
		
		for(Edge e : edges) {
			if(!e.undirected()) return null;
		}
		
		Collections.sort(edges);
		
		for(int i=0; i<g.getSize(); i++) makeSet(i);
		
		for(Edge e : edges) {
			if(findSet(e.getV1()) != findSet(e.getV2()) ) {
				A.add(e);
				union(e.getV1(), e.getV2());
			}
		}
		return A;
	}
	
	
	
	
	
	
	
	private void makeSet(int x) {
		p[x] = x;
		rank[x] = 0;
	}
	
	private int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	private void Link(int x, int y) {
		if(rank[x] > rank[y]) p[y] = x;
		else {
			p[x] = y;
			if(rank[x] == rank[y]) rank[y]++;
		}
	}
	
	private void union(int x, int y) {
		this.Link(this.findSet(x), this.findSet(y));
	}
}

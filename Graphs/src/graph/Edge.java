package graph;

public class Edge implements Comparable<Edge>{
	private int v1;
	private int v2;
	private int weight;
	private boolean undirected;
	
	public Edge(int v1, int v2, int weight) { 
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
		this.undirected = false;
	}
	
	public void setWeight(int w) {
		weight = w;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getV1() {
		return this.v1;
	}
	
	public int getV2() {
		return this.v2;
	}
	
	public boolean undirected() {
		return this.undirected;
	}
	
	public boolean merge(Edge e) {
		if( ((v1 == e.getV1() && v2 == e.getV2()) || (v1 == e.getV2() && v2 == e.getV1()))  && weight == e.getWeight() ) {
			this.undirected = true;
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Edge e) {
		if(this.weight < e.getWeight()) return -1;
		if(this.weight == e.getWeight()) return 0;
		return 1;
	}
	
}

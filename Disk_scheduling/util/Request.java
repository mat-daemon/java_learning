package util;


public class Request implements Comparable<Request>{
	private int cylinder;
	private int headMovement;
	
	public Request(int cylinder) {
		this.cylinder = cylinder;
	}
	
	public void setheadMovement(int x) {
		headMovement = x;
	}
	
	public int getheadMovement() {
		return headMovement;
	}
	
	public int getCylinder() {
		return this.cylinder;
	}
	
	@Override
	public int compareTo(Request r) {
        return Integer.compare(getCylinder(), r.getCylinder());
    }
	
	public Request clone() {
		return new Request(this.cylinder);
	}
}

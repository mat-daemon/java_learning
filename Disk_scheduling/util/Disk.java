package util;

import java.util.ArrayList;

public class Disk {
	private int size;
	private DSAlgorithm Algorithm;
	private int diskHead;
	private ArrayList<Request> queue;
	private ArrayList<Request> result;
	private int seekTime = 0;
	
	public Disk(int size, DSAlgorithm a, int diskHead, ArrayList<Request> q){
		this.size = size;
		this.Algorithm = a;
		this.diskHead = diskHead;
		this.queue = q;
		
	}
	
	public ArrayList<Request> run() {
		result = Algorithm.run(size, diskHead, queue);
		for(Request r : result) seekTime += r.getheadMovement();
		return result;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getSeekTime() {
		return this.seekTime;
	}
	
}

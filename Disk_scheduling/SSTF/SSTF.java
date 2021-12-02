package SSTF;

import java.util.ArrayList;

import util.*;

public class SSTF implements DSAlgorithm{
	
	public ArrayList<Request> run(int size, int diskHead, ArrayList<Request> queue){
		int head = diskHead;
		ArrayList<Request> l = new ArrayList<Request>();
		
		while(!queue.isEmpty()) {
			int index = select(queue, head);
			Request r =queue.remove(index);
			r.setheadMovement(Math.abs(head-r.getCylinder()));
			head = r.getCylinder();
			l.add(r);
		}
		return l;
	}
	
	private int select(ArrayList<Request> queue, int head) {
		int distance = Integer.MAX_VALUE;
		int index = 0;
		for(int i=0; i<queue.size(); i++) {
			Request r = queue.get(i);
			if(Math.abs(head-r.getCylinder()) < distance){
				index =i;
				distance = Math.abs(head-r.getCylinder());
			}
		}
		return index;
	}
}

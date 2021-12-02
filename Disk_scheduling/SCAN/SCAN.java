package SCAN;

import java.util.ArrayList;
import java.util.Collections;

import util.*;

public class SCAN implements DSAlgorithm{
	
	@Override
	public ArrayList<Request> run(int size, int diskHead, ArrayList<Request> queue) {
		int head = diskHead;
		int index=0;
		ArrayList<Request> l = new ArrayList<Request>();
		
		Collections.sort(queue);
		while(index< queue.size() && queue.get(index).getCylinder() < head) index++;
		int pivot = index-1;
		while(index<queue.size()) {
			Request r = queue.get(index);
			r.setheadMovement(Math.abs(head-r.getCylinder()));
			l.add(r);
			head = r.getCylinder();
			index++;
		}
		while(pivot >= 0) {
			Request r = queue.get(pivot);
			r.setheadMovement(Math.abs(head-r.getCylinder()));
			l.add(r);
			head = r.getCylinder();
			pivot--;
		}
		return l;
	}
}

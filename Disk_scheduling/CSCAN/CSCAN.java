package CSCAN;

import java.util.ArrayList;
import java.util.Collections;

import util.*;

public class CSCAN implements DSAlgorithm{
	
	@Override
	public ArrayList<Request> run(int size, int diskHead, ArrayList<Request> queue) {
		int head = diskHead;
		int index;
		ArrayList<Request> l = new ArrayList<Request>();
		
		Collections.sort(queue);
		index=0;
		while(index< queue.size() && queue.get(index).getCylinder() < head) index++;
		int pivot = index-1;
		while(index<queue.size()) {
			Request r = queue.get(index);
			r.setheadMovement(Math.abs(head-r.getCylinder()));
			l.add(r);
			head = r.getCylinder();
			index++;
		}
		head = 0;
		index = 0;
		while(index <= pivot) {
			Request r = queue.get(index);
			r.setheadMovement(Math.abs(head-r.getCylinder()));
			l.add(r);
			head = r.getCylinder();
			index++;
		}
		return l;
	}
}

package FCFS;
import java.util.ArrayList;

import util.*;

public class FCFS implements DSAlgorithm{
	
	
	
	@Override
	public ArrayList<Request> run(int size, int diskHead, ArrayList<Request> queue) {
		int head = diskHead;
		for(int i=0; i<queue.size(); i++) {
			Request r = queue.get(i);
			r.setheadMovement(Math.abs(head-r.getCylinder()));
			head = r.getCylinder();
		}
		return queue;
	}
	
}

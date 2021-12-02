package util;

import java.util.ArrayList;
import java.util.Random;

public class RequestsGenerator {
	private ArrayList<Request> queue = new ArrayList<Request>();
	private ArrayList<Integer> cylinders = new ArrayList<Integer>();
	private int quantity;
	

	public RequestsGenerator(int quantity, int cylinders) {
		this.quantity = quantity;
		for(int i=0; i<cylinders; i++) this.cylinders.add(i);
	}
	
	public ArrayList<Request> run(){
		Random rand = new Random();
		for(int i=0; i<this.quantity; i++) {
			int index = rand.nextInt(cylinders.size());
			Request req = new Request(index);
			queue.add(req);
			cylinders.remove(index);
		}
		return queue;
	}
	
}

package SJF;

import java.util.ArrayList;
import java.util.LinkedList;
import util.process;
import java.util.ListIterator;

public class SJF_implementation {
	private ArrayList<process> queue;
	private LinkedList<process> ReadyQueue = new LinkedList<process>();
	private double averageWaitingTime;
	
	public SJF_implementation(ArrayList<process> queue) {
		this.queue = queue;
	}
	
	
	public void run() {
		int time = 0;
		int sumWaitingTimes = 0;
		
		int index = 0;
		int size = queue.size();
		
		addToReadyQueue(ReadyQueue, queue.get(0));
		time = queue.get(index).getarrivalTime();
		index++;
		while(index<queue.size() && queue.get(index).getarrivalTime() == time) {
			addToReadyQueue(ReadyQueue, queue.get(index));
			index++;
		}
		
		
		while(ReadyQueue.size() != 0) { 										
			process p = ReadyQueue.removeFirst();
			
			int pArrivalTime = p.getarrivalTime();							/*same as FCFS */
			int waitingTime;
			
			if(pArrivalTime >= time) {
				waitingTime=0;
				time = pArrivalTime;
			}
			else {
				waitingTime = time-pArrivalTime;
			}
			
			time += p.getburstTime();
			sumWaitingTimes += waitingTime;
			p.setwaitingTime(waitingTime);									/********************************/
			
			while(index<size && queue.get(index).getarrivalTime() <= time) {
				addToReadyQueue(ReadyQueue, queue.get(index));
				index++;
			}
			
			if(index<size && ReadyQueue.size()==0) {										//add new process if exists to ReadyQueue if empty
				ReadyQueue.add(queue.get(index));
				index++;
			}
		}
		
		
		this.averageWaitingTime = this.getaverageWaitingTime(sumWaitingTimes, (double)queue.size());
	}
	
	
	private void addToReadyQueue(LinkedList<process> ReadyQueue, process p) {
		if(ReadyQueue.size() == 0) ReadyQueue.addFirst(p);
		else {
			ListIterator<process> it = ReadyQueue.listIterator(0);
			boolean inserted = false;
			while(it.hasNext() && !inserted) {
				process p2 = it.next();
				if(p2.getburstTime() > p.getburstTime()) {
					it.previous();
					it.add(p);
					it.next();
					inserted = true;
				}
			}
			if(!inserted) {
				it.add(p);
			}
		}
	}
	
	
	public double getaverageWaitingTime(double sumWaitingTimes, double size) {
		return sumWaitingTimes/size;
	}
	
	public double getAverageWaitingTime() {
		return this.averageWaitingTime;
	}
	
	public String printProcessTable() {
		String table = "";
		
		
		for(process p : queue) {
			String process = p.getPID() + "   " + p.getarrivalTime() + "   " + p.getburstTime() + "   " + p.getwaitingTime() +"\n";
			table += process;
		}
		return table;
	}
}

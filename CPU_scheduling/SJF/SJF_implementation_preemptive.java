package SJF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import util.process;
import java.util.ListIterator;

public class SJF_implementation_preemptive {
	private ArrayList<process> queue;
	private LinkedList<process> ReadyQueue = new LinkedList<process>();
	private double averageWaitingTime;
	
	public SJF_implementation_preemptive(ArrayList<process> queue) {
		this.queue = queue;
	}
	
	
	public void run() {
		int time = 0;
		
		
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
			
			if(!p.getstarted()) {
				p.start();
				int pArrivalTime = p.getarrivalTime();							
				int waitingTime;
				
				if(pArrivalTime >= time) {
					waitingTime=0;
					time = pArrivalTime;
				}
				else {
					waitingTime = time-pArrivalTime;
				}
				p.setwaitingTime(waitingTime);
				p.setpreemptionTime(time+1);
			}
			else {
				p.setwaitingTime(p.getwaitingTime() + time - p.getpreemptionTime());
				p.setpreemptionTime(time+1);
				
			}
			
			
			time += 1;
			p.reduceRemainingTime();
			
			if(p.getremainingTime() > 0) addToReadyQueue(ReadyQueue, p);
			
			while(index<size && queue.get(index).getarrivalTime() <= time) {
				addToReadyQueue(ReadyQueue, queue.get(index));
				index++;
			}
			
			if(index<size && ReadyQueue.size()==0) {										//add new process if exists to ReadyQueue if empty
				ReadyQueue.add(queue.get(index));
				index++;
			}
		}
		
	}
	
	
	private void addToReadyQueue(LinkedList<process> ReadyQueue, process p) {
		if(ReadyQueue.size() == 0) ReadyQueue.addFirst(p);
		else {
			ListIterator<process> it = ReadyQueue.listIterator(0);
			boolean inserted = false;
			while(it.hasNext() && !inserted) {
				process p2 = it.next();
				if(p2.getremainingTime() > p.getremainingTime()) {									//change on remainingTime
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
	
	
	
	public double getAverageWaitingTime() {
		int awt = 0;
		Iterator<process> it = queue.iterator();
		while(it.hasNext()) {
			process p = it.next();
			awt += p.getwaitingTime();
		}
		this.averageWaitingTime = (double)awt/(double)queue.size();
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
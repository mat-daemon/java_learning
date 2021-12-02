package RoundRobin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import util.process;

public class RoundRobin_implementation {
	
	private ArrayList<process> queue;
	private LinkedList<process> ReadyQueue = new LinkedList<process>();
	private double averageWaitingTime;
	private int quantum;
	
	public RoundRobin_implementation(ArrayList<process> queue, int quantum) {
		this.queue = queue;
		this.quantum = quantum;
	}
	
	
	public void run() {
		int time = 0;
		int index = 0;
		int size = queue.size();
		
		ReadyQueue.add(queue.get(index));
		time = queue.get(index).getarrivalTime();
		index++;
		
		
		while(ReadyQueue.size() != 0) { 										
			process p = ReadyQueue.removeFirst();
			
			
			if(!p.getstarted()) {								//new process
				p.start();
				
				if(p.getarrivalTime() >= time) {
					p.setwaitingTime(0);
					time = p.getarrivalTime();
				}
				else p.setwaitingTime(time-p.getarrivalTime());	
			}
			
			else if(p.getpreemptionTime() < time){													//resume process	
					p.setwaitingTime(p.getwaitingTime() + time -p.getpreemptionTime());	
			}
			
			
			if(p.getremainingTime() <= quantum) {
				time += p.getremainingTime();
				p.reduceRemainingTimeQuant(p.getremainingTime());	
			}
			else {
				p.reduceRemainingTimeQuant(quantum);
				time += quantum;
				p.setpreemptionTime(time);
			}
			
			
			
			while(index<size && queue.get(index).getarrivalTime() <= time) {				//add new processes to ReadyQueue
				ReadyQueue.add(queue.get(index));
				index++;
			}
			
			if(p.getremainingTime() > 0) ReadyQueue.add(p);									//add process to the end of the ReadyQueue if not finished
			
			if(index<size && ReadyQueue.size()==0) {										//add new process if exists to ReadyQueue if empty
				ReadyQueue.add(queue.get(index));
				index++;
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

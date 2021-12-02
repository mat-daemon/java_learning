package FCFS;
import java.util.ArrayList;
import util.*;

public class FCFS_implementation {
	private ArrayList<process> queue;
	private double averageWaitingTime;
	
	public FCFS_implementation(ArrayList<process> queue) {
		this.queue = queue;
	}
	
	public void run() {
		int time = 0;
		int sumWaitingTimes = 0;
		
		for(process p : queue) {
			int pArrivalTime = p.getarrivalTime();
			int waitingTime;
			
			if(pArrivalTime > time) {
				waitingTime=0;
				time = pArrivalTime;
			}
			else {
				waitingTime = time-pArrivalTime;
			}
			
			time += p.getburstTime();
			sumWaitingTimes += waitingTime;
			p.setwaitingTime(waitingTime);
		}
		
		this.averageWaitingTime = this.getaverageWaitingTime(sumWaitingTimes, (double)queue.size());
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

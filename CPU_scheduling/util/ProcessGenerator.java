package util;

import java.util.ArrayList;
import java.lang.Math;

public class ProcessGenerator {
	private ArrayList<process> queue = new ArrayList<process>();
	private int quantity;
	private int time = 0;
	private int maxTimeInterval;
	private int nextPID = 0;
	private int maxBurstTime;
	
	public ProcessGenerator() {
		this(100, 3, 15);
	}
	public ProcessGenerator(int quantity, int maxTimeInterval, int maxBurstTime) {
		this.quantity = quantity;
		this.maxTimeInterval = maxTimeInterval;
		this.maxBurstTime = maxBurstTime;
	}
	
	public ArrayList<process> run(){
		for(int i=0; i<this.quantity; i++) {
			queue.add(generateProcess());
		}
		return queue;
	}
	
	public process generateProcess() {
		this.time += timeLapse(this.maxTimeInterval);
		return new process(nextPID++, this.time, this.burstTime(maxBurstTime));
	}
	
	private int timeLapse(int maxTimeInterval) {
		return (int)(Math.random()*maxTimeInterval);
	}
	
	private int burstTime(int maxBurstTime) {
		return (int)(Math.random()*maxBurstTime)+1;
	}
	
}

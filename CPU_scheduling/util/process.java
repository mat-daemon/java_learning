package util;

public class process {
	private int PID;
	private int arrivalTime;
	private int burstTime;
	private int waitingTime;
	private boolean started; 	//for SJF_preemptive and RR
	private int remainingTime;  //for SJF_preemptive and RR
	private int preemptionTime; //for SJF_preemptive and RR
	
	public process(int PID, int arrivalTime, int burstTime) {
		this.PID = PID;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.remainingTime = burstTime;
		this.waitingTime = 0;
		this.started = false;
	}
	
	public void setwaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	public void reduceRemainingTime() {
		this.remainingTime -=1;
	}
	
	public void reduceRemainingTimeQuant(int quant) {
		this.remainingTime -= quant;
	}
	
	public void setpreemptionTime(int time) {
		this.preemptionTime = time;
	}
	
	public void start() {
		this.started = true;
	}
	
	public int getPID() {
		return this.PID;
	}
	
	public int getarrivalTime() {
		return this.arrivalTime;
	}
	
	public int getburstTime() {
		return this.burstTime;
	}
	
	public int getwaitingTime() {
		return this.waitingTime;
	}
	
	public boolean getstarted() {
		return this.started;
	}
	
	public int getremainingTime() {
		return this.remainingTime;
	}
	
	public int getpreemptionTime() {
		return this.preemptionTime;
	}
	
	public process clone() {
		return new process(this.PID, this.arrivalTime, this.burstTime);
	}
	
}

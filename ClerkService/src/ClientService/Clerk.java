package ClientService;

public class Clerk {
	char id;
	boolean isFree;
	int timeToFinish;
	int servedCustomer;
	
	public Clerk(char id) {
		this.id = id;
		isFree = true;
		timeToFinish = 0;
		servedCustomer = -1;
	}
	
	public String serve(int customer, int time) {
		
		this.servedCustomer = customer;
		this.timeToFinish = time;
		this.isFree = false;
		return this.id + " start service " + "client " + customer;
	}
	
	public boolean updateTime(int time){
		if(this.isFree) return false;
		if(this.timeToFinish < time) return false;;
		this.timeToFinish -= time;
		if(this.timeToFinish == 0) return true;
		return false;
	}
	
	public String finishService() {
		
		String msg = this.id + " start service " + "client " + this.servedCustomer;
		this.isFree = true;
		this.servedCustomer = -1;
		return msg;
	}
	
}

package ClientService;

public class ServiceAlgorithm {
	IQueue<Client> Q;
	Clerk[] clerks;
	
	public ServiceAlgorithm(IQueue<Client> q, Clerk[] c){
		this.Q = q;
		this.clerks = c;
	}
	
	public void start() {
		while(!Q.isEmpty()) {
			try {
				Client c = Q.dequeue();
				boolean flag = false;
				int time = clerks[0].timeToFinish;
				int index = 0;
				int i = 0;
				while(i<clerks.length && !flag) {
					
					if(clerks[i].timeToFinish<time) {
						time = clerks[i].timeToFinish;
						index = i;
					}
					
					if(clerks[i].isFree) {
						
						System.out.println(clerks[i].serve(c.id,c.time));
						flag = true;
					}
				}
				if(!flag) {
					int token =1;
					for(int j=0; j<clerks.length; j++) {
						if(clerks[j].updateTime(time)) {
							System.out.println(clerks[j].finishService());
							if(token==1) {
								System.out.println(clerks[j].serve(c.id, c.time));
							}
						}
					}
					
				}
				
			}catch(EmptyQueueException e) {}
			
		}
		
	}
	
}

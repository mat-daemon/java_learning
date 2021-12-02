package Tester;

import java.util.ArrayList;

import FCFS.*;
import SJF.*;
import RoundRobin.*;
import util.*;

public class CPU_Scheduling_Test {

	public static void main(String[] args) {
		
		ProcessGenerator PG = new ProcessGenerator(3, 3, 5);
		ArrayList<process> ProcessQueue1 = PG.run();
		ArrayList<process> ProcessQueue2 = CPU_Scheduling_Test.cloneList(ProcessQueue1);
		ArrayList<process> ProcessQueue3 = CPU_Scheduling_Test.cloneList(ProcessQueue1);
		ArrayList<process> ProcessQueue4 = CPU_Scheduling_Test.cloneList(ProcessQueue1);
		
		FCFS_implementation algorithm1 = new FCFS_implementation(ProcessQueue1);
		SJF_implementation algorithm2 = new SJF_implementation(ProcessQueue2);
		SJF_implementation_preemptive algorithm3 = new SJF_implementation_preemptive(ProcessQueue3);
		RoundRobin_implementation algorithm4 = new RoundRobin_implementation(ProcessQueue4, 2);
		
		algorithm1.run();
		System.out.println("FCFS");
		System.out.println("Average waiting time: " + algorithm1.getAverageWaitingTime());
		System.out.println("Process Table: ");
		System.out.println(algorithm1.printProcessTable());
		
		algorithm2.run();
		System.out.println("SJF");
		System.out.println("Average waiting time: " + algorithm2.getAverageWaitingTime());
		System.out.println("Process Table: ");
		System.out.println(algorithm2.printProcessTable());
		
		algorithm3.run();
		System.out.println("SJF preemptive");
		System.out.println("Average waiting time: " + algorithm3.getAverageWaitingTime());
		System.out.println("Process Table: ");
		System.out.println(algorithm3.printProcessTable());
		
		algorithm4.run();
		System.out.println("Round Robin");
		System.out.println("Average waiting time: " + algorithm4.getAverageWaitingTime());
		System.out.println("Process Table: ");
		System.out.println(algorithm4.printProcessTable());
		

	}
	
	public static ArrayList<process> cloneList(ArrayList<process> list) {
	    ArrayList<process> clone = new ArrayList<process>(list.size());
	    for (process item : list) clone.add(item.clone());
	    return clone;
	}

}

package Tester;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import util.*;
import java.util.*;
import FCFS.*;
import SSTF.*;
import SCAN.*;
import CSCAN.*;


public class Test {
    public static void main(String[] a)
    {	
    	
    	int numberOfRequests = 20;		//wykresy dzialaja do 20
    	int diskSize = 200;
    	int diskHead = 50;
    	
    	RequestsGenerator rg = new RequestsGenerator(numberOfRequests, diskSize);
    	
    	ArrayList<Request> l1 = rg.run();												// 4 takie same listy wejsciowe zadan 
    	ArrayList<Request> l2 = Test.cloneList(l1);
    	ArrayList<Request> l3 = Test.cloneList(l1);
    	ArrayList<Request> l4 = Test.cloneList(l1);
    	
    	
        FCFS fcfs = new FCFS();															//4 algorytmy przydziału dysku
        SSTF sstf = new SSTF();
        SCAN scan = new SCAN();
        CSCAN cscan = new CSCAN();
        	
        
        Disk d1 = new Disk(diskSize, fcfs, diskHead, l1);								//4 instancje dyskow
        Disk d2 = new Disk(diskSize, sstf, diskHead, l2);
        Disk d3 = new Disk(diskSize, scan, diskHead, l3);
        Disk d4 = new Disk(diskSize, cscan, diskHead, l4);
    	
        
        ArrayList<Request> FCFSresult = d1.run();										
    	ArrayList<Request> SSTFresult = d2.run();
    	ArrayList<Request> SCANresult = d3.run();
    	ArrayList<Request> CSCANresult = d4.run();
    	
    	
    	System.out.println("FCFS\nSeek Time: " + d1.getSeekTime());
    	System.out.println("SSTF\nSeek Time: " + d2.getSeekTime());
    	System.out.println("SCAN\nSeek Time: " + d3.getSeekTime());
    	System.out.println("CSCAN\nSeek Time: " + d4.getSeekTime());
    	
    	// creating object of JFrame(Window popup)
        JFrame window = new JFrame();
        
        // setting closing operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        // setting size of the pop window
        window.setBounds(30, 30, 1000, 500);
  
        // setting canvas for draw
        MyCanvas m = new MyCanvas();
        m.setl(FCFSresult, SSTFresult, SCANresult, CSCANresult, diskHead);
        
        JScrollPane jp = new JScrollPane(m); //dodanie scrollbaru - wazny preferredsize w mycanvas (jcomponent)
        
        window.add(jp);
        
        // set visibility
        window.setVisible(true);
    }
    
    public static ArrayList<Request> cloneList(ArrayList<Request> list) {
	    ArrayList<Request> clone = new ArrayList<Request>(list.size());
	    for (Request item : list) clone.add(item.clone());
	    return clone;
	}
}





class MyCanvas extends JComponent {
	ArrayList<Request> l1;
	ArrayList<Request> l2;
	ArrayList<Request> l3;
	ArrayList<Request> l4;
	int diskHead;
	
	public void setl(ArrayList<Request> l1, ArrayList<Request> l2, ArrayList<Request> l3, ArrayList<Request> l4, int dh) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
		this.diskHead = dh;
	}
	
    public void paint(Graphics g)
    {
    	paintPartition(1, 0, 0, g, l1);
    	paintPartition(2, 500, 0, g, l2);
    	paintPartition(3, 0, 500, g, l3);
    	paintPartition(4, 500, 500, g, l4);
    	
    }
    
    public void paintPartition(int quadrant, int movex, int movey, Graphics g, ArrayList<Request> list) {
    	int height = 35+movey;
    	int lastx = diskHead*2+movex;
    	int lasty = 35+movey;
    	ArrayList<Request> l = list;
    	
    	switch(quadrant) {
    		case 1:
    			g.drawString("FCFS", 0, 10);
    			break;
    		case 2:
    			g.drawString("SSTF", 500, 10);
    			break;
    		case 3:
    			g.drawString("SCAN", 0, 510);
    			break;
    		case 4:
    			g.drawString("CSCAN", 500, 510);
    			break;
    	}
    	
    	g.drawLine(0+movex, 20+movey, 400+movex, 20+movey);
    	g.drawString("|", 400+movex, 20+movey);
    	
    	for(int i=0; i<400; i+=50) {										//os x
    		g.drawString("|", i+movex, 20+movey);
    		g.drawString(Integer.toString(i/2), i+movex, 30+movey);
        }
    	
        for(int i=0; i<l.size(); i++) {										//wykres
        	Request r = l.get(i);
        	g.drawString("\u25CF", r.getCylinder()*2+movex, height+5);
        	if(quadrant!=4 || lastx<=r.getCylinder()*2+movex) {
        		 g.drawLine(lastx, lasty, r.getCylinder()*2+movex, height);
        	}
            lastx = r.getCylinder()*2+movex;
            lasty = height;
            height += 20;
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
    	return new Dimension(1000,1000);
    }
}
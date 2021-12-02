package SJF;

import java.util.LinkedList;
import java.util.LinkedList;
import util.process;
import java.util.ListIterator;
import util.process;

public class main {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(10);
		l.add(20);
		l.add(30);
		ListIterator<Integer> it = l.listIterator(0);
		while(it.hasNext()) {
			/*Integer i = it.next();
			if(i>40) {
				it.previous();
				it.add(40);
				it.next();
			}*/
			it.next();
		}
		it.add(40);
		it = l.listIterator(0);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

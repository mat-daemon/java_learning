package MyStack;
import java.lang.Math.*;

public class MyStack<T> implements IStack<T>{
	private int size;
	private int head;
	private Object[] elements;
	
	public MyStack(int capacity) {
		this.elements = (T[])(new Object[capacity]);
		this.head = 0;
		this.size = 0;
	}
	@Override
	public boolean isEmpty(){
		return this.size==0;
	}
	@Override
	public boolean isFull() {
		 return this.size == elements.length;
	}
	@Override
	public T pop() throws EmptyStackException{
		 if(isEmpty()) throw new EmptyStackException();
		 T element = (T)elements[head];
		 head = Math.floorMod(head-1,elements.length);
		 size--;
		 return element;
	}
	@Override
	public void push(T elem) throws FullStackException{
		 head = (head+1)%elements.length;
		 elements[head] = elem;
		 if(size != elements.length) size++;
	}
	@Override
	public int size() {
		 return this.size;
	}
	@Override
	 public T top() throws EmptyStackException{
		 if(isEmpty()) throw new EmptyStackException();
		 return (T)elements[head];
	}
	public void print() {
		int tmp = head;
		int counter = size;
		System.out.print("[ ");
		while(counter != 0) {
			System.out.print("["+elements[tmp]+"] ");
			counter--;
			tmp = Math.floorMod(tmp-1,elements.length);
		}
		System.out.println("]");
	}
	
}

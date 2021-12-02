package CircullarBuffer;

public class CircullarBuffer {
	private int size;
	private int head;
	private int tail;
	private Object elements[];
	
	public CircullarBuffer(int capacity) {
		head = 0;
		tail = -1;
		size = 0;
		elements = new Object[capacity];
	}
	
	public void add(Object element) throws Exception{
		if(size == elements.length) throw new Exception("No stackoverflow but bufferoverflow");
		tail = (tail+1)%elements.length;
		size++;
		elements[tail] = element;
		
	}
	
	public Object get() throws Exception{
		if(size==0) throw new Exception("Empty buffer");
		Object element = elements[head];
		head = (head+1)%elements.length;
		size--;
		return element;
	}
	
	public String print() {
		int i = head;
		int j = tail;
		String buffer = "[ ";
		if(size > 0) {
			while(i != j) {
				String element = "[" + elements[i].toString() + "]"; 
				buffer += element;
				i = (i+1)%elements.length;			
			}
			String element = "[" + elements[i].toString() + "]";
			buffer += element;
		} 
		buffer += " ]";
		return buffer;
	}
	
	public static void main(String args[]) {
		CircullarBuffer B = new CircullarBuffer(10);
		for(int i=0; i<2; i++) {
			try{B.add(Integer.toString(i));
			}
			catch(Exception error){
				System.out.println("error");
			}
		}
		try{
			B.get();
		}catch(Exception error) {
			System.out.println(error.getMessage());
		}
		try{
			B.get();
		}catch(Exception error) {
			System.out.println(error.getMessage());
		}
		try{
			B.get();
		}catch(Exception error) {
			System.out.println(error.getMessage());
		}
		/*try{
			B.add("69");
		}catch(Exception error) {
			System.out.println("error");
		}*/
		System.out.println(B.print());
	}
}

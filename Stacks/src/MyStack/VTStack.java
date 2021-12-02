package MyStack;
import java.util.Stack;

public class VTStack<E> extends Stack<E>{
		private int cursor = -1;
	
		@Override
		public E peek(){
			if(cursor == -1) this.toTop();
			E element = (E)this.elementData[cursor];
			return element;
		}
		public void toTop() {
			this.cursor = this.elementCount-1;
		}
		public void down() throws BottomOfStackException{
			if(cursor == -1) throw new BottomOfStackException();
			cursor--;
		}
		@Override
		public E push(E item) {
			super.push(item);
			this.toTop();
			return item;
		}
		@Override
		public E pop() {
			E element = super.pop();
			this.toTop();
			return element;
		}
		
		
}

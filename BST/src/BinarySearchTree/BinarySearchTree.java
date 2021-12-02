package BinarySearchTree;
import java.lang.Comparable;
import java.util.NoSuchElementException;




public class BinarySearchTree<P extends Comparable<P>> {
	private node<P> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public boolean insert(P p) {
		node<P> y = null;
		node<P> x = this.root;
		
		while(x != null) {
			y = x;
			if(p.compareTo(x.getValue()) < 0) {
				x = x.getLeft();
			}
			else if(p.compareTo(x.getValue()) == 0) {
				return true;
			}
			else x = x.getRight();
		}
		node<P> n = new node<P>(p);
		if(y == null) this.root = n;
		else {
			n.setParent(y);
			if(p.compareTo(y.getValue()) < 0) y.setLeft(n);
			else y.setRight(n);	
		}
		return false;
	}
	
	
	public void delete(P p) {
		node<P> n = TreeFind(p);
		if(n != null) {
			node<P> y;
			node<P> x;
			if(n.getLeft() == null || n.getRight() == null) y = n;
			else y = TreeSuccessor(n);
			if(y.getLeft() != null) x = y.getLeft();
			else x = y.getRight();
			if(x != null) x.setParent(y.getParent());
			if(y.getParent() == null) this.root = x;
			else if(y == y.getParent().getLeft()) y.getParent().setLeft(x);
			else y.getParent().setRight(x);
			if(y != n) {
				n.changeValue(y.getValue());
			}
		}
	}
	
	public P upper(P p) {
		if(insert(p)) return p;
		node<P> n = TreeFind(p);
		node<P> n2 = TreeSuccessor(n);
		delete(p);
		if(n2 == null) throw new NoSuchElementException();
		return n2.getValue();
	}
	
	public P lower(P p) {
		if(insert(p)) return p;
		node<P> n = TreeFind(p);
		node<P> n2 = TreePredeccessor(n);
		delete(p);
		if(n2 == null) throw new NoSuchElementException();
		return n2.getValue();
	}
	
	
	public void TreeWalk(int option) {
		switch(option) {
		case 1:
			preOrder(this.root);
			break;
		case 3:
			postOrder(this.root);
			break;
		default:
			inOrder(this.root);
			break;
		}
	}
	
	private void preOrder(node<P> n) {
		if(n == null) return;
		System.out.print(n.getValue().toString()+" ");
		preOrder(n.getLeft());
		preOrder(n.getRight());
	}
	private void inOrder(node<P> n) {
		if(n == null) return;
		inOrder(n.getLeft());
		System.out.print(n.getValue().toString()+" ");
		inOrder(n.getRight());
	}
	private void postOrder(node<P> n) {
		if(n == null) return;
		postOrder(n.getLeft());
		postOrder(n.getRight());
		System.out.print(n.getValue().toString()+" ");
	}
	
	private node<P> TreeSuccessor(node<P> n) {
		node<P> x = n;
		if(x.getRight() != null) return TreeMinimum(x.getRight());
		node<P> y = x.getParent();
		
		while(y != null && y.getRight() == x) {
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	private node<P> TreePredeccessor(node<P> n) {
		node<P> x = n;
		if(x.getLeft() != null) return TreeMaximum(x.getLeft());
		node<P> y = x.getParent();
		
		while(y != null && y.getLeft() == x) {
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	private node<P> TreeMinimum(node<P> n) {
		node<P> x = n;
		while(x.getLeft() != null) x = x.getLeft();
		return x;
	}
	
	private node<P> TreeMaximum(node<P> n) {
		node<P> x = n;
		while(x.getRight() != null) x = x.getRight();
		return x;
	}
	
	private node<P> TreeFind(P p){
		node<P> x = this.root;
		while(x!=null && !x.getValue().equals(p)) {
			if(p.compareTo(x.getValue()) < 0) {
				x = x.getLeft();
			}
			else x = x.getRight();
		}
		return x;
	}
	
	private class node<P extends Comparable<P>>{
		P value;
		node<P> parent;
		node<P> left;
		node<P> right;
		
		public node(P p) {
			this.value = p;
			this.parent = null;
			this.left = null;
			this.right = null;	
		}
		
		public void setLeft(node<P> n) {
			this.left = n;
		}
		public void setRight(node<P> n) {
			this.right = n;
		}
		public void setParent(node<P> n) {
			this.parent = n;
		}
		public void changeValue(P p) {
			this.value = p;
		}
		
		
		public P getValue() {
			return this.value;
		}
		public node<P> getLeft() {
			return this.left;
		}
		public node<P> getRight() {
			return this.right;
		}
		public node<P> getParent() {
			return this.parent;
		}
		
	}
}

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
/* Priority Queue class creates a minimum queue used for A* algorithm and mapping*/

public class PriorityQueue extends ArrayList<Node> implements Serializable {
	
	private void shiftup(int index) {
		int k = index;
		while(k > 0) {
			int p = (k-1)/2;
			
			Node child = this.get(k);
			Node parent = this.get(p);
			
			if((child.f >= 0) && (child.f < parent.f)) {
				this.set(k, parent);
				this.set(p, child);
				
				k = p;
			} else {
				break;
			}
			
		}
	}
	 
	private void shiftdown(int index) {
		int k = index;
		int l = (2*k) + 1;
		int r = l+1;
		
		
		while(l < this.size()) {
			
			int less;
			if(r < this.size()) {
				
				if(this.get(l).f > this.get(r).f) {
					less = r;
				} else {
					less = l;
				}
				
			} else {
				less = l;
			}
			
			if(this.get(k).f > this.get(less).f && (this.get(less).f >= 0)) {
				Node temp = this.get(k);
				this.set(k, this.get(less));
				this.set(less, temp);
				k = less;
				l = (2*k)+1;
				r = l+1;
			} else {
				return;
			}
			
		}
		
		return;
	
	}
	
	public void shiftUpNode(int index) {
		shiftup(index);
	}
	
	public boolean add(Node e) {
		super.add(e);
		shiftup(this.size() - 1);
		return true;
	}
	
	public boolean offer(Node e) {
		return this.add(e);
	}
	
	public Node peek() {
		if(this.size() > 0) {
			return this.get(0);
		} else {
			return null;
		}
	}
	
	public Node poll() {
		if(this.size() <= 0) { return null; }
		
		Node item = this.get(0);
		
		this.set(0, this.get(this.size()-1));
		this.remove(this.size()-1);
		
		shiftdown(0);
		
		return item;
	}
	
	public boolean remove(String o) {
		int i = 0;
		while(i < this.size()) {
			if(this.get(i).point.getName().equals(o)) {
				this.set(i, this.get(this.size()-1));
				this.remove(this.size()-1);
				shiftdown(i);
				return true;
			}
			i++;
		}
		return false;
	}
	
	public String toString() {
		int i = 0;
		String s = "[";
		while(i < this.size()) {
			s = s + this.get(i).point.getName() + "--" + this.get(i).f + ", ";
			i++;
		}
		s = s + "]";
		return s;
	}
	

	
}





















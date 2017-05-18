

//Implementing a linked list
class LinkedList<T>{
	Node<T> head;
	
	public LinkedList(){
		head = null;
	}
	
	public void appendLast(T data){
		Node<T> last = new Node<T>(data);
		Node<T> current = this.head;
		if(current == null){
			head = last;
			return;
		}
		while(current.next!=null){
			current = current.next;
		}
		current.next=last;		
	}
	
	/** 
	 * The idea is to create a window of length k where
	 * right margin is pointed by current
	 * left margin is pointed by follower
	 * when current reaches end of linked linked, follower points to kth to last element
	 */
	public Node<T> kToLast(int k){
		if(k<0){
			System.err.println("k must be a non-negative number");
			return null;
		}
		
		Node<T> current = head;
		for(int i=0; i<k; i++){
			if(current==null){
				break; // this condition holds if k>=list.length+1
			}
			current = current.next;
		}
		if(current==null){
			return null; //this condition holds if k>=list.length 
		}
		
		Node<T> follower = head;
		while(current.next!=null){
			follower = follower.next;
			current = current.next;
		}
		return follower;
	}
	
	public void printList (){
		Node<T> current = this.head;
		while(current!=null){
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println("null");
	}
}

//Implementing a node
class Node<T>{
	T data;
	Node<T> next = null;
	
	public Node(){
		this.data = null;
	}
	
	public Node(T data){
		this.data = data;
	}
	
	void appendNext(Node<T> nextNode){
		this.next = nextNode;
	}
	
	T getData(){
		return this.data;
	}	
}
public class q2 {
	
	public static int kToLast(LinkedList<Integer> ll, int k){
		Node<Integer> k_node= ll.kToLast(k);
		if(k_node==null){
			System.err.println("\nk > length of linked list");
			System.exit(-1);
		}
		else{
			return k_node.data;
		}
		return -1;
		
	}

	public static void main(String[] args) {
		LinkedList<Integer> int_ll = new LinkedList<Integer>();
		for(int i=50; i<51; i++){
			int_ll.appendLast(i);
		}
		int_ll.printList();
		int k=1;
		
		System.out.println(kToLast(int_ll, k));

	}

}

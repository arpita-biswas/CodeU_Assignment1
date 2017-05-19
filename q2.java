//Implementing a linked list
class LinkedList<T>{
	Node<T> head;
	Node<T> tail;
	
	public LinkedList(){
		head = null;
		tail = null;
	}
	
	public void appendLast(T data){
		Node<T> last = new Node<T>(data);
		if(this.head == null){
			this.head = last;
			this.tail = last;
			return;
		}
		this.tail.next = last;
		this.tail = last;		
	}
	
	/** 
	 * The idea is to create a window of length k where
	 * right margin is pointed by current
	 * left margin is pointed by follower
	 * when current reaches end of linked linked, follower points to kth to last element
	 * 
	 * k must be in [0, length(list)-1], if not, this method will return null
	 * -- If k < 0: returns null after the error message "k must be a non-negative integer"
	 * -- If k >= length(list): returns null after the error message "k should be less than or equal to (length(list)-1)"
	 */
	public Node<T> kToLast(int k){
		if(k<0){
			System.err.println("k must be a non-negative integer");
			return null;
		}
		
		Node<T> current = head;
		for(int i=0; i<k; i++){
			if(current == null){
				System.err.println("k should be less than or equal to (length(list)-1)");
				break;
			}
			current = current.next;
		}
		if(current == null){
			System.err.println("k should be less than or equal to (length(list)-1)");
			return null;
		}
		
		Node<T> follower = head;
		while(current.next != null){
			follower = follower.next;
			current = current.next;
		}
		return follower;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		Node<T> current = this.head;
		str.append("Linked List: ");
		while(current != null){
			str.append(current.data+"->");
			current = current.next;
		}
		str.append("null");
		return str.toString();
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
	
	public static int kToLast_int(LinkedList<Integer> ll, int k){
		Node<Integer> k_node= ll.kToLast(k);
		if(k_node==null){
			System.exit(-1); //for invalid values of k, exit
		}
		else{
			return k_node.data;
		}
		return -1;		
	}
	
	public static String kToLast_string(LinkedList<String> ll, int k){
		Node<String> k_node = ll.kToLast(k);
		if(k_node == null){
			System.exit(-1); //for invalid values of k, exit
		}
		else{
			return k_node.data;
		}
		return null;		
	}

	public static void main(String[] args) {
		LinkedList<Integer> int_ll = new LinkedList<Integer>();
		for(int i=1; i<=10; i++){
			int_ll.appendLast(i);
		}
		System.out.println(int_ll);
		int k=1;		//Output: 9
		System.out.println("kth to last element (k="+k+"): "+kToLast_int(int_ll, k)); 
		
		k=0;			//Output: 10
		System.out.println("kth to last element (k="+k+"): "+kToLast_int(int_ll, k));
		
		k=9;			//Output: 1
		System.out.println("kth to last element (k="+k+"): "+kToLast_int(int_ll, k)+"\n");
		
		//The following outputs error statements and terminates:
		
//		k=10; //k should be less than or equal to (length(list)-1)
//		System.out.println("k = "+k);
//		System.out.println("kth to last element (k="+k+"): "+kToLast_int(int_ll, k)+"\n");
		
//		k=-1; //k must be a non-negative integer
//		System.out.println("k = "+k);
//		System.out.println("kth to last element (k="+k+"): "+kToLast_int(int_ll, k)+"\n");
		
		
		LinkedList<String> string_ll = new LinkedList<String>();
		//Error statement:
//		System.out.println(string_ll); //Empty linked list
//		k=0;	//k should be less than or equal to (length(list)-1)
//		System.out.println("kth to last element (k="+k+"): "+kToLast_string(string_ll, k)+"\n");
		
		string_ll.appendLast("apple");
		string_ll.appendLast("ball");
		string_ll.appendLast("cat");
		System.out.println(string_ll);
		k=2;	
		System.out.println("kth to last element (k="+k+"): "+kToLast_string(string_ll, k)+"\n");
	}

}

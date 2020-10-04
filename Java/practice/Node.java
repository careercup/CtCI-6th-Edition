public class Node<T>{
	public T data;
	public Node<T> next;

	public Node(T data){
		this.data = data;
	}

	public Node(){

	}

	public Node<T> append(T data){
		Node<T> end = new Node<T>(data);
		Node<T> current = this;
		while(current.next!=null){
			current = current.next;
		}

		current.next = end;
		return current;
	}

	public Node<T> delete(T data){
		Node<T> head = this;
		
		if(head.data.equals(data)){
			return head.next;
		}
		Node<T> current = head;
		
		while(current.next!=null){
			if(current.next.data.equals(data)){
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return head;
	}

	public static void main(String... args){
		System.out.println(args.length);
		Node<Integer> node = new Node<>(Integer.valueOf(4));
		node.append(5);
		node.append(6);
		node.append(7);
		node.printNodes();
		//node = node.delete(6);
		//node = node.reverse();
		//node.printNodes();
		Node<Integer> kthNode = null;
		kthNode = node.kThElement(5);
		if(kthNode!=null)
		System.out.println("kth" + kthNode.data);
	
	}

	public void printNodes(){
		Node<T> current = this;
		while(current!=null){
			System.out.print(current.data);
			current = current.next;
			if(current!=null){
				System.out.print("->");
			}
		}
		System.out.println();
	}

	public Node<T> reverse(){
		Node<T> current = this;
		Node<T> prev = null;
		Node<T> next = null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public Node<T> kThElement(int k){
		Node<T> slow = this;
		Node<T> fast =this;

		while(k>0 && fast!=null){
			fast = fast.next;
			k--;
		}
		System.out.println(k);
		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
	return k==0?slow:null;
	}

	

}
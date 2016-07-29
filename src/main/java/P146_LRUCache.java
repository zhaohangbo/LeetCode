import java.util.Hashtable;

public class P146_LRUCache {
	public class LRUCache {
		private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
		private int count, capacity;
		private DLinkedNode head, tail;
		
		public LRUCache(int capacity){
			this.count=0;this.capacity=capacity;
			head = new DLinkedNode(); head.pre=null;
			tail = new DLinkedNode(); tail.next=null;
			head.next=tail;
			tail.pre =head; 
		}
		public int get(int key) {

		    DLinkedNode node = cache.get(key);
		    if(node == null){
		        return -1; // should raise exception here.
		    }

		    // move the accessed node to the head;
		    this.moveToHead(node);

		    return node.value;
		}


		public void set(int key, int value) {
		    DLinkedNode node = cache.get(key);

		    if(node == null){

		        DLinkedNode newNode = new DLinkedNode();
		        newNode.key = key;
		        newNode.value = value;

		        this.cache.put(key, newNode);
		        this.addNode(newNode);

		        ++count;

		        if(count > capacity){
		            this.cache.remove(tail.pre.key);
		            removeNode(tail.pre);//Don't forget to remove both in Cache and List
		            --count;
		        }
		    }else{
		        // update the value.
		        node.value = value;
		        this.moveToHead(node);
		    }
		}
		/**
		 * Always add the new node right after head;
		 */
		public void addNode(DLinkedNode node){
			head.next.pre=node;
			node.next=head.next;
			
			head.next=node;
			node.pre =head;
		}

		/**
		 * Remove an existing node from the linked list.
		 */
		public void removeNode(DLinkedNode node){
			node.pre.next=node.next;
			node.next.pre=node.pre;
		}

		/**
		 * Remove certain node in between 
		 * Add to the head.
		 */
		public void moveToHead(DLinkedNode node){
			removeNode(node);
			addNode(node);
		}
		
		class DLinkedNode{
			int key;int value;
			DLinkedNode next;
			DLinkedNode pre ;
		}
	}
	
	
	
	
	

}

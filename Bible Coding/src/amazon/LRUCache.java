package amazon;

import java.util.HashMap;

public class LRUCache {
	
	// Pictorial Representation...
	/*|key|Value|next|prev|*/
	
	private HashMap<Integer, LRUNode> map = new HashMap<Integer, LRUNode>();
	
	private int capacity, count;
	LRUNode head, tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new LRUNode(0, 0);
		tail = new LRUNode(0, 0);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		count = 0;
	}

    public void deleteNode(LRUNode node) 
    { 
        node.prev.next = node.next; 
        node.next.prev = node.prev; 
    }
    
    public void addToHead(LRUNode node) 
    { 
        node.next = head.next; 
        node.next.prev = node; 
        node.prev = head; 
        head.next = node; 
    }
    
    // This method works in O(1) 
    public int get(int key) 
    { 
        if (map.get(key) != null) { 
            LRUNode node = map.get(key); 
            int result = node.value; 
            deleteNode(node); 
            addToHead(node); 
            System.out.println("Got the value : " + 
                  result + " for the key: " + key); 
            return result; 
        } 
        System.out.println("Did not get any value" + 
                            " for the key: " + key); 
        return -1; 
    } 
    // This method works in O(1) 
    public void set(int key, int value) 
    { 
        System.out.println("Going to set the (key, "+  
             "value) : (" + key + ", " + value + ")"); 
        if (map.get(key) != null) { 
            LRUNode node = map.get(key); 
            node.value = value; 
            deleteNode(node); 
            addToHead(node); 
        } 
        else { 
            LRUNode node = new LRUNode(key, value); 
            map.put(key, node); 
            if (count < capacity) { 
                count++; 
                addToHead(node); 
            } 
            else { 
                map.remove(tail.prev.key); 
                deleteNode(tail.prev); 
                addToHead(node); 
            } 
        } 
    }
}

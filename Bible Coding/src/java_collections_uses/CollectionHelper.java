package java_collections_uses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionHelper {

	public static void main(String[] args) {
		
		
		// ************************ //
		// ArrayList Implementation (Uses Dynamic Array)
		// ************************ //
		 ArrayList<Integer> numbers = new ArrayList<Integer>();
	        // Adding
	        numbers.add(10);
	        numbers.add(100);
	        numbers.add(40);
	        numbers.add(2, 50);
	 
	        // Retrieving
	        System.out.println(numbers.get(0));
	 
	        System.out.println("nIteration #1: ");
	        // Indexed for loop iteration
	        for (int i = 0; i < numbers.size(); i++) {
	            System.out.println(numbers.get(i));
	        }
	 
	        // Removing items (careful!)
	        numbers.remove(numbers.size() - 1);
	 
	        // This is VERY slow
	        numbers.remove(0);
	 
	        System.out.println("nIteration #2: ");
	        for (Integer value : numbers) {
	            System.out.println(value);
	        }
	 
	        // List interface ...
	        List<String> values = new ArrayList<String>();
	        
	        
	        
	        // ****************************************************************************** //
	        					//**********LinkedList********* (doubly linked list)//
	       // ****************************************************************************** //
	        	LinkedList<String> al=new LinkedList<String>();  
	        	al.add("Ravi");  
	        	al.add("Vijay");  
	        	al.add("Ravi");  
	        	al.add("Ajay");  
	        	al.add(3, "sdfgh");
	        	al.addFirst("Ttata");
	        	al.addLast("pppp");
	        	al.removeFirst();
	        	al.removeLast();
	        	Iterator<String> itr=al.iterator();  
	        	while(itr.hasNext()){  
	        		System.out.println(itr.next());  
	        	}  
	        	//Can be used as a Queue
	        	
	        // ************************************************************************************** //
	        	//***** Vector****** (It is similar to ArrayList. However, It is synchronized) //
	        // ************************************************************************************** //
	        	Vector<String> v=new Vector<String>();  
	        	v.add("Ayush");  
	        	v.add("Amit");  
	        	v.add("Ashish");  
	        	v.add("Garima");  
	        	Iterator<String> itr1=v.iterator();  
	        	while(itr1.hasNext()){  
	        	System.out.println(itr1.next());  
	        	}  
	        	
	        // ***************************************************************************************** //
	        	                           //******* Stack ********//
	        // ***************************************************************************************** //
	        	Stack<String> stack = new Stack<String>();  
	        	stack.push("Ayush");  
	        	stack.push("Garvit");  
	        	stack.push("Amit");  
	        	stack.push("Ashish");  
	        	stack.push("Garima");  
	        	System.out.println("********Stack **********"+stack.pop()); 
	        	Iterator<String> itr2=stack.iterator();  
	        	while(itr2.hasNext()){  
	        	System.out.println(itr2.next());  
	        	}
		        // ***************************************************************************************** //
                							//******* Queue ********//
	        	// ***************************************************************************************** //
	        	
	        	PriorityQueue<String> queue=new PriorityQueue<String>();  
	        	queue.add("Amit Sharma");  
	        	queue.add("Vijay Raj");  
	        	queue.add("JaiShankar");  
	        	queue.add("Raj");  
	        	System.out.println("head:"+queue.element());  
	        	System.out.println("head:"+queue.peek());  
	        	System.out.println("iterating the queue elements:");  
	        	Iterator<String> itr3=queue.iterator();  
	        	while(itr3.hasNext()){  
	        	System.out.println(itr3.next());  
	        	}  
	        	queue.remove();  
	        	queue.poll();  
	        	System.out.println("after removing two elements:");  
	        	Iterator<String> itr4=queue.iterator();  
	        	while(itr4.hasNext()){  
	        	System.out.println(itr4.next());  
	        	} 
	        	
	        	// Queue interface maintains the first-in-first-out order //
	        	
		        // ***************************************************************************************** //
										//******* Deque ********//
	        	
	        	// Deque interface extends the Queue interface. 
	        	// In Deque, we can remove and add the elements from both the side. 
	        	// Deque d = new ArrayDeque();  
	        	// ***************************************************************************************** //
	        	//Creating Deque and adding elements  
	        	Deque<String> deque = new ArrayDeque<String>();  
	        	deque.add("Gautam");  
	        	deque.addFirst("Alok");
	        	deque.add("Karan");  
	        	deque.add("Ajay");  
	        	deque.removeLast();
	        	//Traversing elements  
	        	for (String str : deque) {  
	        	System.out.println(str);  
	        	} 
	        	
		        // ***************************************************************************************** //
								//******* HashSet ********//
	        	// ***************************************************************************************** //
	        	//Creating HashSet and adding elements  
	        	HashSet<String> set=new HashSet<String>();  
	        	set.add("Ravi");  
	        	set.add("Vijay");  
	        	set.add("Ravi");  
	        	set.add("Ajay");  
	        	//Traversing elements  
	        	Iterator<String> itr5=set.iterator();  
	        	while(itr5.hasNext()){  
	        	System.out.println(itr5.next());  
	        	}  
	        	
		        // ***************************************************************************************** //
								//******* LinkedHashSet ********//
	        	// ***************************************************************************************** //
	        	
	        	LinkedHashSet<String> set1=new LinkedHashSet<String>();  
	        	set1.add("Ravi");  
	        	set1.add("Vijay");  
	        	set1.add("Ravi");  
	        	set1.add("Ajay");  
	        	Iterator<String> itr6=set.iterator();  
	        	while(itr6.hasNext()){  
	        	System.out.println(itr6.next());  
	        	} 
	        	// It maintains the insertion order and permits null elements.
	        	
		        // ***************************************************************************************** //
								//******* TreeSet ********//
	        	// ***************************************************************************************** //
	        	
	        	//Creating and adding elements  
	        	TreeSet<String> set2=new TreeSet<String>();  
	        	set2.add("Ravi");  
	        	set2.add("Vijay");  
	        	set2.add("Ravi");  
	        	set2.add("Ajay");  
	        	//traversing elements  
	        	Iterator<String> itr7=set.iterator();  
	        	while(itr7.hasNext()){  
	        	System.out.println(itr7.next());  
	        	} 
	        	// The elements in TreeSet stored in ascending order.
	        	
		        // ***************************************************************************************** //
								//******* HashMap ********//
	        	// ***************************************************************************************** //
	            HashMap<Integer, String> map = new HashMap<Integer, String>();
	            
	            map.put(5, "Five");
	            map.put(8, "Eight");
	            map.put(6, "Six");
	            map.put(4, "Four");
	            map.put(2, "Two");
	             
	            String text = map.get(6);
	             
	            System.out.println(text);
	             
	            for(Map.Entry<Integer, String> entry: map.entrySet()) {
	                int key = entry.getKey();
	                String value = entry.getValue();
	                 
	                System.out.println(key + ": " + value);
	            }
	            
		        // ***************************************************************************************** //
								//******* TreeMap ********//
	        	// ***************************************************************************************** //
	            // Keys are in Sorted Manner
	            TreeMap<Integer,String> map1=new TreeMap<Integer,String>();    
	            map1.put(100,"Amit");   
	            map1.put(103,"Rahul"); 
	            map1.put(102,"Ravi");    
	            map1.put(106,"Baba");    
	              
	            System.out.println("TreeMap");  
	            for(Map.Entry<Integer, String> m:map1.entrySet()){    
	             System.out.println(m.getKey()+" "+m.getValue());    
	            }
	            
		        // ***************************************************************************************** //
								//******* HashTable ********//
	        	// ***************************************************************************************** //
	            // Any non-null object can be used as a key or as a value.
	            // To successfully store and retrieve objects from a hashtable,
	            // the objects used as keys must implement the hashCode method and the equals method.

	            // It is similar to HashMap, but is synchronised.
	            // Hashtable stores key/value pair in hash table.
	            // Create a hash map
	            Hashtable <String, Double> balance = new Hashtable<String, Double>();
	            Enumeration names;
	            String str;
	            double bal;

	            balance.put("Zara", new Double(3434.34));
	            balance.put("Mahnaz", new Double(123.22));
	            balance.put("Ayan", new Double(1378.00));
	            balance.put("Daisy", new Double(99.22));
	            balance.put("Qadir", new Double(-19.08));

	            // Show all balances in hash table.
	            names = balance.keys();
	            
	            while(names.hasMoreElements()) {
	               str = (String) names.nextElement();
	               System.out.println(str + ": " + balance.get(str));
	            }        
	            System.out.println();
	            
	            // Deposit 1,000 into Zara's account
	            bal = ((Double)balance.get("Zara")).doubleValue();
	            balance.put("Zara", new Double(bal + 1000));
	            System.out.println("Zara's new balance: " + balance.get("Zara"));	
	}

}

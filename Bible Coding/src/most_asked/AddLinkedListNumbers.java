package most_asked;
import java.util.Stack;
 
/**
 * <b>IDeserve <br>
 * <a href="<a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a>"><a class="vglnk" href="https://www.youtube.com/c/IDeserve" rel="nofollow"><span>https</span><span>://</span><span>www</span><span>.</span><span>youtube</span><span>.</span><span>com</span><span>/</span><span>c</span><span>/</span><span>IDeserve</span></a></a>
 * Add two numbers represented by linked lists by making use of stacks.
 * @author Nilesh
 */
public class AddLinkedListNumbers 
{
    private class ListNode
    {
        int value;
        ListNode next;
 
        ListNode(int value)
        {
            this.value = value;
        }
    }
     
    ListNode head;
    ListNode tail;
     
    // appends node at the end of the list
    private void appendNode(int value)
    {
        if (head == null)
        {
            head = new ListNode(value);
            tail = head;
            return;
        }
         
        ListNode n = new ListNode(value);
        tail.next = n;
        tail = n;
    }
 
    // creates and returns a new list with node values taken from the stack 's'
    private ListNode createLinkedList(Stack<Integer> s)
    {
        // if the head is pointing to some existing list, make it null
        // let the clients handle and store the reference to head
        if (head != null)
        {
            head = null;
        }
         
        while (!s.isEmpty())
        {
            appendNode(s.pop());
        }
        return head;
    }
     
    // creates and returns a new list with node values taken from number[] array
    public ListNode createLinkedList(int[] number)
    {
        // if the head is pointing to some existing list, make it null
        // let the clients handle and store the reference to head
        if (head != null)
        {
            head = null;
        }
         
        for (int i = 0; i < number.length; i++)
        {
            appendNode(number[i]);
        }
        return head;
    }
     
    public void printList(ListNode head)
    {
        ListNode temp = head;
         
        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
     
     
    public ListNode addLists(ListNode node1, ListNode node2)
    {
        if (node1 == null)
        {
            return node2;
        }
        if (node2 == null)
        {
            return node1;
        }
         
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
         
        // push list1 into the first stack
        ListNode temp = node1;
        while (temp != null)
        {
            s1.push(temp.value);
            temp = temp.next;
        }
         
        // push list2 into the second stack
        temp = node2;
        while (temp != null)
        {
            s2.push(temp.value);
            temp = temp.next;
        }
 
        int sum = 0, carry = 0, value1, value2;
         
        // keep adding the popped digits to the sum until one of the stacks becomes empty
        // sum itself is stored in a stack
        while ((!s1.empty()) && (!s2.empty()))
        {
            value1 = s1.pop();
            value2 = s2.pop();
             
            sum   = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
             
            s3.push(sum);
        }
         
        // if stack1 still has some digits left, add those digits to the sum 
        while (!s1.isEmpty())
        {
            value1 = s1.pop();
             
            sum   = (value1 + carry) % 10;
            carry = (value1 + carry) / 10;
             
            s3.push(sum);
        }
         
        // if stack2 still has some digits left, add those digits to the sum
        while (!s2.isEmpty())
        {
            value2 = s2.pop();
             
            sum   = (value2 + carry) % 10;
            carry = (value2 + carry) / 10;
             
            s3.push(sum);
        }
         
        // after adding digits from both the stack, if the remaining carry is greater than 0
        // add that carry to the sum
        if (carry > 0)
        {
            s3.push(carry);
        }
         
        // finally, from the resultant stack, which stores the sum create a new linked list
        // return this newly created linked list
        return createLinkedList(s3);
    }
     
     
    public static void main(String[] args) 
    {
    	AddLinkedListNumbers solution = new AddLinkedListNumbers();
 
        int[] firstNumber  = {9,9,9,7,1}; // number: 99971
        int[] secondNumber = {9,9,8}; // number: 998
         
        // 9->9->9->7->1->null
        ListNode head1 = solution.createLinkedList(firstNumber);
         
        // 9->9->8->null
        ListNode head2 = solution.createLinkedList(secondNumber);
         
        ListNode result = solution.addLists(head1, head2);
         
        System.out.print("Resultant sum represented as a linked list is: \n");
        solution.printList(result);
    }
}
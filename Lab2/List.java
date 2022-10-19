import java.util.NoSuchElementException;

public class List<T> {
    class Node {
        private T data;
        private Node next;
        private Node prev;
       
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
   
    private int length;
    private Node first;
    private Node last;
    private Node iterator;
   
    /****CONSTRUCTOR****/
   
    /**
     * Instantiates a new List with default values
     * @postcondition sets the starting values
     */
    public List() {
    	first = null;
    	last = null;
    	length = 0;
    	iterator = null;
 
    }
    
   
    /****ACCESSORS****/
   
    /**
     * Returns the value stored in the first node
     * @precondition length != 0
     * @return the value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException{
    	if(length == 0)
    	{
    		throw new NoSuchElementException ("getFirst: List is empty. No data to access!!");
    	}
        return first.data;
    }
   
    /**
     * Returns the value stored in the last node
     * @precondition length != 0
     * @return the value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException{
    	if(length == 0)
    	{
    		throw new NoSuchElementException ("getLast: List is empty. No data to access!!");
    	}
        return last.data;
    }
   
    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }
   
    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
    	return length == 0;
    }
    
    public T getIterator() throws NullPointerException
    {
    	if(iterator == null)
    	{
    		throw new NullPointerException ("getIterator: " + "The list is empty");
    	}
    	else
    	{
    		return iterator.data;
    	}
    	
    }
    
    public boolean offEnd()
    {
    	return iterator == null;
    }
    
    
   
    /****MUTATORS****/
   
    /**
     * Creates a new first element
     * @param data the data to insert at the
     * front of the list
     * @postcondition
     */
    public void addFirst(T data) {
    	if(first == null)
    	{
    		first = last = new Node(data); 
    	}
    	else
    	{
    		Node N = new Node(data);
    		N.next = first; //update next node with empty node
    		first.prev = N; //update prev node with N
    		first = N;      //store first node with new node
    	}
    	length++;
    }
   
    /**
     * Creates a new last element
     * @param data the data to insert at the
     * end of the list
     * @postcondition adds new node to last of the list
     */
    public void addLast(T data) {
    	if(first == null)
    	{
    		first = last = new Node(data);
    	}else
    	{
    		Node N = new Node(data);
    		last.next = N;
    		N.prev = last;
    		last = N;
    	}
    	length++;
    }
   
    /**
    * removes the element at the front of the list
    * @precondition length != 0
    * @postcondition Fist Node is removed
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException{
       if(length == 0)
       {
    	   throw new NoSuchElementException ("removeFirst() : cannot remove from the empty list");
       }else if(length == 1)
       {
    	   first = last = null;
       }else {
    	   if(iterator == first){
    		   removeIterator();
    	   }
       
    	   first = first.next;
    	   first.prev = null;
       }
       length--;
    }
   
    /**
     * removes the element at the end of the list
     * @precondition
     * @postcondition
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException{
        if(length == 1)
        {
        	throw new NoSuchElementException ("removeLast() : cannot remove from the empty list");
        }else if (length == 1)
        {
        	first = last = null;
        }else
        {
        	last = last.prev;
        	last.next = null;
        }
        length--;
    }
    
    public void placeIterator()
    {
    	iterator = first;
    }
    
    public void removeIterator() throws NullPointerException
    {
    	if(iterator == null)
    	{
    		throw new NullPointerException("Error");
    	}
    	else if(iterator == first)
    	{
    		first = first.next;
    	}
    	else if(iterator == last)
    	{
    		last = last.prev;
    	}
    	else
    	{
    		iterator.prev.next = iterator.next;
    		iterator.next.prev = iterator.prev;
    	}
    	iterator = null;
    	length--;
    }
    public void addIterator(T data) throws NullPointerException
    {
    	if(iterator == null)
    	{
    		throw new NullPointerException("ERROR");
    	}
    	else if(iterator == first)
    	{
    		Node N = new Node(data);
    		N.next = first.next;
    		first.next.prev = N;
    		first.next = N;
    		N.prev = first;
    		first = N;
    	}
    	else if(iterator == last)
    	{
    		Node N = new Node(data);
    		last.next = N;
    		N.prev = last;
    		last = N;
    		N.next = null;
    	}
    	else
    	{
    		Node N = new Node(data);
    		iterator.next.prev = N;
    		N.next = iterator.next;
    		iterator.next = N;
    		N.prev = iterator;
    		
    		
    	}
 
    	
    }
    public void advanceIterator() throws NullPointerException
    {
    	if(iterator == null)
    	{
    		throw new NullPointerException("ERROR");
    	}
    	iterator = iterator.next;
    }
   public void reverseIterator() throws NullPointerException
   {
	   if(iterator == null)
	   {
		   throw new NullPointerException("ERROR");
	   }
	   iterator = iterator.prev;
   }
    /****ADDITIONAL OPERATIONS****/
   
    /**
     * List with each value on its own line
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
        String result = "";
        Node temp = first;
        while(temp != null) {
            result += temp.data + " ";
            temp = temp.next;
        }
        return result + "\n";
    }
    public void printNumberedList()
    {
    	Node temp = first;
    	int i = 1;
    	while(temp != null)
    	{
    		System.out.println(i + ". " + temp.data);
    		temp = temp.next;
    		i++;
    	}
    }


    public boolean equals(List list)
    {
    	if(list.length == length)
    	{
    		return false;
    	}
    	else
    	{
    		//this.placeIterator();
    		List.Node temp = first;
    		while(temp != null)
    		{
    			if(list.iterator.data != temp.data)
    			{
    				return false;
    			}
    			//advanceIterator();
    			temp = temp.next;
    		}
    		return true;
    	}
    }
  

}
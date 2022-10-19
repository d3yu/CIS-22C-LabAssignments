
public class ListTest {
	public static void main(String args[]){
		
		List <Character> L = new List<>();
		L.addLast('F');
		L.addLast('G');
		L.addLast('A');
		L.addLast('D');
		L.addLast('C');
		L.addLast('H');
		L.addLast('F');
		L.removeFirst();
		
		
		System.out.println(L);
		
		L.placeIterator();
		for(int i = 0; i < 2; i++)
		{
			L.advanceIterator();
		}
		char a = L.getIterator();
		L.removeIterator();
		
		L.placeIterator();
	    for(int i = 0; i < 3; i++)
	    {
	    	L.advanceIterator();
	    }
	    char b = L.getIterator();
	    L.removeIterator();
	    
	    L.placeIterator();
	    for(int i = 0; i < 1; i++)
	    {
	    	L.advanceIterator();
	    }
	    L.addIterator(b);
	    
	    L.placeIterator();
	    for(int i = 0; i < 3; i++)
	    {
	    	L.advanceIterator();
	    }
	    L.addIterator(a);
	    
	    System.out.println(L);
	}
}

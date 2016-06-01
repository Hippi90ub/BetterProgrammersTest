import java.util.*;


class BetterProgrammerTask {

	static class Change {
	    private final int _dollars;
	    private final int _quarters; //25 cents
	    private final int _dimes; // 10 cents
	    private final int _nickels; // 5 cents
	    private final int _cents; // 1 cent


	    public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
	        _dollars = dollars;
	        _quarters = quarters;
	        _dimes = dimes;
	        _nickels = nickels;
	        _cents = cents;
	    }


	    public int getDollars() {
	        return _dollars;
	    }


	    public int getQuarters() {
	        return _quarters;
	    }


	    public int getDimes() {
	        return _dimes;
	    }


	    public int getNickels() {
	        return _nickels;
	    }


	    public int getCents() {
	        return _cents;
	    }
	}
	
	public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */
		
		int dollars = cents / 100;
		cents = cents % 100;
		int quarters = cents / 25;
		cents = cents % 25;
		int dimes = cents / 10;
		cents = cents % 10;
		int nickels = cents / 5;
		cents = cents % 5;
		
		Change ch = new Change(dollars, quarters, dimes, nickels, cents);
		return ch;
    }
	
	public static class WriteOnceMap<K, V> extends HashMap<K, V> {

        public V put(K key, V value) {
            /*
             WriteOnceMap is a map that does not allow changing value for a particular key.
             It means that put() method should throw IllegalArgumentException if the key is already
             assosiated with some value in the map.

             Please implement this method to conform to the above description of WriteOnceMap.
            */
        	
        	if (containsKey(key)) {
        		throw new IllegalArgumentException("The key is already assosiated!");
        	}
        	else {
        		super.put(key, value);
        	}
        	
        	return value;
        }


        public void putAll(Map<? extends K, ? extends V> m) {
            /*
             Please implement this method to conform to the description of WriteOnceMap above.
             It should either
             (1) copy all of the mappings from the specified map to this map or
             (2) throw IllegalArgumentException and leave this map intact
             if the parameter already contains some keys from this map.
            */
        	
        	Set<? extends K> keySet = m.keySet();
        	
        	for (Iterator it = keySet.iterator(); it.hasNext();) {
        		if (containsKey(it.next())) {
        			throw new IllegalArgumentException("The key is already assosiated!");
        		}
        		else {
        			super.putAll(m);
        		}
        	}
        }
    }
	
	// Please do not change this interface
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }
    
    
    public static ListNode reverse(ListNode node) {
        /*
          Please implement this method to
          reverse a given linked list.
         */
    	
    	ListNode current = node;
    	ListNode next = node.getNext();
    	node.setNext(null);
    	while (next != null) {
    		next.setNext(current);
    		next = next.getNext();
    		current = next;
    	}
    	return current;

    }
    
    static public int steps(int n)
    {
    	if (n<=1) {
    		return n;
    	}
    	return steps(n-1) + steps(n-2);
    }
    
    public static int countWaysToJump(int N) {
        /*
          A set of stairs has N steps.
          You can jump either 1 or 2 steps at a time.
          For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
          1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
          Please implement this method to
          return the count of the different ways to reach the end of the stairs with N steps.
         */
    	return steps(N);
    }
    
}

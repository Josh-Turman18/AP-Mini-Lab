
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Selection};
    ListType listType = ListType.Standard;
    
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] slist; int scompares = 0; int sswaps = 0;

    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
                System.out.println("Insertions Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
                break;
            case Selection:
            	System.out.println("Selection Sort -- "
                        + " Operations: " + (this.scompares + this.sswaps)
                        + " Compares: " + this.scompares
                        + " Swaps: " + this.sswaps);
                      list = this.slist;
                break;
            default:
            	list = this.list;
            	break;
        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
        
        return ilist;
    }
    
    
    private int[] SelectionSort()
    {
    	int first, temp;
    	// iterate list, one less than length
    	for(int i = slist.length - 1 ; i > 0 ; i--)
    	{
    		// selection sort key logic
    		first = 0;
    		
    		for(int j = 1 ; j <= i ; j++)
    		{
    			// analytics
        		this.scompares++;  // compare counter
        		
    			if(slist[j] > slist[first])
    			{
    				first = j;
    			}
    		}
    		temp = slist[first];
    		slist[first] = slist[i];
    		slist[i] = temp;
    		// analytics
    		this.sswaps++;  // swap counter
    	}
    	return slist;
    }
    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        // Selection Sort
        is.listType = ListType.Selection;
        System.out.println(is);
    }
}

/*
 * Assessment:
 * Looking at the tables (found on pdf), it is clear that the selection sort is the most efficient of these three methods.
 * Selection sort performed the same amount of operations each trial, no matter how un-organized the array was. This is
 * because when using selection sort, a swap only occurs when the lowest (or highest) value in the array is found. The next
 * most efficient would be insertion. Insertion can take less operations that selection, but this is only if the array starts
 * out more organized. On average, insertion takes more operations than selection, thus making it less efficient on average.
 * The least efficient is clearly bubble sort. It's average operations were about 600 more than the other methods or sorting.
 * 
 */

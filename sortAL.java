import java.util.*;

public class sortAL {

	public sortAL() {
		// TODO Auto-generated constructor stub
	}
	
	public void SelectionSort(ArrayList<Object> list)
	{
		int first;
		Object temp;
		
		// iterates through the ArrayList one less than the size of it
		for(int i = (list.size()) - 1 ; i > 0 ; i--)
		{
			// basic logic for a Selection Sort
			first = 0;
			for (int j = 1 ; j <= i ; j++)
			{
				if(list.get(j).toString().compareTo(list.get(first).toString()) > 0)
				{
					first = j;
				}
			}
			temp = list.get(first);
			list.set(first, list.get(i));
			list.set(i, temp);
		}
	}

}

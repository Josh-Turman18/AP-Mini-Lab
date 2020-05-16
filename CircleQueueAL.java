import java.util.*;

public class CircleQueueAL {

	// array list that will hold the objects in order
	public static ArrayList<Object> list = new ArrayList<Object>();
	public int count;
	
	/*
	 * constructor
	 */
	public CircleQueueAL() {
		count = 0;
	}
	
	// adds an object to the ArrayList
	public void addElement(Object[] objects)
	{
		int i = 0;
		ConsoleMethods.println("Add " + objects.length);
		for (Object o : objects)
		{
			list.add(o);
			System.out.println("Add: " + o.toString() + " -- " + list);
			this.count++;
		}
		System.out.println();
	}
	
	// Displays the whole ArrayList
	public void showAList()
	{
		System.out.println("Size: " + count);
		System.out.println("First Element: " + list.get(0));
		System.out.println("Last Element: " + list.get((this.count) - 1));
		System.out.println("Full ArrayList: " + list);
		System.out.println();
	}
	
	// deletes all the elements for the ArrayList
	public void deleteList()
	{
		while(list.size() > 0)
		{
			System.out.print("Delete: " + list.get(0) + " -- ");
			list.remove(0);
			System.out.println(list);
		}
	}
	
	// run the CircleQueueAL class
	public static void main(String[] args)
	{
		CircleQueueAL trial = new CircleQueueAL();
		sortAL sorting = new sortAL();
		
		// added objects to the ArrayList
		trial.addElement(Animal.animalData());
		trial.addElement(Cupcakes.cupCakeData());
		trial.addElement(Alphabet.alphabetData());
		trial.addElement(Classroom.classroomData());
		
		// displays the ArrayList
		trial.showAList();
		
		// change the keys for each object
		Animal.key = Animal.KeyType.name;
		Cupcakes.key = Cupcakes.KeyType.flavor;
		Alphabet.key = Alphabet.KeyType.letter;
		Classroom.key = Classroom.KeyType.subject;  // changed the key in Classroom to the class's subject
		
		// sorts the ArrayList using the selection sort method
		sorting.selectionSort(list);
		
		// displays the sorted list
		System.out.println("Sorted ArrayList: ");
		trial.showAList();
		
		// delete the ArrayList's elements
		trial.deleteList();
		
	}

}

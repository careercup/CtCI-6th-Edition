package Q7_11_File_System;

public class Question {

	public static void main(String[] args) {
		Directory root = new Directory("Food", null);
		File taco = new File("Taco", root, 4);
		File hamburger = new File("Hamburger", root, 9);
		root.addEntry(taco);
		root.addEntry(hamburger);
		
			Directory healthy = new Directory("Healthy", root);
		
				Directory fruits = new Directory("Fruits", healthy);
					File apple = new File("Apple", fruits, 5);
					File banana = new File("Banana", fruits, 6);
				fruits.addEntry(apple);
				fruits.addEntry(banana);
				
			healthy.addEntry(fruits);
				
				Directory veggies = new Directory("Veggies", healthy);
					File carrot = new File("Carrot", veggies, 6);
					File lettuce = new File("Lettuce", veggies, 7);
					File peas = new File("Peas", veggies, 4);
				veggies.addEntry(carrot);
				veggies.addEntry(lettuce);
				veggies.addEntry(peas);
			
			healthy.addEntry(veggies);
			
		root.addEntry(healthy);
		
		System.out.println(root.numberOfFiles());
		System.out.println(veggies.getFullPath());
	}

}

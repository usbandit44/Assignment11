// Assignment: Assignment11.java
// Name: Arvin Edouard
// StudentID: 1222200512
// Lecture: Tuesday Thursday 1:30 to 2:45
// Description: program to create search and print a maze for easterbunny

public class Assignment11 {

	public static void main(String[] args) {
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.readMaze();

		System.out.println("Original maze: ");
		mazeSolver.printMaze();

		mazeSolver.depthFirstSearch();

		System.out.println("Maze after Easter Bunny traverse: ");
		mazeSolver.printMaze();

		if (mazeSolver.getEggFound() == 0)
			System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
		else
			System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
	}
}
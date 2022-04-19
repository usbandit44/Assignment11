// Assignment: Assignment11.java
// Name: Arvin Edouard
// StudentID: 1222200512
// Lecture: Tuesday Thursday 1:30 to 2:45
// Description: class to search and print maze

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {

	private Stack<Node> stack;
	private char [][] maze;
	private int eggFound;
	private int mHeight;
	private int mWidth;

	public MazeSolver(){
		stack = new Stack<Node>();
		eggFound = 0;
	}
	
	public void depthFirstSearch(){
		stack.push(new Node(0,0));

		while(!stack.isEmpty()){// keeps node going until stack is empty
			Node current = stack.pop();// pops node in stack

			if(maze[current.getX()][current.getY()] == 'E'){// adds egg if egg is found
				eggFound++;
			}
			maze[current.getX()][current.getY()] = 'x';// marks spot as visited

			if(valid(current.getX() + 1, current.getY())){// makes south node
				Node south = new Node(current.getX() + 1, current.getY());
				stack.push(south);
			}

			if(valid(current.getX(), current.getY() + 1)){// makes east node
				Node east = new Node(current.getX(), current.getY() + 1);
				stack.push(east);
			}

			if(valid(current.getX() - 1, current.getY())){// makes north node
				Node north = new Node(current.getX() - 1, current.getY());
				stack.push(north);
			}
			
			if(valid(current.getX(), current.getY() - 1)){// makes west node
				Node west = new Node(current.getX(), current.getY() - 1);
				stack.push(west);
			}
			


		}

	}
	
	private boolean valid(int a, int b){// helper method to check if node is valid
		if(a >= 0 && b >= 0 && a < maze.length && b < maze[a].length){
			if(maze[a][b] == '#' || maze[a][b] == 'x'){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	
	}

	public int getEggFound() { // getter method for eggs found
		return eggFound;
	}

	public void printMaze(){
		for(int i = 0; i < maze.length; i++){// prints maze by going thogh double array
			for(int j = 0; j < maze[i].length; j++){
				System.out.print(maze[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	// ************************************************************************************
	// ************** Utility method to read maze from user input *************************
	// ************************************************************************************
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

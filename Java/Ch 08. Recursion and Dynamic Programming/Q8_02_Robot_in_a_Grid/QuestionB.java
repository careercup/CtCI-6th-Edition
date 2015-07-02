package Q8_02_Robot_in_a_Grid;

import java.util.ArrayList;
import java.util.HashMap;

import CtCILibrary.AssortedMethods;

public class QuestionB {
	public static ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		int lastRow = maze.length - 1;
		int lastCol = maze[0].length - 1;
		if (getPath(maze, lastRow, lastCol, path, cache)) {
			return path;
		}
		return null;
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
		/* If out of bounds or not available, return.*/
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		Point p = new Point(row, col);
		
		/* If we've already visited this cell, return. */
		if (cache.containsKey(p)) { 
			return cache.get(p);
		}	
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		boolean success = false;
		
		/* If there's a path from the start to my current location, add my location.*/
		if (isAtOrigin || getPath(maze, row, col - 1, path, cache) || getPath(maze, row - 1, col, path, cache)) {
			path.add(p);
			success = true;
		}
		
		cache.put(p, success); // Cache result
		return success;
	}
	
	public static void main(String[] args) {
		int size = 5;
		boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
	}

}

package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList; //import ArrayList class
import java.util.List; //import List interface
import java.util.Random; //import Random class

/*
simulate ants finding the shortest path between two points on a grid.
The Ant class represents an ant which moves around the grid.
The move() method determines the next position for the ant based on its current position and the grid.
The getNeighbors() method returns a list of neighboring positions around the ant's current position.
The pickNextPosition() method randomly selects one of the neighboring positions for the ant to move to.
The AntRoutingExample class is the main class where the simulation is run. It initializes the grid, creates an ant, and moves it for a certain number of steps.
 */

class Ant {
    private int x; //x-coordinate
    private int y; //y-coordinate
    private int[][] grid; //grid representation

    //constructor for Ant class
    public Ant(int x, int y, int[][] grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    //moves the ant
    public void move() {
        List<int[]> neighbors = getNeighbors(x, y, grid.length, grid[0].length); //gets neighboring positions
        int[] nextPosition = pickNextPosition(neighbors); //picks the next position randomly
        this.x = nextPosition[0]; //updates x-coordinate
        this.y = nextPosition[1]; //updates y-coordinate
    }

    //method that gets neighboring positions
    private List<int[]> getNeighbors(int x, int y, int maxX, int maxY) {
        List<int[]> neighbors = new ArrayList<>(); //list that stores neighboring positions
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = x + dx; //gets new x-coordinate
                int newY = y + dy; //gets new y-coordinate
                //checks if the new position is within the grid and not the current position
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !(dx == 0 && dy == 0)) {
                    neighbors.add(new int[]{newX, newY}); //adds a valid and usable neighbor to the list
                }
            }
        }
        return neighbors; //returns the list of neighboring positions
    }

    //randomly picks the next position from the neighbors list
    private int[] pickNextPosition(List<int[]> neighbors) {
        Random rand = new Random(); //creates a Random object
        int index = rand.nextInt(neighbors.size()); //makes a random index within the range of neighbors list
        return neighbors.get(index); //returns a randomly picked neighbor
    }

    //getter for the x-coordinate
    public int getX() {
        return x;
    }

    //getter method for the y-coordinate
    public int getY() {
        return y;
    }
}

public class AntRoutingExample {

    public static void main(String[] args) {
        int[][] grid = new int[10][10]; //makes the grid
        //sets obstacle at (3,3)
        grid[3][3] = 1;

        Ant ant = new Ant(0, 0, grid); //creates ant at position (0,0)
        int steps = 20; //number of steps to move the ant
        for (int i = 0; i < steps; i++) {
            ant.move(); //moves the ant
            System.out.println("Ant moved to: (" + ant.getX() + ", " + ant.getY() + ")"); //prints the ant's new position
        }
    }
}

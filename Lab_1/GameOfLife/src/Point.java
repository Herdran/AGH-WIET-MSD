import java.util.ArrayList;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		//TODO: insert logic which updates according to currentState and number of active neighbors
		//Done
		int activeNeighbors = countActiveNeighbors();
		nextState = currentState;

		if(currentState == 0 && activeNeighbors == 3)
			nextState = 1;

		if(currentState == 1 && activeNeighbors != 2 && activeNeighbors != 3)
			nextState = 0;
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	//Done
	public int countActiveNeighbors(){
		int counter = 0;
		for(Point neighbor : neighbors){
			if(neighbor.getState() == 1){
				counter ++;
			}
		}
		return counter;
	}
}

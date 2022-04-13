import java.util.ArrayList;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;
	public boolean blocked = false;

	public Point() {
		type=0;
		staticField = 100000;
		neighbors= new ArrayList<Point>();
	}

	public void clear() {
		staticField = 100000;
	}

	public boolean calcStaticField() {
//		If statement for "wall" case
		if (type == 1){
			return false;
		}

		int min = staticField;
		for (Point neighbour: neighbors){
			min = Math.min(min, neighbour.staticField);
		}
		if (staticField > min + 1) {
			staticField = min + 1;
			return true;
		}

		return false;
	}

	public void move() {
		if (isPedestrian && !blocked) {
			int min = staticField;
			Point min_point = null;
			for (Point neighbor : neighbors) {
				if ((neighbor.type == 0 || neighbor.type == 2) && !neighbor.blocked) {
					if (neighbor.staticField < min) {
						min = neighbor.staticField;
						min_point = neighbor;
					}
				}
			}

			if (min_point != null) {
				type = 0;
				isPedestrian = false;
				min_point.blocked = true;
				if (min_point.type == 0) {
					min_point.type = 3;
					min_point.isPedestrian = true;
				}
			}
		}
	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}
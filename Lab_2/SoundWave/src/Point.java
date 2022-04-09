public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer []types ={0,1,2};
	int type;
	int sinInput;

	public Point() {
		type = 0;
		sinInput = 0;
		clear();
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		// Done
		nVel = 0;
		eVel = 0;
		wVel = 0;
		sVel = 0;
		pressure = 0;
//		type = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		// Done
		if (type == 0){
			if (nNeighbor != null){
				nVel = nVel - (nNeighbor.getPressure() - getPressure());
			}
			if (eNeighbor != null){
				eVel = eVel - (eNeighbor.getPressure() - getPressure());
			}
			if (wNeighbor != null){
				wVel = wVel - (wNeighbor.getPressure() - getPressure());
			}
			if (sNeighbor != null){
				sVel = sVel - (sNeighbor.getPressure() - getPressure());
			}
		}

	}

	public void updatePresure() {
		// TODO: pressure update
		// Done
		if (type == 0){
			pressure = pressure - (nVel + eVel + wVel + sVel) / 2;
		}
		if (type == 2){
			sinInput = sinInput % 360 + 30;
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
	}

	public float getPressure() {
		return pressure;
	}
}
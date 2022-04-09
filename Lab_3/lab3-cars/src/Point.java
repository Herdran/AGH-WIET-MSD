public class Point {
    public int type;
    public Point next;
    public boolean moved;
    public int velocity;

    public Point() {
        velocity = 1;
    }

    public void move() {
        Point nextPoint = next;
        for (int nextPos = 1; nextPos < velocity; nextPos++) {
            nextPoint = nextPoint.next;
        }

        if (type == 1 && nextPoint.type == 0 && !moved){
            type = 0;
            moved = true;
            velocity = 0;

            nextPoint.type = 1;
            nextPoint.moved = true;
            nextPoint.velocity = velocity;
        }
    }

    public void speedUp() {
        if (velocity < 5)
            velocity++;
    }

    public void slowDown() {
        Point nextCar = next;

        for (int distance = 1; distance <= 5; distance++) {
            if (nextCar.type == 1){
                if (distance <= velocity){
                    velocity = distance - 1;
                }
                break;
            }
            nextCar = nextCar.next;
        }
    }

    public void random() {
        if (velocity >= 1){
            if (Math.random() < 0.3){
                velocity -= 1;
            }
        }
    }

    public void clicked() {
        type = 1;
    }

    public void clear() {
        type = 0;
    }
}


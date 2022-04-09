import java.util.Arrays;
import java.util.List;

public class Point {
    public int type;
    public Point next;
    public Point prev;
    public boolean moved;
    public int velocity;
    public static Integer[] types = {0, 1, 2, 3, 5};
    public int max_vel;
    public static List carTypes = Arrays.asList(1, 2, 3);

//    public Point() {
//        velocity = 1;
//        max_vel = 0;
//    }

    public void becomePoint(Point point) {
        type = point.type;
        moved = point.moved;
        velocity = point.velocity;
        max_vel = point.max_vel;
    }

    public void move() {
        Point nextPoint = next;

        for (int nextPos = 1; nextPos < velocity; nextPos++) {
            nextPoint = nextPoint.next;
        }

        if (carTypes.contains(type) && nextPoint.type == 0 && !moved){
            nextPoint.type = type;
            nextPoint.moved = true;
            nextPoint.velocity = velocity;
            nextPoint.max_vel = max_vel;

            type = 0;
            moved = true;
            velocity = 0;
            max_vel = 0;
        }
    }

    public void speedUp() {
        if (velocity < max_vel)
            velocity++;
    }

    public void slowDown() {
        Point nextCar = next;
        int distance_nextCar = 1;
        for (; distance_nextCar < max_vel; distance_nextCar++) {
            if (carTypes.contains(nextCar.type)){
                break;
            }
            nextCar = nextCar.next;
        }
        if (distance_nextCar <= velocity)
            velocity = distance_nextCar - 1;
    }

    public void clicked() {
        this.type = 0;
    }


    public void clear() {
        if (type != 5)
            type = 0;
    }

    public boolean canOvertake(Point leftPoint){
        Point prevCarRight = prev;
        int distance_prevCarRight = 1;
        for (; distance_prevCarRight < 7; distance_prevCarRight++) {
            if (carTypes.contains(prevCarRight.type)){
                break;
            }
            prevCarRight = prevCarRight.prev;
        }

        Point prevCarLeft = leftPoint.prev;
        int distance_prevCarLeft = 1;
        for (; distance_prevCarLeft < 7; distance_prevCarLeft++) {
            if (carTypes.contains(prevCarLeft.type)){
                break;
            }
            prevCarLeft = prevCarLeft.prev;
        }

        Point nextCarLeft = leftPoint.next;
        int distance_nextCarLeft = 1;
        for (; distance_nextCarLeft < 7; distance_nextCarLeft++) {
            if (carTypes.contains(nextCarLeft.type)){
                break;
            }
            nextCarLeft = nextCarLeft.next;
        }

        if ((velocity < max_vel) && (distance_prevCarRight >= prevCarRight.max_vel) && (distance_prevCarLeft >= prevCarLeft.max_vel) && (distance_nextCarLeft >= velocity)){
            return true;
        }
        return false;
    }

    boolean canFinishOvertake(Point rightPoint){
        Point prevCarLeft = prev;
        int distance_prevCarLeft = 1;
        for (; distance_prevCarLeft < 7; distance_prevCarLeft++) {
            if (carTypes.contains(prevCarLeft.type)){
                break;
            }
            prevCarLeft = prevCarLeft.prev;
        }

        Point prevCarRight = rightPoint.prev;
        int distance_prevCarRight = 1;
        for (; distance_prevCarRight < 7; distance_prevCarRight++) {
            if (carTypes.contains(prevCarRight.type)){
                break;
            }
            prevCarRight = prevCarRight.prev;
        }

        Point nextCarRight = rightPoint.next;
        int distance_nextCarRight = 1;
        for (; distance_nextCarRight < 7; distance_nextCarRight++) {
            if (carTypes.contains(nextCarRight.type)){
                break;
            }
            nextCarRight = nextCarRight.next;
        }

        if ((distance_prevCarRight >= prevCarRight.velocity) && (distance_prevCarLeft <= prevCarLeft.max_vel) && (distance_nextCarRight >= velocity)){
            return true;
        }
        return false;
    }

}


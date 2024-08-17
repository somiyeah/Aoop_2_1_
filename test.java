public class Elevator {
    private int currentFloor = 0;
    private int targetFloor = 0;
    private State state = State.IDLE;

    enum State {
        IDLE, MOVING_UP, MOVING_DOWN
    }

    public void moveToFloor(int floor) {
        targetFloor = floor;
        if (floor > currentFloor) {
            state = State.MOVING_UP;
        } else if (floor < currentFloor) {
            state = State.MOVING_DOWN;
        }
    }

    public void update() {
        switch (state) {
            case MOVING_UP:
                if (currentFloor < targetFloor) {
                    currentFloor++;
                    System.out.println("Elevator moving up to floor: " + currentFloor);
                } else {
                    state = State.IDLE;
                    System.out.println("Elevator arrived at floor: " + currentFloor);
                }
                break;
            case MOVING_DOWN:
                if (currentFloor > targetFloor) {
                    currentFloor--;
                    System.out.println("Elevator moving down to floor: " + currentFloor);
                } else {
                    state = State.IDLE;
                    System.out.println("Elevator arrived at floor: " + currentFloor);
                }
                break;
            case IDLE:
                // Do nothing while idle
                break;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public State getState() {
        return state;
    }
}
public class test{



public static void main(String[] args) {
    Elevator elevator = new Elevator();
    elevator.moveToFloor(5);

    while (elevator.getState() != State.IDLE) {
        elevator.update();
    }
}
}
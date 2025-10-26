// ElevatorStateMachine.java
public class ElevatorStateMachine {

    // Possible states of the elevator
    private enum State {
        IDLE,
        MOVING_UP,
        MOVING_DOWN,
        DOOR_OPEN
    }

    private State currentState;
    private int currentFloor;
    private int targetFloor;

    public ElevatorStateMachine() {
        this.currentState = State.IDLE;
        this.currentFloor = 0;
        this.targetFloor = 0;
        System.out.println("Elevator initialized at floor " + currentFloor + " [State: " + currentState + "]");
    }

    // Handles a request to move to a specific floor
    public void requestFloor(int floor) {
        System.out.println("Request received: Floor " + floor);

        if (currentState == State.DOOR_OPEN) {
            System.out.println("Cannot move while door is open. Please close the door first.");
            return;
        }

        if (floor == currentFloor) {
            System.out.println("Already at floor " + floor + ". Opening door...");
            currentState = State.DOOR_OPEN;
            printState();
            return;
        }

        targetFloor = floor;

        if (floor > currentFloor) {
            currentState = State.MOVING_UP;
            moveElevator();
        } else if (floor < currentFloor) {
            currentState = State.MOVING_DOWN;
            moveElevator();
        }
    }

    // Simulates movement between floors
    private void moveElevator() {
        printState();

        // Simulate travel (for demonstration, we instantly reach target)
        System.out.println("Moving from floor " + currentFloor + " to floor " + targetFloor + "...");
        currentFloor = targetFloor;

        // Once reached, open doors
        currentState = State.DOOR_OPEN;
        System.out.println("Arrived at floor " + currentFloor);
        printState();
    }

    public void openDoor() {
        if (currentState == State.IDLE) {
            currentState = State.DOOR_OPEN;
            System.out.println("Door opened at floor " + currentFloor);
        } else if (currentState == State.DOOR_OPEN) {
            System.out.println("Door is already open.");
        } else {
            System.out.println("Cannot open doors while moving!");
        }
        printState();
    }

    public void closeDoor() {
        if (currentState == State.DOOR_OPEN) {
            currentState = State.IDLE;
            System.out.println("Door closed. Elevator is now idle.");
        } else {
            System.out.println("Cannot close doors when not open.");
        }
        printState();
    }

//    public String getState() {
//        return currentState.name();
//    }
//
//    public int getCurrentFloor() {
//        return currentFloor;
//    }

    private void printState() {
        System.out.println("Current State: " + currentState + ", Floor: " + currentFloor );
    }

    // Simple test run
    public static void main(String[] args) {
        ElevatorStateMachine elevator = new ElevatorStateMachine();

        elevator.requestFloor(3);
        System.out.println();

        elevator.closeDoor();  // Trying to close door while moving - ignored
        System.out.println();

        elevator.closeDoor();  // After door open, should transition to IDLE
        System.out.println();

        elevator.requestFloor(1);
        System.out.println();

        elevator.openDoor();   // Invalid while moving
        System.out.println();

        elevator.closeDoor();  // After door open
        System.out.println();

        elevator.requestFloor(1); // Same floor - opens door directly
        System.out.println();

        elevator.closeDoor();
    }
}

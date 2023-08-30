public class SpaceCraft {
    private int x;
    private int y;
    private int z;
    private String direction;

    public SpaceCraft(int initialX, int initialY, int initialZ, String initialDirection) {
        x = initialX;
        y = initialY;
        z = initialZ;
        direction = initialDirection;
    }

    public void moveForward() {
        switch (direction) {
            case "N":
                y++;
                break;
            case "S":
                y--;
                break;
            case "E":
                x++;
                break;
            case "W":
                x--;
                break;
            case "Up":
                z++;
                break;
            case "Down":
                z--;
                break;
        }
    }

    public void moveBackward() {
        switch (direction) {
            case "N":
                y--;
                break;
            case "S":
                y++;
                break;
            case "E":
                x--;
                break;
            case "W":
                x++;
                break;
            case "Up":
                z--;
                break;
            case "Down":
                z++;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case "N":
                direction = "W";
                break;
            case "S":
                direction = "E";
                break;
            case "E":
                direction = "N";
                break;
            case "W":
                direction = "S";
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "S":
                direction = "W";
                break;
            case "E":
                direction = "S";
                break;
            case "W":
                direction = "N";
                break;
        }
    }

    public void turnUp() {
        switch (direction) {
            case "N":
                direction = "Up";
                break;
            case "S":
                direction = "Down";
                break;
            case "E":
                direction = "Up";
                break;
            case "W":
                direction = "Down";
                break;
            case "Up":
                // No change
                break;
            case "Down":
                // No change
                break;
        }
    }

    public void turnDown() {
        switch (direction) {
            case "N":
                direction = "Down";
                break;
            case "S":
                direction = "Up";
                break;
            case "E":
                direction = "Down";
                break;
            case "W":
                direction = "Up";
                break;
            case "Up":
                // No change
                break;
            case "Down":
                // No change
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getDirection() {
        return direction;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] startingPosition = {0, 0, 0};
        String initialDirection = "N";
        String[] commands = {"f", "r", "u", "b", "l"};

        SpaceCraft craft = new SpaceCraft(startingPosition[0], startingPosition[1], startingPosition[2], initialDirection);

        for (String command : commands) {
            switch (command) {
                case "f":
                    craft.moveForward();
                    break;
                case "b":
                    craft.moveBackward();
                    break;
                case "l":
                    craft.turnLeft();
                    break;
                case "r":
                    craft.turnRight();
                    break;
                case "u":
                    craft.turnUp();
                    break;
                case "d":
                    craft.turnDown();
                    break;
            }
        }

        int finalX = craft.getX();
        int finalY = craft.getY();
        int finalZ = craft.getZ();
        String finalDirection = craft.getDirection();

        System.out.println("Final Position: (" + finalX + ", " + finalY + ", " + finalZ + ")");
        System.out.println("Final Direction: " + finalDirection);
    }
}

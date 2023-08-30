#include <iostream>
#include <vector>
#include <map>

using namespace std;

class SpaceCraft {
private:
    int x, y, z; // Galactic coordinates
    char direction; // N, S, E, W, Up, Down

    // Define a map to store direction changes based on left or right turn
    map<char, map<char, char>> directionChanges = {
        {'N', {{'l', 'W'}, {'r', 'E'}}},
        {'S', {{'l', 'E'}, {'r', 'W'}}},
        {'E', {{'l', 'N'}, {'r', 'S'}}},
        {'W', {{'l', 'S'}, {'r', 'N'}}},
        {'U', {{'l', 'N'}, {'r', 'S'}}},
        {'D', {{'l', 'S'}, {'r', 'N'}}}
    };

public:
    SpaceCraft(int startX, int startY, int startZ, char startDirection) {
        x = startX;
        y = startY;
        z = startZ;
        direction = startDirection;
    }

    void executeCommands(vector<char>& commands) {
        for (char command : commands) {
            if (command == 'f' || command == 'b') {
                move(command);
            } else if (command == 'l' || command == 'r') {
                rotate(command);
            } else if (command == 'u' || command == 'd') {
                changeAngle(command);
            }
        }
    }

    void move(char command) {
        if (command == 'f') {
            if (direction == 'N') y++;
            else if (direction == 'S') y--;
            else if (direction == 'E') x++;
            else if (direction == 'W') x--;
            else if (direction == 'U') z++;
            else if (direction == 'D') z--;
        } else if (command == 'b') {
            if (direction == 'N') y--;
            else if (direction == 'S') y++;
            else if (direction == 'E') x--;
            else if (direction == 'W') x++;
            else if (direction == 'U') z--;
            else if (direction == 'D') z++;
        }
    }

    void rotate(char command) {
        direction = directionChanges[direction][command];
    }

    void changeAngle(char command) {
        if (command == 'u') {
            if (direction == 'N' || direction == 'S') direction = 'U';
            else if (direction == 'U') direction = 'S';
            else if (direction == 'D') direction = 'N';
        } else if (command == 'd') {
            if (direction == 'N' || direction == 'S') direction = 'D';
            else if (direction == 'U') direction = 'N';
            else if (direction == 'D') direction = 'S';
        }
    }

    void printFinalPositionAndDirection() {
        cout << "Final Position: (" << x << ", " << y << ", " << z << ")" << endl;
        cout << "Final Direction: " << direction << endl;
    }
};

int main() {
    // Create a SpaceCraft object with initial position and direction
    SpaceCraft craft(0, 0, 0, 'N');

    // Example commands
    vector<char> commands = {'f', 'r', 'u', 'b', 'l'};

    // Execute the commands
    craft.executeCommands(commands);

    // Print the final position and direction
    craft.printFinalPositionAndDirection();

    return 0;
}

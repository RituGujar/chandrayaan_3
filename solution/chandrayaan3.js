// Define initial position, direction, and movement vectors
let position = [0, 0, 0];
let direction = 'N';
const directions = { N: [0, 1, 0], S: [0, -1, 0], E: [1, 0, 0], W: [-1, 0, 0], Up: [0, 0, 1], Down: [0, 0, -1] };

// Define functions to handle movement and rotation
function moveForward() {
  const vector = directions[direction];
  position = position.map((coord, index) => coord + vector[index]);
}

function moveBackward() {
  const vector = directions[direction].map(coord => -coord);
  position = position.map((coord, index) => coord + vector[index]);
}

function rotateLeft() {
  const order = ['N', 'W', 'S', 'E', 'N'];
  direction = order[order.indexOf(direction) + 1];
}

function rotateRight() {
  const order = ['N', 'E', 'S', 'W', 'N'];
  direction = order[order.indexOf(direction) + 1];
}

function rotateUp() {
  if (direction === 'N' || direction === 'S') {
    direction = 'Up';
  }
}

function rotateDown() {
  if (direction === 'N' || direction === 'S') {
    direction = 'Down';
  }
}

// Define a function to process commands
function executeCommands(commands) {
  for (const command of commands) {
    switch (command) {
      case 'f': moveForward(); break;
      case 'b': moveBackward(); break;
      case 'l': rotateLeft(); break;
      case 'r': rotateRight(); break;
      case 'u': rotateUp(); break;
      case 'd': rotateDown(); break;
    }
  }
}

// Example commands
const commands = ['f', 'r', 'u', 'b', 'l'];
executeCommands(commands);

// Output final position and direction
console.log('Final Position:', position);
console.log('Final Direction:', direction);

# MY SOLUTION

1. I start by performing tests on the given code
2. To begin, we extract the surface size variables, position, and direction of the rover into class properties and generate their setters and getters. At this point, we can start testing these properties.
3. To test the rover's behavior when receiving commands, we extract the command logic into another method of the class.
4. When testing the method that handles commands, we realize that the if statement managing the direction change is not entirely correct. The issue is resolved thanks to the tests performed.
5. Create Surface to encapsulate the size of the Mars surface and all the logic related to its boundaries (and the bonus placement of obstacles)
6. Create Coordinate to extract position of the Rover
7. Create Direction for extract direction of the Rover
8. Create Rover to manage position and direction within the Mars surface
9. Modify MarsRover to use Rover, Surface, Coordinate and Surface

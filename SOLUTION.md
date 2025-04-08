# MY SOLUTION

1. I start by performing tests on the given code
2. To begin, we extract the surface size variables, position, and direction of the rover into class properties and generate their setters and getters. At this point, we can start testing these properties.
3. To test the rover's behavior when receiving commands, we extract the command logic into another method of the class.
4. When testing the method that handles commands, we realize that the if statement managing the direction change is not entirely correct. The issue is resolved thanks to the tests performed.
5. Create MarsSurface to encapsulate encapsulate the size of the surface and all the logic related to its boundaries and the placement of obstacle

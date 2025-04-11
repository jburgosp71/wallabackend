# MY SOLUTION

1. Started by analyzing and writing tests for the provided code to understand the application
2. To begin, we extract the surface size variables, position, and direction of the rover into class properties and generate their setters and getters. At this point, we can start testing these properties.
3. To test the rover's behavior when receiving commands, we extract the command logic into another method of the class.
4. When testing the method that handles commands, we realize that the if statement managing the direction change is not entirely correct. The issue is resolved thanks to the tests performed.
5. Create Surface to encapsulate the size of the Mars surface and all the logic related to its boundaries (and the bonus placement of obstacles)
6. Create Coordinate to extract position of the Rover
7. Create Direction for extract direction of the Rover
8. Create Rover to manage position and direction within the Mars surface
9. Modify MarsRover to use Rover, Surface, Coordinate and Surface
10. Once the entities are created, we start applying DDD by placing each element in its corresponding layer and adding what is necessary.
11. For the Coordinate class, we include the move logic by applying deltas.
12. Convert Direction class to Enum class and included the movement's logic.
13. Convert Surface class to record because is always constant on application, included limits logic.
14. Create application layer with a command record and a UseCase tu use it
15. Create a infrastructure class CLI for introduce commands for console (in the future you can aggregate other inputs for control the rover, stream, file, database access, ...)
16. Rename the class MarsRover to MarsRoverApplication, which will be responsible for initializing the application.
17. Refactor class MarsRoverApplication for check correct inputs.
18. Change MarsRoverApplication adapting for future inputs, Dependency Inversion Principle with InputProvider, MarsRoverController
19. Change InputProvider to take external validators

TODO
- Extract obstacle logic into its own domain module to comply SRP (creating an Obstacle class) with all the logic.
- Enter the obstacles data dinamically (now is harcoded on MarsRoverBuilder), whith an obstacleProvider interface by example to give us the posibility to enter data from keyboard, file, ...
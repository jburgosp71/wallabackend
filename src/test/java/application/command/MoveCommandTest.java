package test.java.application.command;

import main.java.application.command.MoveCommand;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    private static Stream<Arguments> storeCommandProvider() {
        return Stream.of(
                Arguments.of(new MoveCommand('f'), 'f'),
                Arguments.of(new MoveCommand('b'), 'b'),
                Arguments.of(new MoveCommand('r'), 'r'),
                Arguments.of(new MoveCommand('l'), 'l')
        );
    }

    @ParameterizedTest
    @MethodSource("storeCommandProvider")
    void testMoveForwardAndBackward(MoveCommand initialCommand, char expectedCommand) {
        assertEquals(expectedCommand, initialCommand.instruction());
    }

}

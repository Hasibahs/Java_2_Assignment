import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    private InputHandler inputHandler;
    private ByteArrayOutputStream baos;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        // Simulate user input data as a string
        String simulatedUserInput = "Team A\nPlayer A\n1\n0\n0\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());

        // Prepare to capture the output data
        baos = new ByteArrayOutputStream();
        printStream = new PrintStream(baos);

        // Create an InputHandler instance with simulated input and output
        inputHandler = new InputHandler(bais, printStream);
    }

    @Test
    void testCreateTeam() {
        Team team = inputHandler.createTeam();
        assertEquals("Team A", team.getTeamName());
        assertTrue(baos.toString().contains("Enter the name of the team: "));
    }

    @Test
    void testCreatePlayer() {
        Player player = inputHandler.createPlayer();
        assertEquals("Player A", player.getPlayerName());
        assertTrue(baos.toString().contains("Enter the name of the player: "));
    }

    @Test
    void testAssignCardsToPlayer() {
        CardManager cardManager = new CardManager();
        Player player = new Player("Player A");

        inputHandler.assignCardsToPlayer(cardManager, player);
        assertEquals(1, player.getCardCount("YELLOW"));
        assertEquals(0, player.getCardCount("RED"));
        assertEquals(0, player.getCardCount("BLACK"));
        assertFalse(player.isDisqualified());

        // Check if the output contains the prompts for card numbers
        String output = baos.toString();
        assertTrue(output.contains("Enter the number of yellow cards for Player A: "));
        assertTrue(output.contains("Enter the number of red cards for Player A: "));
        assertTrue(output.contains("Enter the number of black cards for Player A: "));
    }

    // You can add more tests to check the behavior when different numbers of cards are entered
}

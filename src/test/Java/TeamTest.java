import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamTest {
    private Team team;

    @BeforeEach
    void setUp() {
        team = new Team("FC Testing");
    }

    @Test
    void testAddPlayer() {
        Player player = new Player("John Doe");
        team.addPlayer(player);
        assertEquals(1, team.getPlayers().size());
    }

    @Test
    void testGetFairPlayAwardPlayer() {
        Player player1 = new Player("John Doe");
        Player player2 = new Player("Jane Roe");
        player1.addCard("YELLOW"); // Use the correct method from Player class
        player2.addCard("RED");    // Use the correct method from Player class
        team.addPlayer(player1);
        team.addPlayer(player2);
        assertEquals(player1, team.getFairPlayAwardPlayer());
    }

    // Add more tests for other methods in Team class
}

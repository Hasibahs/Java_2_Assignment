import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardManagerTest {
    private CardManager cardManager;
    private Player player;

    @BeforeEach
    void setUp() {
        cardManager = new CardManager();
        player = new Player("John Doe");
    }

    @Test
    void testAddYellowCard() {
        cardManager.addYellowCard(player);
        assertEquals(1, player.getCardCount("YELLOW"));
    }

    @Test
    void testAddRedCard() {
        cardManager.addRedCard(player);
        assertEquals(1, player.getCardCount("RED"));
    }

    @Test
    void testAddBlackCard() {
        cardManager.addBlackCard(player);
        assertEquals(1, player.getCardCount("BLACK"));
        assertTrue(player.isDisqualified());
    }

    @Test
    void testCalculateFine() {
        cardManager.addYellowCard(player);
        cardManager.addRedCard(player);
        double expectedFine = 18.32 + 41.60; // Fine for one yellow and one red card
        assertEquals(expectedFine, cardManager.calculateFine(player));
    }

    @Test
    void testCalculateTotalTeamFine() {
        Team team = new Team("FC Testing");
        team.addPlayer(player);
        cardManager.addYellowCard(player);
        cardManager.addRedCard(player);
        double expectedTeamFine = 18.32 + 41.60; // Fine for one yellow and one red card
        assertEquals(expectedTeamFine, cardManager.calculateTotalTeamFine(team));
    }

}

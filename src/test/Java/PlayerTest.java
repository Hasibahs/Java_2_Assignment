import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("John Doe");
    }

    @Test
    void testPlayerInitialization() {
        assertEquals(0, player.getTotalCards());
        assertFalse(player.isDisqualified());
        assertEquals("John Doe", player.getPlayerName());
    }

    @Test
    void testAddYellowCard() {
        player.addCard("YELLOW");
        assertEquals(1, player.getCardCount("YELLOW"));
        assertFalse(player.isDisqualified());
    }

    @Test
    void testAddRedCard() {
        player.addCard("RED");
        assertEquals(1, player.getCardCount("RED"));
        assertFalse(player.isDisqualified());
    }

    @Test
    void testAddBlackCardDisqualifiesPlayer() {
        player.addCard("BLACK");
        assertTrue(player.isDisqualified());
        assertEquals(1, player.getCardCount("BLACK"));
    }

    @Test
    void testAddMultipleCards() {
        player.addCard("YELLOW");
        player.addCard("YELLOW");
        player.addCard("RED");
        assertEquals(2, player.getCardCount("YELLOW"));
        assertEquals(1, player.getCardCount("RED"));
        assertFalse(player.isDisqualified());

        player.addCard("BLACK");
        assertTrue(player.isDisqualified());
        assertEquals(1, player.getCardCount("BLACK"));
    }

    @ParameterizedTest
    @CsvSource({
            "YELLOW, 1, 0, 0",
            "RED, 0, 1, 0",
            "BLACK, 0, 0, 1",
            "YELLOW, 2, 0, 0"
    })
    void testAddCards(String cardType, int expectedYellow, int expectedRed, int expectedBlack) {
        addCardsByType(cardType, expectedYellow, expectedRed, expectedBlack);

        assertEquals(expectedYellow, player.getCardCount("YELLOW"), "Yellow cards count mismatch");
        assertEquals(expectedRed, player.getCardCount("RED"), "Red cards count mismatch");
        assertEquals(expectedBlack, player.getCardCount("BLACK"), "Black cards count mismatch");
    }

    private void addCardsByType(String cardType, int yellowCount, int redCount, int blackCount) {
        for (int i = 0; i < yellowCount; i++) {
            player.addCard("YELLOW");
        }
        for (int i = 0; i < redCount; i++) {
            player.addCard("RED");
        }
        for (int i = 0; i < blackCount; i++) {
            player.addCard("BLACK");
        }
    }
}

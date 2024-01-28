import org.junit.jupiter.api.BeforeEach;

class TeamManagerTest {
    private TeamManager teamManager;
    private Team team;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        teamManager = new TeamManager();
        team = new Team("FC Emmen");

        player1 = new Player("Player One");
        player2 = new Player("Player Two");
        player3 = new Player("Player Three");

        // Directly manipulate card counts for testing purposes
        player1.addCard("YELLOW");
        player2.addCard("RED");
        player3.addCard("BLACK"); // This should disqualify the player
    }

    @Test
    void testAddPlayerToTeam() {
        assertEquals(0, team.getPlayers().size());
        teamManager.addPlayerToTeam(team, player1);
        assertEquals(1, team.getPlayers().size());
        assertTrue(team.getPlayers().contains(player1));
    }

    @Test
    void testCalculateTotalTeamFine() {
        teamManager.addPlayerToTeam(team, player1);
        teamManager.addPlayerToTeam(team, player2);
        // Don't add player3 as they are disqualified, assuming disqualified players don't contribute to the fine.

        double expectedFine = (player1.getCardCount("YELLOW") * CardManager.FINE_YELLOW) +
                (player2.getCardCount("RED") * CardManager.FINE_RED);
        double actualFine = teamManager.calculateTotalTeamFine(team);
        assertEquals(expectedFine, actualFine, "The fines do not match.");
    }

    @Test
    void testGetFairPlayAwardPlayer() {
        teamManager.addPlayerToTeam(team, player1);
        teamManager.addPlayerToTeam(team, player2);
        // Player 3 is not added because they are disqualified

        assertEquals(player1, teamManager.getFairPlayAwardPlayer(team));
    }

    @Test
    void testGetFairPlayAwardPlayerWithNoPlayers() {
        assertNull(teamManager.getFairPlayAwardPlayer(team));
    }

    // Add more tests to cover additional scenarios and edge cases
}

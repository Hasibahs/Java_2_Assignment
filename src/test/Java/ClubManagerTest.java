import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClubManagerTest {
    private ClubManager clubManager;
    private Team teamA;
    private Team teamB;

    @BeforeEach
    void setUp() {
        clubManager = new ClubManager();
        teamA = new Team("Team A");
        teamB = new Team("Team B");
    }

    @Test
    void testAddTeam() {
        clubManager.addTeam(teamA);
        assertEquals(1, clubManager.getTeams().size());
        assertTrue(clubManager.getTeams().contains(teamA));
    }

    @Test
    void testGetTeam() {
        clubManager.addTeam(teamA);
        clubManager.addTeam(teamB);
        assertNotNull(clubManager.getTeam("Team A"));
        assertEquals("Team A", clubManager.getTeam("Team A").getTeamName());
        assertNull(clubManager.getTeam("Nonexistent Team"));
    }

    @Test
    void testGetTeams() {
        clubManager.addTeam(teamA);
        clubManager.addTeam(teamB);
        List<Team> teams = clubManager.getTeams();
        assertEquals(2, teams.size());
        assertTrue(teams.contains(teamA));
        assertTrue(teams.contains(teamB));
    }

}


import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Player> players;

    public Team(String name) {
        this.teamName = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getFairPlayAwardPlayer() {
        Player fairPlayPlayer = null;
        int minCards = Integer.MAX_VALUE;
        for (Player player : players) {
            if (!player.isDisqualified()) {
                int totalCards = player.getTotalCards();
                if (totalCards < minCards) {
                    minCards = totalCards;
                    fairPlayPlayer = player;
                }
            }
        }
        return fairPlayPlayer;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", players=" + players +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}

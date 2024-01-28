public class TeamManager {
    private CardManager cardManager = new CardManager();

    public void addPlayerToTeam(Team team, Player player) {
        team.addPlayer(player);
    }

    public double calculateTotalTeamFine(Team team) {
        double totalFine = 0;
        for (Player player : team.getPlayers()) {
            totalFine += cardManager.calculateFine(player);
        }
        return totalFine;
    }

    public Player getFairPlayAwardPlayer(Team team) {
        Player fairPlayPlayer = null;
        int minCards = Integer.MAX_VALUE;
        for (Player player : team.getPlayers()) {
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
}

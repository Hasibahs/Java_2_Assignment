public class CardManager {
    private static final double FINE_YELLOW = 18.32;
    private static final double FINE_RED = 41.60;
    private static final double FINE_BLACK = 349.76;

    public void addYellowCard(Player player) {
        player.addCard("YELLOW");
    }

    public void addRedCard(Player player) {
        player.addCard("RED");
    }

    public void addBlackCard(Player player) {
        player.addCard("BLACK");
        player.disqualify();
    }

    public double calculateFine(Player player) {
        int yellowCards = player.getCardCount("YELLOW");
        int redCards = player.getCardCount("RED");
        int blackCards = player.getCardCount("BLACK");

        return (yellowCards * FINE_YELLOW) + (redCards * FINE_RED) + (blackCards * FINE_BLACK);
    }

    public double calculateTotalTeamFine(Team team) {
        double totalFine = 0.0;
        for (Player player : team.getPlayers()) {
            totalFine += calculateFine(player);
        }
        return totalFine;
    }
}

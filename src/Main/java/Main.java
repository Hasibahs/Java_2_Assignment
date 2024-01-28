public class Main {
    public static void main(String[] args) {
        ClubManager clubManager = new ClubManager();
        CardManager cardManager = new CardManager();

        Team teamA = new Team("FC Emmen - Team A");
        populateTeamWithTestData(teamA, cardManager);
        clubManager.addTeam(teamA);

        Team teamB = new Team("FC Emmen - Team B");
        populateTeamWithTestData(teamB, cardManager);
        clubManager.addTeam(teamB);

        // Calculate fines and determine Fair Play Award for each team
        for (Team team : clubManager.getTeams()) {
            double totalFine = cardManager.calculateTotalTeamFine(team);
            Player fairPlayPlayer = team.getFairPlayAwardPlayer();

            System.out.println("Total fine for " + team.getTeamName() + " is: €" + String.format("%.2f", totalFine));
            System.out.print("Fair Play Award Winner in the team: ");
            if (fairPlayPlayer != null) {
                System.out.println(fairPlayPlayer.getPlayerName());
            } else {
                System.out.println("None");
            }
        }
    }

    private static void populateTeamWithTestData(Team team, CardManager cardManager) {
        Player player1 = new Player("Jordy");
        Player player2 = new Player("Jullian");
        Player player3 = new Player("Quinn");

        player1.addCard("YELLOW");
        player1.addCard("YELLOW");
        player2.addCard("RED");
        player3.addCard("BLACK");


        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
    }
}

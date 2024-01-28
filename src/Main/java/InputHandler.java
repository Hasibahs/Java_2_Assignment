import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

public class InputHandler {
    private final Scanner scanner;
    private final PrintStream out;

    public InputHandler(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public Team createTeam() {
        out.print("Enter the name of the team: ");
        String teamName = scanner.nextLine();
        return new Team(teamName);
    }

    public Player createPlayer() {
        out.print("Enter the name of the player: ");
        String playerName = scanner.nextLine();
        return new Player(playerName);
    }

    public void assignCardsToPlayer(CardManager cardManager, Player player) {
        System.out.print("Enter the number of yellow cards for " + player.getPlayerName() + ": ");
        int yellowCards = scanner.nextInt();

        System.out.print("Enter the number of red cards for " + player.getPlayerName() + ": ");
        int redCards = scanner.nextInt();

        System.out.print("Enter the number of black cards for " + player.getPlayerName() + ": ");
        int blackCards = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < yellowCards; i++) cardManager.addYellowCard(player);
        for (int i = 0; i < redCards; i++) cardManager.addRedCard(player);
        for (int i = 0; i < blackCards; i++) cardManager.addBlackCard(player);
    }
}

public class Player {
    private String name;
    private int yellowCards = 0;
    private int redCards = 0;
    private int blackCards = 0;
    private boolean isDisqualified = false;

    public Player(String name) {
        this.name = name;
    }

    public int getTotalCards() {
        return yellowCards + redCards + blackCards;
    }

    public void addCard(String cardType) {
        switch (cardType) {
            case "YELLOW":
                yellowCards++;
                break;
            case "RED":
                redCards++;
                break;
            case "BLACK":
                blackCards++;
                disqualify();
                break;
        }
    }

    public int getCardCount(String cardType) {
        return switch (cardType) {
            case "YELLOW" -> yellowCards;
            case "RED" -> redCards;
            case "BLACK" -> blackCards;
            default -> 0;
        };
    }

    public void disqualify() {
        isDisqualified = true;
    }

    public boolean isDisqualified() {
        return isDisqualified;
    }

    public String getPlayerName() {
        return name;
    }
}
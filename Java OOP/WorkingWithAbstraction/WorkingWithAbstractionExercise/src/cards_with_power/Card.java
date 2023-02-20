package cards_with_power;

public class Card {

    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower()   {
        return rank.getPower() + suit.getPower();
    }
}

package sk.stuba.fei.uim.oop.squares.cards;

public class Card {
    private final int priceChange;


    public int getPriceChange()
    {
        return priceChange;
    }

    public Card(int priceChange) {
        this.priceChange = priceChange;
    }
}

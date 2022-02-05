package sk.stuba.fei.uim.oop.squares;

import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.Prompter;
import sk.stuba.fei.uim.oop.squares.cards.Card;

import java.util.ArrayList;

public class Chance extends Square{
    private ArrayList<Card> cardList;

    private void initializeCards(){
        cardList = new ArrayList<>();
        cardList.add(new Card( -5000));
        cardList.add(new Card(40000));
        cardList.add(new Card(10000));
        cardList.add(new Card( -50000));
        cardList.add(new Card(-2000));
    }

    public Card getFirstCard(){
        Card pickedCard = this.cardList.get(0);
        this.cardList.remove(0);
        this.cardList.add(this.cardList.size(), pickedCard);
        return pickedCard;
    }

    public void resolveBankTransactions(Player player){
        Card pickedCard = getFirstCard();
        Prompter prompter = new Prompter();
        if(pickedCard.getPriceChange() < 0){
            player.payToBank(pickedCard.getPriceChange());
        }else {
            player.addMoney(pickedCard.getPriceChange());
        }
        prompter.bankTransactions(player,pickedCard);

    }

    public Chance() {
        super("Šanca");
        initializeCards();
    }

    @Override
    public void landedOnBy(Player player) {
        resolveBankTransactions(player);
        super.landedOnBy(player);
    }
}

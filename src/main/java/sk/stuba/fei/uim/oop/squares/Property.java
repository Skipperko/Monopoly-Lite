package sk.stuba.fei.uim.oop.squares;

import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.Prompter;

public class Property extends Square{
    private Player owner;
    private final int cost;
    private final int penalty;
    private final Prompter prompter;

    public Property(String name, Player owner, int cost, int penalty, Prompter prompter) {
        super(name);
        this.owner = owner;
        this.cost = cost;
        this.penalty = penalty;
        this.prompter = prompter;
    }

    public Player getOwner() {
        return owner;
    }

    public int getCost() {
        return cost;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public void landedOnBy(Player player) {
        super.landedOnBy(player);
        if(this.getOwner() == null || this.getOwner().getLost()) {
            attemptToBuy(player);
        }
        else {
            paymentToOwner(player);
        }
    }

    private void paymentToOwner(Player player) {
        if(this.getOwner() != player) {
            prompter.hasOwner(this);
            player.payToPlayer(this.owner, this.getPenalty());
        }
        else{
            prompter.yourProperty(player,this);
        }
    }

    private void attemptToBuy(Player player) {
        if (player.getMoney() < getCost()) {
            prompter.notEnoughMoney(player, this);
        }
        else {
            boolean answer = prompter.askToBuy(player, this);
            if (answer) {
                player.payToBank(this.getCost());
                this.setOwner(player);
            }
        }
    }

}

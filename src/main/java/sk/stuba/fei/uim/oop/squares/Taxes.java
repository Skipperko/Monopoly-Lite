package sk.stuba.fei.uim.oop.squares;

import sk.stuba.fei.uim.oop.Player;

public class Taxes extends Square{

    public Taxes(){
        super("Taxes");
    }

    @Override
    public void landedOnBy(Player player) {
        super.landedOnBy(player);
        player.payToBank(10000);
    }
}

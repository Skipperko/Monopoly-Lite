package sk.stuba.fei.uim.oop.squares;

import sk.stuba.fei.uim.oop.Player;

public class Start extends Square{
    public Start(){
        super("Start");
    }

    @Override
    public void landedOnBy(Player player) {
        super.landedOnBy(player);
        player.addMoney(20000);
    }
}

package sk.stuba.fei.uim.oop.squares;

import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.Prompter;

public class Police extends Square {
    private final Jail jail;
    private final int timeInJail;
    private final Prompter prompter;

    public Police(Jail jail, int timeInJail, Prompter prompter){
        super("Police");
        this.jail = jail;
        this.timeInJail = timeInJail;
        this.prompter = prompter;
    }

    @Override
    public void landedOnBy(Player player) {
        super.landedOnBy(player);
        player.setSquare(jail);
        player.setTimeInJail(timeInJail);
        prompter.playerInJail(player);
    }
}

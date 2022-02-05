package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.squares.*;

import java.util.List;

public class Gameboard {
    private List<Square> squares;
    private final Prompter prompter;
    private Start start;
    private Chance chance;

    public Gameboard(Prompter prompter) {
        this.prompter = prompter;
    }

    public Start getStart() {
        return start;
    }

    public void initializeSquares() {
        Jail jail = new Jail();
        start = new Start();
        chance = new Chance();

        squares = List.of(start,
                new Property("Obchodná ulica", null, 30000, 7000, prompter),
                new Property("Ufo", null, 45000, 20000, prompter),
                chance,
                new Property("Reduta", null, 17000, 8000, prompter),
                new Property("Polus", null, 50000, 22000, prompter),
                jail,
                new Property("SND", null, 45000, 17000, prompter),
                new Property("Trnavské mýto", null, 18000, 9000, prompter),
                chance,
                new Property("Modrý kostol", null, 33000, 11000, prompter),
                new Property("Slavín", null, 80000, 45000, prompter),
                new Taxes(),
                new Property("Michalská brána", null, 28000, 13000, prompter),
                new Property("Bratislavský hrad", null, 100000, 50000, prompter),
                chance,
                new Property("Hrad Devín", null, 90000, 40000, prompter),
                new Property("Volkswagen", null, 75000, 29000, prompter),
                new Police(jail, 3, prompter),
                new Property("Aupark", null, 55000, 19000, prompter),
                new Property("Avion", null, 65000, 24000, prompter),
                chance,
                new Property("Eurovea", null, 39000, 16000, prompter),
                new Property("Figaro", null, 60000, 48000, prompter));

    }

    public void newPositon(int diceRoll, Player player) {
        Square standingOn = player.getSquare();
        int initialPosition = squares.indexOf(standingOn);
        int updatedPosition = (initialPosition + diceRoll) % squares.size();
        Square newSquare = squares.get(updatedPosition);
        if (updatedPosition < initialPosition) {
            start.landedOnBy(player);
        }
        newSquare.landedOnBy(player);
    }
}

package sk.stuba.fei.uim.oop.squares;

import sk.stuba.fei.uim.oop.Player;

public class Square {
    private final String name;


    public Square(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void landedOnBy(Player player){
        player.setSquare(this);

    }
}

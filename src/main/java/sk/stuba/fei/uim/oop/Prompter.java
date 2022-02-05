package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.squares.Property;
import sk.stuba.fei.uim.oop.squares.cards.Card;

import java.util.Scanner;

public class Prompter {
    private final Scanner input = new Scanner(System.in);


    public boolean askToBuy(Player player, Property property) {
        System.out.println(player.getName() + " do you wan to buy " + property.getName() + " for " + property.getCost() + " euros? (Y/N)");
        String answer;
        while (true) {
            answer = input.nextLine();
            if (answer.equals("y") || answer.equals("Y")) {
                return true;
            } else if (answer.equals("n") || answer.equals("N")) {
                return false;
            }
            System.out.println("Wrong answer, try again.");
        }
    }
    public void notEnoughMoney(Player player, Property property){
        System.out.println("Sorry " + player.getName() + " you do not have enough money for " + property.getName());
    }

    public void hasOwner(Property property){
        System.out.println(property.getName() + " is taken by " + property.getOwner().getName());
        System.out.println("You paid " + property.getPenalty() + " to " + property.getOwner().getName());
    }

    public void yourProperty(Player player, Property property){
        System.out.println(player.getName() + " this is your property (" + property.getName() + ").");
    }

    public void bankTransactions(Player player, Card card){
        int amount = card.getPriceChange();
        if(amount < 0){
            amount = amount *-1;
            System.out.println(player.getName() + " paid " + amount + " to bank.");
        }
        else{
            System.out.println(player.getName() + " got " + amount + " from bank.");
        }
    }

    public void playerInJail(Player player){
        System.out.println(player.getName() + " is in Jail");
    }

}

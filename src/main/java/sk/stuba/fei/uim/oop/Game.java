package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final ArrayList<Player> players = new ArrayList<>();
    //private final Scanner input = new Scanner(System.in);
    private final Prompter prompter = new Prompter();
    private final Gameboard gameboard = new Gameboard(prompter);

    public int numberOfPlayers(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many players ? \n");
        while(true) {
            String answer;
            int result;
            try {
                answer = input.nextLine();
                result = Integer.parseInt(answer);
                return result;

            } catch (NumberFormatException exception) {
                System.out.println("Please type number.");
            }
        }

    }

    public void initializePlayers( int numberOfPlayers){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println((i+1) + ". name :");
            String playerNick = input.nextLine();
            Player newPlayer = new Player(playerNick,100000,0,null,false,i+1);
            players.add(newPlayer);
        }
    }

    public void runGame(){
        gameInitialization();
        gameLoop();
        gameEnding();
    }

    private void gameLoop() {
        while(arePlaying()) {
            for (Player player : this.players) {
                if(player.resolveIsOnTurn()){
                    System.out.println(player.getName() + "'s turn.");
                    gameboard.newPositon(diceRoll(player), player);
                }
            }
        }
    }

    private void gameEnding() {
        for (Player player : this.players){
            if(!player.getLost()){
                System.out.println(player.getName() + " won!");
            }
        }
    }

    //public void inJail()

    private void gameInitialization(){
       int totalPlayers = this.numberOfPlayers();
       this.initializePlayers(totalPlayers);
       this.gameboard.initializeSquares();
       for(Player player : this.players){
           player.setSquare(gameboard.getStart());
       }
    }

    public boolean arePlaying(){
        int alive = 0;
        for(Player player : this.players){
            if(!player.getLost()){
                alive += 1;
            }
        }
        return alive >= 2;
    }

    public int diceRoll(Player player){
        Random rand = new Random();
        int dice = rand.nextInt(6)+1;
        System.out.println(player.getName() + " rolled " + dice);
        return dice;
    }

}

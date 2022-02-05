package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.squares.Square;

public class Player {
    private final String name;
    private int money;
    private int timeInJail;
    private int id;
    private Square square;
    private boolean lost;

    public Player(){
        this.name = null;
        this.money = 0;
        this.timeInJail = 0;
        this.square = null;
        this.lost = false;
    }

    public Player(String name, int money, int timeInJail, Square square, boolean lost, int id){
        this.name = name;
        this.money = money;
        this.timeInJail = timeInJail;
        this.square = square;
        this.lost = lost;
        this.id = id;
    }

    public void payToPlayer(Player player, int money){
        if(this.getMoney() < money){
            player.addMoney(this.getMoney());
            this.takeMoney(this.getMoney());
            this.lose();
        }
        else{
            player.addMoney(money);
            this.takeMoney(money);
        }
    }

    public void setSquare(Square square){

        this.square = square;
    }

    public Square getSquare(){

        return this.square;
    }

    public void lose(){

        this.lost = true;
    }

    public boolean getLost(){

        return this.lost;
    }

    public int getId(){

        return this.id;
    }

    public String getName(){

        return this.name;
    }

    public int getMoney(){

        return this.money;
    }

    public int getTimeInJail(){

        return this.timeInJail;
    }

    public void addMoney(int money){

        this.money += money;
    }

    private void takeMoney(int money){

        this.money -= money;
    }

    public void setTimeInJail(int timeInJail){

        this.timeInJail = timeInJail;
    }

    public String toString(){
            return "Player name : " + this.getName() +
                    "\nMoney : " + this.getMoney() + "\nJail : " +
                    this.getTimeInJail() + "\nId : " + this.getId() +
                    "\nPosition : " + this.getSquare() +
                    "\nGame over : " + this.getLost() + "\n";
    }

    public boolean resolveIsOnTurn(){
        if(this.getLost()){
            return false;
        }
        if(this.timeInJail > 0){
            this.setTimeInJail(this.timeInJail-1);
            return false;
        }
        return true;
    }

    public void payToBank(int money){
        if(this.getMoney() > money){
            this.takeMoney(money);
        }
        else{
            this.takeMoney(this.getMoney());
            this.lose();
        }
    }

}

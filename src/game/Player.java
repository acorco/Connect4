package game;

public class Player {
    private String name;
    private char symbol;

    public Player(String name){
        this.name = name;
        this.symbol = name.charAt(0);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public char getSymbol(){
        return symbol;
    }

    public void copy(Player object){
        this.name = object.name;
        this.symbol = object.name.charAt(0);
    }
}

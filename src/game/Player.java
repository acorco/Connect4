package game;

import utils.Color;

public class Player implements Comparable<Player> {
    private String _name;
    private Color _color;
    private int _points;

    public Player(String name, Color color) {
        this._name = name;
        this._color = color;
        this._points = 0;

    }

    public Color getColor(){
        return _color;
    }

    public void setColor(Color color){
        this._color = color;
    }

    public String getName(){
        return _name;
    }

    public int getPoints(){
        return this._points;
    }


    @Override
    public int compareTo(Player player) {
        return this._points - player.getPoints();
    }
}

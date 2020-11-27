package game;

import utils.Color;

public class Player {
    private String _name;
    private Color _color;

    public Player(String name, Color color) {
        this._name = name;
        this._color = color;

    }

    public Color getColor(){
        return _color;
    }

    public String getName(){
        return _name;
    }
}

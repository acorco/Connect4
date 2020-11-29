package game;

import utils.Color;
import utils.Logger;

public class Cell {
    private Player _player;
    private boolean _won;

    public void draw(){
        if (_player == null){
            System.out.printf("%2c |", ' ');
        }else{
            Logger.printf(_won ? Color.MAGENTA_BOLD : _player.getColor(),"%2c ", 'X');
            System.out.print('|');
        }

    }

    public Player getPlayer(){
        return this._player;
    }

    public void setPlayer(Player player) {
        this._player = player;
    }

    public void setWon() {
        _won = true;
    }
}

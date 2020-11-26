package game;

import utils.Color;
import utils.Logger;



public class Cell {
    private CellContent _content;


    public Cell(){
        _content = CellContent.EMPTY;
    }

    public void draw(){
        if (_content == CellContent.EMPTY){
            System.out.printf("%2c |", ' ');
        }else{
            Logger.printf(Color.CYAN_BOLD,"%2c ", 'X');
            System.out.print('|');
        }

    }

    public CellContent getContent(){
        return this._content;
    }

    public void setContent(CellContent content) {
        _content = content;
    }
}

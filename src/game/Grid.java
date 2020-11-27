package game;

import utils.Logger;
import utils.Color;


/* Función de la clase: Esta clase es la de la cuadrícula entera.
   Se usará para instanciarla como tablero del juego.
 */
public class Grid {
    private final int _w; // constante width
    private final int _h; // constante height
    private final Cell[][] _grid; //declaración de un array de celdas


    // Constructor de classe.
    public Grid(int w, int h) {
        _grid = this._createGrid(w,h);
        _w = w;
        _h = h;
    }


    // Métode per a crear el grid
    private Cell[][] _createGrid(int w, int h) {
        Cell[][] grid = new Cell[w][h];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell();
            }
        }
        return grid;
    }

    // Métode per a crear un separador amb guions
    private void _separator() {
        System.out.println(new String(new char[_w * 4 + 4]).replace("\0", "—"));
    }


    // Métode que mostra el grid
    public void draw() {
        _separator();

        System.out.printf("%2c |", 'X');
        for (int x = 0; x < _w; x++) {
            System.out.printf("%2d |", x + 1);
        }

        System.out.println();
        _separator();

        for (int x = 0; x < _w; x++) {
            System.out.printf("%2d |", x+1);
            for (int y = 0; y < _h; y++) {
                _grid[x][y].draw();
            }
            System.out.println();
            _separator();
        }
    }


    // Métode per a insertar una fitxa en una columna del grid
    public void insert(int col, Player player) throws Exception {
        this.validateColumn(col);
        col -= 1;
        for (int row = _grid.length-1; row >= 0; row--){
            if(_grid[row][col].getPlayer() == null){
                _grid[row][col].setPlayer(player);
                return;
            }
        }
        throw new Exception("Aquesta columna està plena.");
    }

    // Métode per a validar si la columna existeix en el grid o no.
    private void validateColumn(int col) throws Exception {
        if(col <= 0 || col > _w){
            throw new Exception("Aquesta columna no existeix.");
        }
    }
}


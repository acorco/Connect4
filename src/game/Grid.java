package game;

public class Grid {
    private final int _w;
    private final int _h;
    private final Cell[][] _grid;

    public Grid(int w, int h) {
        _grid = this._createGrid(w,h);
        _w = w;
        _h = h;
    }

    private Cell[][] _createGrid(int w, int h) {
        Cell[][] grid = new Cell[w][h];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell();
            }
        }
        return grid;
    }

    private void _separator() {
        System.out.println(new String(new char[_w * 4 + 4]).replace("\0", "—"));
    }

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
}


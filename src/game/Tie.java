package game;

public class Tie {
    public static boolean validate(Cell[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getPlayer() == null){
                    return false;
                }
            }
        }
        return true;
    }
}

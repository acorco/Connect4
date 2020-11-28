package game;

import utils.Color;

import java.util.HashMap;
import java.util.TreeMap;

public class PlayerManager {
    final private HashMap<String, Player> _players;

    public PlayerManager() {
        _players = new HashMap<>();
    }

    public Player createPlayer(String name) {
        name = name.trim().toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        if (!_players.containsKey(name)) {
            _players.put(name, new Player(name, Color.WHITE_BOLD));
        }
        return  _players.get(name);
    }

    public TreeMap<String, Player> getRanking(){
        return new TreeMap<>(_players);
    }
}

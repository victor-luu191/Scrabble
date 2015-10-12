import java.util.Set;

/**
 * All three valid moves (Pass, Exchange and PlayTiles) can be represented by components:
 * (i) set of removed tiles: from player's hand, and go to either bag (Exchange) or board (PlayTiles) 
 * (ii) set of drawn tiles:  from bag
 * 
 * Pre-conditions:
 * (i) 	Drawing tiles is to compensate for removed tiles (st a player always have 7 tiles in hand, 
 * 		except for last turns in game), 
 * 		thus the two sets must have the same size
 * (ii) Pass is a special move where both sets are empty 
 * 
 * @author mdluu.2011
 *
 */
class Move {
	
	boolean isExchange;		// to distinguish Exchange from PlayTiles
	Set<Cell> cellsToPut; 	// need for PlayTiles move
	Set<Tile> removedTiles;
	Set<Tile> drawnTiles;	// drawn randomly from remaining tiles in bag
	
	public Move(Set<Tile> removedTiles, Set<Tile> drawnTiles) {
		
		if (removedTiles.size() == drawnTiles.size()) {
			this.removedTiles = removedTiles;
			this.drawnTiles = drawnTiles;
		} else {
			System.err.println("Number of tiles drawn from bag is not equal to "
					+ "number of tiles removed from hand!!!");
			System.exit(-1);
		}
	}
	
}

package main;
import java.util.Set;

/**
 * All three valid moves (Pass, Exchange and PutTiles) can be represented by components:
 * (i) set of removed tiles: from player's hand, and go to either bag (Exchange) or board (PutTiles) 
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
	
	String type;
	Set<Cell> cellsToPut; 	// need for PutTiles move
	Set<Tile> removedTiles;
	Set<Tile> drawnTiles;	// drawn randomly from remaining tiles in bag
	
	public Move(String type, Set<Cell> cellsToPut, Set<Tile> removedTiles,
			Set<Tile> drawnTiles) {
		
		this.type = type;
		this.cellsToPut = cellsToPut;
		this.removedTiles = removedTiles;
		this.drawnTiles = drawnTiles;
	}


	
}

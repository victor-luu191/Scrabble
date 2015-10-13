package main;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for creating different types of move: Pass, Exchange or PutTiles
 * 
 * Preconditions:
 * Drawn tiles is to compensate for removed tiles (st a player always have 7 tiles in hand, 
 * except for last turns in game), 
 * thus the two sets must have the same size
 * 
 * @author mdluu.2011
 *
 */
public class MoveFactory {
	
	private Move createPassMove() {
		String type = "Pass";
		// Pass = do nothing
		Set<Cell> cellsToPut = new HashSet<>();
		Set<Tile> removedTiles = new HashSet<>();
		Set<Tile> drawnTiles = new HashSet<>();
		
		return new Move(type, cellsToPut, removedTiles, drawnTiles);
	}
	
	private Move createExchangeMove(Set<Tile> removedTiles, Set<Tile> drawnTiles) {
		if (canExchange(removedTiles, drawnTiles)) {
			String type = "Exchange";
			Set<Cell> cellsToPut = new HashSet<>();
			return new Move(type, cellsToPut, removedTiles, drawnTiles);
		} else {
			System.err.println("cannot exchange because number of removed tiles is diff from number of drawn tiles!");
			return null;
		}
	}
	
	private boolean canExchange(Set<Tile> removedTiles, Set<Tile> drawnTiles) {
		return removedTiles.size() == drawnTiles.size();
	}

	private Move createPutTilesMove(Set<Tile> removedTiles, Set<Cell> cellsToPut, 
									Set<Tile> drawnTiles) {
		
		String type = "Put tiles";
		return new Move(type, cellsToPut, removedTiles, drawnTiles);
	}
}

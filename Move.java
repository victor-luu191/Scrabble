import java.util.Set;


class Move {
	Set<Tile> removedTiles;
	Set<Tile> drawnTiles;	// drawn randomly from remaining tiles in bag
	
	public Move(Set<Tile> removedTiles, Set<Tile> drawnTiles) {
		
		this.removedTiles = removedTiles;
		this.drawnTiles = drawnTiles;
	}
	
}

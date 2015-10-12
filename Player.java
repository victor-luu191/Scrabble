import java.util.Set;


class Player {
	Tile[] tiles_in_hand;
	boolean firstPlayer;
	
//	 pass()
	
	void exchange(Tile[] tiles, Set<Tile> tilesInBag ) {
		// TODO
	}

	/**
	 * find the best move depending on {@code boardState} and his {@code tiles_in_hand}
	 * @param boardState
	 * @return
	 */
	Move findBestMove(BoardState boardState) {
		// TODO Auto-generated method stub
		return null;
	}

	Set<CellWithTile> play(Move move, Set<Tile> tilesInBag) {
		// TODO Auto-generated method stub
		
		Set<Tile> drawnTiles = move.drawnTiles;
		if (drawnTiles.size() > 0) {
			
			p.addToHand(drawnTiles);
			tilesInBag = SetUtil.difference(tilesInBag, drawnTiles);
		}
		
		return null;
	}
	
	
}

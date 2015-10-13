package main;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;


public class Player {
	
	public int order;
	public List<Tile> tiles_in_hand;
	public Random tileDrawer;
	
	public Player(int order, List<Tile> tiles_in_hand) {
		this.order = order;
		this.tiles_in_hand = tiles_in_hand;
		this.tileDrawer = new Random();
	}

	/**
	 * Basic actions of a player 
	 * (i) draw tiles from the bag
	 * (ii) move tiles from hand into the bag
	 * (iii) put tiles in hand to certain cells on the board
	 */
	
	public List<Tile> drawFromBag(List<Tile> tiles_in_bag, int n) {
		if (tiles_in_bag.size() < n) {
			System.err.println("not enough tiles in bag for drawing");
			return null;
		} else {
			IntStream indices = tileDrawer.ints(n, 0, tiles_in_bag.size());
//			indices.map(i -> tiles_in_bag.get(i)); google way to do this correctly
			
			List<Tile> drawnTiles = new ArrayList<>();
			OfInt iter = indices.iterator();
			while (iter.hasNext()) {
				int index = iter.nextInt();
				drawnTiles.add(tiles_in_bag.get(index));
			}
			tiles_in_bag.removeAll(drawnTiles);
			return drawnTiles;
		}
	}
	
	// pre: tiles is a subset of tiles_in_hand
	public void moveFromHandToBag(List<Tile> tiles, List<Tile> tiles_in_bag) {

		if (! isInHand(tiles)) {
			System.err.println("moving some tiles not in hand, sth wrong!");
		} else {
			tiles_in_bag.addAll(tiles);
			tiles_in_hand.removeAll(tiles);
		}
	}

	private boolean isInHand(List<Tile> tiles) {
		return tiles_in_hand.containsAll(tiles);
	}
	
	// pre: the cell must be empty
	void moveFromHand2Cell(Tile tile, Cell cell, BoardState boardState) {
		if (!boardState.emptyCells.contains(cell)) {
			System.err.println("The cell is occupied, cannot move!");
		} else {
			tiles_in_hand.remove(tile);
			CellWithTile occupied_cell = new CellWithTile(cell, tile);
			boardState.occupiedCells.add(occupied_cell);
			boardState.emptyCells.remove(cell);
		}
	}
	// End of basic actions ==========================================================
	
	
	/**
	 * pre: (i) #cells = #tiles
	 * (ii) tiles is a subset of tiles_in_hand
	 * (iii) most important, the cells must be empty
	 * @param tiles
	 * @param cells
	 * @return
	 */
	private boolean moveFromHandToCells(Set<Tile> tiles, Set<Cell> cells, BoardState boardState) {
		
		// TODO Auto-generated method stub
		if (canMove(tiles, cells, boardState)) {
			
		} else {

		}
		
		return false;
	}

	private boolean canMove(Set<Tile> tiles, Set<Cell> cells, BoardState boardState) {
		return cells.size() == tiles.size() && tiles_in_hand.containsAll(tiles) && 
				boardState.emptyCells.containsAll(cells);
	}
	
	void exchange(List<Tile> tilesToExchange, List<Tile> tiles_in_bag) {
		int n = tilesToExchange.size();
		List<Tile> drawnTiles = drawFromBag(tiles_in_bag, n);
		if (drawnTiles == null) {
			System.out.println("cannot exchange!");
		} else {
			moveFromHandToBag(tilesToExchange, tiles_in_bag);
		}
	}
	
//	void playTiles(Set<Tile> played_tiles, Set<Cell> cells, List<Tile> tiles_in_bag) {
//		if (!moveFromHandToCells(played_tiles, cells)) {
//			System.out.println("cannot put the tiles to the cells, sth wrong!");
//		} else {
//			int n = played_tiles.size();
//			drawFrom(tiles_in_bag, n);
//		}
//	}
	
	/**
	 * find the best move depending on {@code boardState} and his {@code tiles_in_hand}
	 * @param boardState
	 * @return
	 */
	Move findBestMove(BoardState boardState) {
		// TODO Auto-generated method stub
		return null;
	}

	Set<CellWithTile> play(Move bestMove) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}

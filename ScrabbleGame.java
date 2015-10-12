import java.util.Set;


public class ScrabbleGame {

	static int numPlayers;
	static Player[] players;
	
	static Set<Tile> tilesInBag;
	static BoardState boardState;
	
	public static void main(String[] args) {
		
		players = distributeTiles(numPlayers);
		boolean endOfGame = false;
		while (! endOfGame) {
			for (Player p : players) {
				Move bestMove = p.findBestMove(boardState);
				Set<CellWithTile> cellsPlayerOccuppy = p.play(bestMove, tilesInBag);
				update(boardState, cellsPlayerOccuppy);

				//	TODO: endOfGame = checkIfEndOfGame();
			}
		}
	}

	private static void update(BoardState boardState,
			Set<CellWithTile> cellsPlayerOccuppy) {
		
		// TODO Auto-generated method stub
		
	}

	private static Player[] distributeTiles(int numPlayers) {
		// TODO Auto-generated method stub
		return null;
	}

}

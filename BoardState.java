import java.util.Set;


class BoardState {
	Set<CellWithTile> occupiedCells;
	Set<Cell> emptyCells;	//= all cells excluding occupiedCells
	
	public BoardState(Set<CellWithTile> occupiedCells) {
		
		this.occupiedCells = occupiedCells;
		// TODO: exclude occupied cells to get remaining empty cells 
	}
	
}

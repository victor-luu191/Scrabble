
public class CellWithTile extends Cell {

	Tile tile;
	
	public CellWithTile(int row, ColIndex col, Multiplier multiplier, Tile tile) {
		super(row, col, multiplier);
		this.tile = tile;
	}
	
}

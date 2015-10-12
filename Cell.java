
public class Cell {
	int row;
	ColIndex col;
	Multiplier multiplier;
	
	public Cell(int row, ColIndex col, Multiplier multiplier) {
		super();
		this.row = row;
		this.col = col;
		this.multiplier = multiplier;
	}

	@Override
	public String toString() {
		return "Cell [row=" + row + ", col=" + col + ", multiplier="
				+ multiplier + "]";
	}
	
	
}

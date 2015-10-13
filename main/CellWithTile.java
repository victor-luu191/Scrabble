package main;

public class CellWithTile extends Cell {

	Tile tile;
	
	public CellWithTile(int row, ColIndex col, Multiplier multiplier, Tile tile) {
		super(row, col, multiplier);
		this.tile = tile;
	}

	public CellWithTile(Cell cell, Tile tile) {
		super(cell.row, cell.col, cell.multiplier);
		this.tile = tile;
	}
	
}

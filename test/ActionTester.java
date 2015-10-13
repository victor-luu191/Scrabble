package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Tile;

class ActionTester {
	
	Tile[] tiles = {Tile.S1, Tile.C3, Tile.R1, Tile.A1, Tile.B3, Tile.L1, Tile.E1};
	
	void testDrawFromBag() {
		
		List<Tile> tiles_in_bag = new ArrayList<>();
		tiles_in_bag.addAll(copies(Tile.E1, 12));
	}
	
	List<Tile> copies(Tile tile, int n) {

		Tile[] copies = new Tile[n];
		Arrays.fill(copies, 0, n, tile);
		return Arrays.asList(copies);
	}
}

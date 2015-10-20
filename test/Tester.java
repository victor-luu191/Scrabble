package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import main.Player;
import main.Tile;

import org.junit.Test;

import preprocess.Builder;
import preprocess.Reader;

public class Tester {
	
	private List<Tile> testBag;
	private Player testPlayer;

	public Tester() {
		
		testBag = makeBag();
		testPlayer = makePlayer();
	}

//	@Test
//	public void testDrawFromBag() {
//		
//		List<Tile> drawn_tiles = testPlayer.drawFromBag(testBag, 10);
//		assert(drawn_tiles.size() == 10);
//		System.out.println("drawn tiles: " + drawn_tiles.toString());
//		assert(testBag.size() == 20);
//		
//		testPlayer.drawFromBag(testBag, 25);
//	}// passed
	
//	@Test
//	public void testMoveFromHandToBag() {
//		List<Tile> tiles_in_hand = testPlayer.tiles_in_hand;
//		int n = 1;
//		List<Tile> removedTiles = tiles_in_hand.subList(0, n);
//		System.out.println("tiles to be removed: " + removedTiles.toString());
//		
//		int bag_size_bf_add = testBag.size();
//		testPlayer.moveFromHandToBag(removedTiles, testBag);
//		int bag_size_after_add = testBag.size();
//		
//		assert(tiles_in_hand.size() == 7-n);
//		assert(bag_size_after_add - bag_size_bf_add == n);
//		
//		System.out.println("player's hand after removing: " + tiles_in_hand.toString());
//		System.out.println("bag after added tiles from player's hand: " + testBag.toString());
//		
//	}
	
	@Test
	public void testBuilders() {
		try {
			List<String> original_dict = Reader.readDict("words.txt");
			Builder builder = new Builder();
			builder.buildSortedDict(original_dict);
			String str = "words";
			char[] letters = str.toCharArray(); 
			
			System.out.println("letters " + Arrays.toString(letters) + " can form following words");
			System.out.println(builder.wordsCreatedBy(letters, original_dict));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Player makePlayer() {
		Tile[] tiles = {Tile.A1, Tile.S1, Tile.C3, Tile.R1,  Tile.B3, Tile.L1, Tile.E1};
		List<Tile> tiles_in_hand = Arrays.asList(tiles);
		return new Player(1, tiles_in_hand);
	}
	
	private List<Tile> makeBag() {
		List<Tile> tiles_in_bag = new ArrayList<>();
		tiles_in_bag.addAll(copies(Tile.E1, 12));
		tiles_in_bag.addAll(copies(Tile.A1, 9));
//		tiles_in_bag.addAll(copies(Tile.I1, 9));
		return tiles_in_bag;
	}
	
	List<Tile> copies(Tile tile, int n) {

		Tile[] copies = new Tile[n];
		Arrays.fill(copies, 0, n, tile);
		return Arrays.asList(copies);
	}
}

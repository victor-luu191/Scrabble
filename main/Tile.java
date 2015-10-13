package main;

public enum Tile {
	
	A1('A',1), E1('E',1), I1('I',1), O1('O',1), U1('U',1), 
	N1('N',1), R1('R',1), T1('T',1), L1('L',1), S1('S',1),
	D2('D',2), G2('G',2), 
	B3('B',3), C3('C',3), M3('M',3), P3('P',3),
	F4('F',4), H4('H',4), V4('V',4), W4('W',4), Y4('Y',4),
	K5('K',5),
	J8('J',8), X8('X',8),
	Q10('Q', 10), Z10('Z',10);
	
	
	Character letter;
	int point;
	
	Tile(Character letter, int point) {
		this.letter = letter;
		this.point = point;
	}
	
}

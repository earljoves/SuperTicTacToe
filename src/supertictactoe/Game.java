package supertictactoe;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Game {
	// 0 | 1 | 2
	// ---------
	// 3 | 4 | 5
	// ---------
	// 6 | 7 | 8
	private ArrayList<Piece> pieces;

	public Game() {
		pieces = new ArrayList<Piece>();
	}

	public boolean isGameOver() {
		Piece pieceOne = null;
		Piece pieceTwo = null;
		Piece pieceThree = null;
		// check columns
		for (int i = 0; i <= 2; i++) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 3);
			pieceThree = pieces.get(i + 6);
			if (!(pieceOne == null || pieceTwo == null || pieceThree == null)) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX())
					return true;
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO())
					return true;
			}
		}

		// check rows
		for (int i = 0; i <= 2; i++) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 1);
			pieceThree = pieces.get(i + 2);
			if (!(pieceOne == null || pieceTwo == null || pieceThree == null)) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX())
					return true;
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO())
					return true;
			}
		}

		// check diagonals
		// TODO: implement functionality
		return false;
	}

	public void setPiecesArray(Location startLocation, Grid<Piece> grid) {
		int startRow = startLocation.getRow();
		int startCol = startLocation.getCol();
		for (int row = startRow; row <= startRow + 2; row++) {
			for (int col = startCol; col <= startCol + 2; col++) {
				pieces.add(grid.get(new Location(row, col)));
			}
		}
	}

	public ArrayList<Piece> getPiecesArray() {
		return pieces;
	}
}

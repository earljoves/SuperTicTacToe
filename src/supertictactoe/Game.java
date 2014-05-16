package supertictactoe;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
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
		fillWithPieces();
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
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
					pieceOne.setColor(Color.CYAN);
					pieceTwo.setColor(Color.CYAN);
					pieceThree.setColor(Color.CYAN);
					return true;
				}
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
					pieceOne.setColor(Color.PINK);
					pieceTwo.setColor(Color.PINK);
					pieceThree.setColor(Color.PINK);
					return true;
				}
			}
		}

		// check rows
		for (int i = 0; i <= 2; i++) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 1);
			pieceThree = pieces.get(i + 2);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
					pieceOne.setColor(Color.CYAN);
					pieceTwo.setColor(Color.CYAN);
					pieceThree.setColor(Color.CYAN);
					return true;
				}
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
					pieceOne.setColor(Color.PINK);
					pieceTwo.setColor(Color.PINK);
					pieceThree.setColor(Color.PINK);
					return true;
				}
			}
		}

		// check diagonals
		int i = 0;
		pieceOne = pieces.get(i);
		i += 4;
		pieceTwo = pieces.get(i);
		i += 4;
		pieceThree = pieces.get(i);
		if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree.isBlank())) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				pieceOne.setColor(Color.CYAN);
				pieceTwo.setColor(Color.CYAN);
				pieceThree.setColor(Color.CYAN);
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				pieceOne.setColor(Color.PINK);
				pieceTwo.setColor(Color.PINK);
				pieceThree.setColor(Color.PINK);
				return true;
			}
		}

		i = 2;
		pieceOne = pieces.get(i);
		i += 2;
		pieceTwo = pieces.get(i);
		i += 2;
		pieceThree = pieces.get(i);
		if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree.isBlank())) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				pieceOne.setColor(Color.CYAN);
				pieceTwo.setColor(Color.CYAN);
				pieceThree.setColor(Color.CYAN);
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				pieceOne.setColor(Color.PINK);
				pieceTwo.setColor(Color.PINK);
				pieceThree.setColor(Color.PINK);
				return true;
			}
		}
		return false;
	}

	public void getArrayIndex(Location location) {

	}

	public void setPiecesColor() {
		// TODO: implement functionality

	}

	public void fillWithPieces() {
		for (int i = 0; i < pieces.size(); i++) {
			pieces.add(i, new Piece(""));
		}
	}

	public void setGameArray() {

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
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
	private int gameNumber;

	public Game(Location location) {
		pieces = new ArrayList<Piece>();
		fillWithPieces("");
		gameNumber = getGameNumber(location);
		setValues();
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

	public void setPiecesColor() {
		// TODO: implement functionality

	}

	public void fillWithPieces(String s) {
		for (int i = 0; i < pieces.size(); i++) {
			pieces.add(i, new Piece(""));
		}
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

	public int getGameNumber(Location loc) {
		int gameNumber = 0;
		int row = loc.getRow();
		int col = loc.getCol();
		if (row >= 0 && row <= 2) {
			if (col >= 0 && col <= 2) {
				gameNumber = 0;
			} else if (col >= 4 && col <= 6) {
				gameNumber = 1;
			} else if (col >= 8 && col <= 10) {
				gameNumber = 2;
			}
		} else if (row >= 4 && row <= 6) {
			if (col >= 0 && col <= 2) {
				gameNumber = 3;
			} else if (col >= 4 && col <= 6) {
				gameNumber = 4;
			} else if (col >= 8 && col <= 10) {
				gameNumber = 5;
			}
		} else if (row >= 8 && row <= 10) {
			if (col >= 0 && col <= 2) {
				gameNumber = 6;
			} else if (col >= 4 && col <= 6) {
				gameNumber = 7;
			} else if (col >= 8 && col <= 10) {
				gameNumber = 8;
			}
		}
		return gameNumber;
	}

	public void setValues() {
		for (Piece piece : pieces) {
			piece.setValue(Integer.toString(gameNumber));
		}
	}

	public void addPiece(Piece piece, int arrayIndex) {
		pieces.add(arrayIndex, piece);
	}

	public void setGameNumber(int number) {
		gameNumber = number;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public ArrayList<Piece> getPiecesArray() {
		return pieces;
	}
}